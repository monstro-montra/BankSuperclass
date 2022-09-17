public class CheckingAccount extends BankAccount {
    private double interestRate = 0.1;
    private final int overdraftFee = 30;

    public void processWithdrawal(){
        System.out.println("Sorry, You have a negative balance. An overdraft fee of " +
        overdraftFee + "$ has been added to your account2.");
        System.out.println("Your current balance is: " + (getBalance()- overdraftFee));
    }

    public void displayAccount(){
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
        
    
    
}
