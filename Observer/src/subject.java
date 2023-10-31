import java.util.ArrayList;

public class subject {
    ArrayList<Observer> subs = new ArrayList<>();
    private int a;
    public subject(int a){
        this.a=a;
    }
    public void addSub(Observer a){
        subs.add(a);
    }
    public void notifyy(){
        for(Observer i: subs){
            i.setnum(a);
        }
    }
    public void setNum(int n){
        this.a=n;
        notifyy();
    }
}
