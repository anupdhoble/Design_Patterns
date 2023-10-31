public class hexadecimal extends Observer{

    public hexadecimal(subject s){
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
        System.out.println("This is hexa num: "+i);
    }
}
