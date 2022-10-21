public class BankAccount{
    String firstName;
    String lastName;
    int accountID;
    double balance;

    public BankAccount(String fname, String lname, int id, double bal){ //parameterized BankAccount object
        fname = this.firstName; //set firstName = to
        lname = this.lastName;
        id = this.accountID;
        bal = this.balance;
    }

    public BankAccount(){ //overloading BankAccount to allow for a no args version of this object

    }

    public double deposit(double deposit){ //method to deposit money
        balance = balance + deposit;
        return balance;
    }

    public double withdraw(double withdraw){ //method to withdraw money
        balance = balance - withdraw; //set the balance = to balance minus the withdraw
        return balance; //return the balance
    }

    //getter and setter for firstName
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter and setter for lastName
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter and setter for accountID
    public int getAccountID() {
        return this.accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //getter and setter for balance
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void accountSummary(){ //account summary info. probably won't be used in main for this assignment
        System.out.println("Account Information \n"
                            + "First Name: " + getFirstName() + "\n"
                            + "Last Name: " + getLastName() + "\n"
                            + "Account ID: " + getAccountID() + "\n"
                            + "Balance: " + getBalance());

    }

}
 