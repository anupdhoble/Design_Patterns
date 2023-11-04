// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Mediator m = new concreteMediator();
        Collegue c1= new concreteCollegue(m);
        Collegue c2= new concreteCollegue(m);
        m.addCollegue(c1);
        m.addCollegue(c2);
        c1.send("Hello");
    }
}