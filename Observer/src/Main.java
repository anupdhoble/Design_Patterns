// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
//Anup Dhoble
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        subject s = new subject(0);
        Observer binary= new BinaryNum(s);
        Observer hexaa = new hexadecimal(s);
        Observer octa = new OctalNum(s);



        s.setNum(1);
        s.setNum(9);

    }
}