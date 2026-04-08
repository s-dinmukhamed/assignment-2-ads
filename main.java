import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();

        while (true){
            menu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    addNewAccount(accounts, scan);
                    break;
                case 2:
                    displayAccounts(accounts);
                    break;
                case 3:
                    searchAccount(accounts,scan);
                    break;
                case 4:
                    System.out.println("Thanks for using my program");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void displayAccounts(LinkedList<BankAccount> accounts){
        if(accounts.isEmpty()){
            System.out.println("Empty");
            return;
        }
        System.out.println("Accounts: ");
        for(BankAccount acc : accounts){
            System.out.println(acc.getAccountID() + ". " + acc.getUsername() + " - Balance: " + acc.getBalance());
            System.out.println();
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("1. Add new account");
        System.out.println("2. Display all accounts");
        System.out.println("3. Search account by username");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    public static void addNewAccount(LinkedList<BankAccount> accounts, Scanner scan){
        System.out.println();
        System.out.println("Enter account id: ");
        int accountID = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter account username: ");
        String username = scan.nextLine();

        System.out.println("Enter account balance: ");
        double balance = scan.nextDouble();
        scan.nextLine();

        BankAccount account = new BankAccount(accountID, username, balance);
        accounts.add(account);
        System.out.println("Account added successfully");
    }

    public static void searchAccount(LinkedList<BankAccount> accounts, Scanner scan){
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        boolean found = false;

        for(BankAccount acc : accounts){
            if(username.equals(acc.getUsername())){
                System.out.println("Account successfully found");
                System.out.println(acc.getAccountID() + ". " + acc.getUsername() + " - Balance: " + acc.getBalance());
                found = true;
                break;
            }
        }
        if (found == false){
            System.out.println("Account not found");
        }

    }
}