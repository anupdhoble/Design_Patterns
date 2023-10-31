public class President extends loanApprover{
    public President(){

    }
    public void approveLoan(Loan L){
        if(L.getAmount()>300000){
            System.out.println("Approved by President");
        }
        else{
            nextApprover.approveLoan(L);
        }
    }
}
