interface Collegue {
    abstract void send(String msg);
    abstract void receive(String msg);
}

class concreteCollegue implements Collegue{
    private Mediator mediator;
    private String message;
    concreteCollegue(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void send(String msg) {
        mediator.notify(msg,this);
    }
    public void receive(String msg){
        this.message=msg;
        System.out.println("Message received: "+this.message+" At : "+this);
    }
}
