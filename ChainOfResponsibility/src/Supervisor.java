public class Supervisor extends loanApprover{
    public Supervisor(){

    }
    public void approveLoan(Loan L){
        if(L.getAmount()<=300000){
            System.out.println("Approved by Supervisor");
        }
        else{
            nextApprover.approveLoan(L);
        }
    }
}
