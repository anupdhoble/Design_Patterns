import java.util.ArrayList;

interface Mediator{
    abstract void notify(String msg,Collegue currentCollegue);
    abstract void addCollegue(Collegue c);
}
class concreteMediator implements Mediator{
    ArrayList<Collegue> clist = new ArrayList<>();
    public void notify(String msg , Collegue currentCollegue){
        for(Collegue t: clist){
            if(currentCollegue != t){
                t.receive(msg);
            }
        }
    }
    public void addCollegue(Collegue c){
        clist.add(c);
        System.out.println(c+ "is added.");
    }
}