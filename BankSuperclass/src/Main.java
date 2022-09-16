import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        
        CheckingAccount c = new CheckingAccount();
        c.setFirstName(in.next());
        c.setLastName(in.next());
        c.setAccountID(349502);
        c.setBalance(1000.42);

        
        

        

    }

    public static void printMenu(){ //print the menu options for the menu method
        System.out.println("Menu Options: \n"  +
                            "1: Deposit \n" + 
                            "2: Withdraw \n" +
                            "3: Display Account Information \n" +
                            "4: Exit");
    }
    public static int menu(int menuChoice){
        printMenu();

        switch(menuChoice){
            case 1: c.deposit();
        }

        return menuChoice;
        
    }
    
}
