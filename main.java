import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();
        TransactionHistory history = new TransactionHistory();
        BillQueue billQueue = new BillQueue();
        AccountRequestQueue requestQueue = new AccountRequestQueue();

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
                    deposit(accounts, scan, history );
                    break;
                case 5:
                    withdraw(accounts, scan);
                    break;
                case 6:
                    bill(accounts,scan,history);
                    break;
                case 7:
                    history.lastTransaction();
                    break;
                case 8:
                    history.cancelLastTransaction();
                    break;
                case 9:
                    history.displayTransactions();
                    break;
                case 10:
                    addBillRequest(scan, billQueue);
                    break;
                case 11:
                    billQueue.NextBill();
                    break;
                case 12:
                    billQueue.displayBills();
                    break;
                case 13:
                    addAccountRequest(scan, requestQueue);
                    break;
                case 14:
                    requestQueue.processRequest(accounts);
                    break;
                case 15:
                    requestQueue.displayRequests();
                    break;
                case 16:
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
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Bill");
        System.out.println("7. Last Transaction");
        System.out.println("8. Cancel Last Transaction");
        System.out.println("9. Display Transactions");
        System.out.println("10. Add Bill payment request");
        System.out.println("11. Process next Bill payment");
        System.out.println("12. Display Bill queue");
        System.out.println("13. Add account opening request");
        System.out.println("14. Process account opening request");
        System.out.println("15. Display pending account requests");
        System.out.println("16. Exit");
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

    public static void deposit(LinkedList<BankAccount> accounts, Scanner scan, TransactionHistory history){
        System.out.println("Enter username: ");
        String username = scan.nextLine();

        for(BankAccount acc : accounts){
            if(username.equals(acc.getUsername())){
                System.out.println("Deposit: ");
                double amount = scan.nextDouble();
                scan.nextLine();

                acc.deposit(amount);
                System.out.println("New balance: " + acc.getBalance());
                history.addTransaction("Deposit " + amount + " to " + acc.getUsername());
                return;
            }
        }
        System.out.println("Account not found");
    }

    public static void withdraw(LinkedList<BankAccount> accounts, Scanner scan){
        System.out.println("Enter username: ");
        String username = scan.nextLine();

        for (BankAccount acc : accounts){
            if(username.equals(acc.getUsername())){
                System.out.println("Withdraw: ");
                double amount = scan.nextDouble();
                scan.nextLine();

                if(acc.withdraw(amount)){
                    System.out.println("New balance: " + acc.getBalance());
                }else{
                    System.out.println("invalid balance");
                }
                return;
            }
        }
        System.out.println("Account not found");
    }

    public static void bill(LinkedList<BankAccount> accounts, Scanner scan, TransactionHistory history){
        System.out.println("Enter username");
        String username = scan.nextLine();

        for(BankAccount acc : accounts){
            if(username.equals(acc.getUsername())){
                System.out.println("Bill amount: ");
                double amount = scan.nextDouble();
                scan.nextLine();

                if(acc.withdraw(amount)){
                    System.out.println("Bill paid successfully");
                    System.out.println("New balance: " + acc.getBalance());
                    history.addTransaction("Bill payment " + amount + " from " + acc.getUsername());
                }else{
                    System.out.println("Invalid balance");
                }
                return;
            }
        }
        System.out.println("Account not found");
    }

    public static void addBillRequest(Scanner scan, BillQueue billQueue){
        System.out.println("Enter bill name: ");
        String billname = scan.nextLine();
        billQueue.addBill(billname);
    }

    public static void addAccountRequest(Scanner scan, AccountRequestQueue requestQueue){
        System.out.print("Enter account id: ");
        int accountNumber = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter account username: ");
        String username = scan.nextLine();

        System.out.print("Enter account balance: ");
        double balance = scan.nextDouble();
        scan.nextLine();

        BankAccount account = new BankAccount(accountNumber, username, balance);
        requestQueue.addRequest(account);
    }
}