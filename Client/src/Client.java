import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// Step 1: Builder Interface
interface MessageBuilder {
    MessageBuilder addIPAddress(String ipAddress);
    MessageBuilder addContent(String content);
    String build();
}

// Step 2: Concrete Builder
class ClientMessageBuilder implements MessageBuilder {
    private String ipAddress;
    private String content;

    public MessageBuilder addIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public MessageBuilder addContent(String content) {
        this.content = content;
        return this;
    }

    public String build() {
        return "msg start at start:" + content + " from " + ipAddress;
    }
}

// Step 4: Product
class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Client Code
public class Client {
    private Socket socket = null;
    private DataOutputStream out = null;

    public Client(String serverAddress, int serverPort, String clientIPAddress) {
        try {
            socket = new Socket(serverAddress.trim(), serverPort);
            System.out.println("Connected to Server");

            out = new DataOutputStream(socket.getOutputStream());

            // Using Builder to create a message
            MessageBuilder messageBuilder = new ClientMessageBuilder();
            String message = messageBuilder.addIPAddress(clientIPAddress)
                    .addContent("Hello, Server!")
                    .build();

            // Sending the message to the server
            out.writeUTF(message);
            System.out.println("Message sent to Server: " + message);
        } catch (IOException i) {
            System.out.println(i);
        } finally {
            try {
                // Closing the connection in a finally block
                if (socket != null) {
                    socket.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        String serverAddress = "192.168.0.103"; // Replace with your server's IP address
        int serverPort = 5000;
        String clientIPAddress = "192.168.1.2"; // Replace with your client's IP address

        Client client = new Client(serverAddress, serverPort, clientIPAddress);
    }
}
