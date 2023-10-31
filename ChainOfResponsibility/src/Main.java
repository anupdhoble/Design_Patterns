// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        loanApprover a = new Manager();
        loanApprover b = new Supervisor();
        loanApprover c = new President();

        a.setNextApprover(b);
        b.setNextApprover(c);

        a.approveLoan(new Loan(850000));
    }
}