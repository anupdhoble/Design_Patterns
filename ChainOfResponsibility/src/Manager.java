public class Manager extends loanApprover{
    public Manager(){
    }
    public void approveLoan(Loan L){

        if(L.getAmount()<=100000){
            System.out.println("Approved by Manager");
        }
        else{
            nextApprover.approveLoan(L);
        }
    }
}
