abstract public class loanApprover {
    public loanApprover nextApprover;
    abstract void approveLoan(Loan L);
    void setNextApprover(loanApprover a){
        this.nextApprover = a;
    }

}
