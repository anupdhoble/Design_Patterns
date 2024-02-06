import java.io.*;
import java.net.*;

// Component Interface
interface MessageReceiver {
    String receiveMessage() throws IOException;
}

// Concrete Component
class BasicMessageReceiver implements MessageReceiver {
    private BufferedReader reader;

    BasicMessageReceiver(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public String receiveMessage() throws IOException {
        return reader.readLine();
    }
}

// Decorator
class ReversedMessageReceiverDecorator implements MessageReceiver {
    private MessageReceiver messageReceiver;

    ReversedMessageReceiverDecorator(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    @Override
    public String receiveMessage() throws IOException {
        String receivedMessage = messageReceiver.receiveMessage();
        return new StringBuilder(receivedMessage).reverse().toString();
    }
}

// Server
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7000);

            while (true) {
                System.out.println("Waiting for client...");
                Socket clientSocket = serverSocket.accept();


                MessageReceiver basicMessageReceiver = new BasicMessageReceiver(clientSocket);


                MessageReceiver reversedMessageReceiver = new ReversedMessageReceiverDecorator(basicMessageReceiver);


                
                String reversedMessage = reversedMessageReceiver.receiveMessage();
                System.out.println("Received Message: " + reversedMessage);

                // Close the socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
