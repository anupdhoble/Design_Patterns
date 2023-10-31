public class OctalNum extends Observer{

    public OctalNum(subject s){
        s.addSub(this);
        this.display();
    }
    @Override
    public void setnum(int n) {
        i=n;
        this.display();
    }

    @Override
    public void display() {
        System.out.println("This is octal num: "+i);
    }
}
