import java.util.Scanner;
import java.security.spec.ECParameterSpec;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
    static CheckingAccount c = new CheckingAccount(); //create a new CheckingAccount object
    static Scanner in = new Scanner(System.in); //create a new Scanner object
    public static void main(String[] args){

        accountSetup(); //run accountSetup static method
        menu(0); //run the menu with a starting menuChoice of 0
        


    }

    public static void accountSetup(){
        Random idGen = new Random(); //create new random object
        int min = 10000000; //minimum seed
        int max = 99999999; //maximum seed
        
        int randomID = idGen.nextInt(max + 1 - min) + min; 
        //add 1 to max to make it inclusive for both the min and max.
        //generate new random int between min and max. select an int between 0 and 90000000 (max + 1 - min)
        //then add 10000000 to that number to get the proper range

        
        while(true){
            System.out.print("Set your first name: "); //ask user toset first name
            try{
                if(in.hasNext("[A-Za-z]*")){ //if the next input is alphabetical
                    c.setFirstName(in.next()); //set firstName to user input
                break; //break out of this loop if the user input is alphabetical.
                } else {
                    throw new InputMismatchException("Not a name!");
                }
            } catch(InputMismatchException e){ //catch the InputMismatchException that was thrown before
                mismatch(e);
            }
        }
        
        while(true){
            System.out.print("Set your last name: "); // ask user to set the last name
            try{
                if(in.hasNext("[A-Za-z]*")){ //if the next input is alphabetical
                    c.setLastName(in.next()); //set lastName to user input
                break; //break out of this loop if the user input is alphabetical.
                } else {
                    throw new InputMismatchException("Not a name!");
                }
            } catch(InputMismatchException e){
                mismatch(e);
            }
        }
        
        c.setAccountID(randomID); //us setter to set the accountID
        System.out.println("Your account ID is: " + c.getAccountID()); //print account ID
        c.setBalance(1000); //set the starting balance to 1000
        System.out.println("Your outstanding balance is " + c.getBalance()); //print the outstanding balance
    }


    public static void printMenu(){ //print the menu options for the menu method
        System.out.println("Menu Options: \n"  +
                            "1: Deposit \n" + 
                            "2: Withdraw \n" +
                            "3: Display Account Information \n" +
                            "4: Exit");
    }
    public static int menu(int menuChoice){
        do {
            System.out.println(); // create a space
            printMenu(); // call static printmenu method
            try {
                if (in.hasNextInt()){ //if in has an int in next user input
                    menuChoice = in.nextInt(); //set menuChoice = to user input
                    switch(menuChoice){ //this switch will be used to have user select from menu
                        case 1: //deposit
                            System.out.println("How much would you like to deposit?"); //
                            double depositAmount = in.nextDouble(); //get double from user
                            c.deposit(depositAmount); //call deposit method from bankAccount to add depositAmount
                            System.out.println("You've deposited: " + depositAmount + "$.");
                            break;
            
                        case 2: //withdraw
                            System.out.println("How much would you like to withdraw?");
                            double withdrawAmount = in.nextDouble(); //get double from user
                            c.withdraw(withdrawAmount); //call withdraw method from bankAccount
                            if (withdrawAmount == 0){ //if nothing was withdrawn
                                System.out.println("Nothing withdrawn!");
                            } else{
                                System.out.println("You've withdrawn: " + withdrawAmount + "$.");
                            }

                            if(withdrawAmount > c.getBalance() && withdrawAmount != 0){// if withdrawAmount is more than current balance
                                c.processWithdrawal(); //call processWithdrawal method from checkingAccount class
                                c.setBalance(c.getBalance() - 30); //30 is the overdraft fee. set balance to get balance - 30
                            } 
                            break;
                            
                        case 3: //display account info
                            c.displayAccount(); //call displayAccount method
                            System.out.println();
                            break;

                        case 4: //exit
                            System.out.println("Exiting...");
                            System.exit(0); //exit the program
                            break;

                        default: // any int input that's not 1 through 4 will go here.
                            System.out.println("Incorrect input. Please choose a number 1-4."); 
                    }
                } else {
                    throw new InputMismatchException("Not an integer!");
                }
            } catch (InputMismatchException notInt) {
                    mismatch(notInt);
            }
            
        } while(menuChoice != 4); //as long as menuChoice is not 4, continue the loop.
        return menuChoice;

    }
    public static Exception mismatch(InputMismatchException e) { // default method for when there is an 
        //InputMismatchMethod in a try...catch block.
        System.out.println(e.getMessage());
        System.out.println("Please try again.");
        in.next();
        return e;
    }


    
}
