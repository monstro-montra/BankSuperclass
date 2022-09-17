import java.util.Scanner;
import java.security.spec.ECParameterSpec;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
    static CheckingAccount c = new CheckingAccount();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        accountSetup();
        menu(0);
        


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
            System.out.print("Set your first name: ");
            try{
                if(in.hasNext("[A-Za-z]*")){
                    c.setFirstName(in.next());
                break; //break out of this loop if the user input is alphabetical.
                } else {
                    throw new InputMismatchException("Not a name!");
                }
            } catch(InputMismatchException e){
                mismatch(e);
            }
        }
        
        while(true){
            System.out.print("Set your last name: ");
            try{
                if(in.hasNext("[A-Za-z]*")){
                    c.setLastName(in.next());
                break; //break out of this loop if the user input is alphabetical.
                } else {
                    throw new InputMismatchException("Not a name!");
                }
            } catch(InputMismatchException e){
                mismatch(e);
            }
        }
        
        c.setAccountID(randomID);
        System.out.println("Your account ID is: " + c.getAccountID());
        c.setBalance(1000);
        System.out.println("Your outstanding balance is " + c.getBalance());
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
            printMenu(); // call printmenu method
            try {
                if (in.hasNextInt()){
                    menuChoice = in.nextInt();
                    switch(menuChoice){
                        case 1:   //deposit 
                            System.out.println("How much would you like to deposit?");
                            double depositAmount = in.nextDouble();
                            c.deposit(depositAmount);
                            System.out.println("You've deposited: " + depositAmount + "$.");
                            break;
            
                        case 2: //withdraw
                            System.out.println("How much would you like to withdraw?");
                            double withdrawAmount = in.nextDouble();
                            c.withdraw(withdrawAmount);
                            if (withdrawAmount == 0){ //if nothing was withdrawn
                                System.out.println("Nothing withdrawn!");
                            } else{
                                System.out.println("You've withdrawn: " + withdrawAmount + "$.");
                            }

                            if(withdrawAmount > c.getBalance() && withdrawAmount != 0){// if withdrawAmount is more than current balance
                                c.processWithdrawal();
                                c.setBalance(c.getBalance() - 30); //30 is the overdraft fee. set balance to get balance - 30
                            } 
                            break;
                            
                        case 3: //display account info
                            c.displayAccount();
                            System.out.println();
                            break;

                        case 4: //exit
                            System.out.println("Exiting...");
                            System.exit(0);
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
