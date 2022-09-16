public class CheckingAccount extends BankAccount {
    private float interestRate;
    private final int overdraftFee = 30;

    public void processWithdrawal(){
        System.out.println("Sorry, You have a negative balance. An overdraft fee of " +
        overdraftFee + "$ has been added to your account2.");
        System.out.println("Your current balance is: " + getBalance());
    }

    public void displayAccount(){
        accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
        
    
    
}
