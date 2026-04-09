package assignment2;

import java.util.Scanner;
import java.util.WeakHashMap;

import assignment2.structures.AccountManager;
import assignment2.structures.AccountRequestQueue;
import assignment2.structures.BillQueue;
import assignment2.structures.TransactionHistory;

public class BankSystem {
    private Scanner scan;
    private AccountManager accountManager;
    private TransactionHistory transactionHistory;
    private BillQueue billQueue;
    private AccountRequestQueue accountRequestQueue;

    public BankSystem(){
        scan = new Scanner(System.in);
        accountManager = new AccountManager();
        transactionHistory = new TransactionHistory();
        billQueue = new BillQueue();
        accountRequestQueue = new AccountRequestQueue();
    }


    public void MainMenu(){
        System.out.println();
        System.out.println("1 - Enter Bank");
        System.out.println("2 - Enter ATM");
        System.out.println("3 - Admin Area");
        System.out.println("4 - Exit");
        System.out.println("Enter your choice: ");
    }
    public void startMainMenu(){
        while (true){
            MainMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    startBankMenu();
                    break;
                case 2:
                    startATMMenu();
                    break;
                case 3:
                    startAdminMenu();
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

    public void BankMenu(){
        System.out.println();
        System.out.println("Bank Menu");
        System.out.println("1. Account opening request");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Last transaction");
        System.out.println("5. Cancel transction");
        System.out.println("6. Pay bill");
        System.out.println("7. Back");
        System.out.println("Enter your choice:");
    }
    public void startBankMenu(){
        while (true){
            BankMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    submitAccountRequest();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    payBill();
                    break;
                case 5:
                    transactionHistory.lastTransaction();
                    break;
                case 6:
                    transactionHistory.cancelLastTransaction();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void ATMMenu(){
        System.out.println();
        System.out.println("ATM Menu");
        System.out.println("1. Balance enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Back");
        System.out.println("Enter your choice:");
    }
    public void startATMMenu(){
        while (true){
            ATMMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    balanceEnquiry();
                    break;
                case 2:
                    atmWithdraw();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void AdminMenu(){
        System.out.println();
        System.out.println("Admin Menu");
        System.out.println("1. View all requests");
        System.out.println("2. Process account request");
        System.out.println("3. View bill payment queue");
        System.out.println("4. Process next bill");
        System.out.println("5. View all accounts");
        System.out.println("6. View transaction history");
        System.out.println("7. Back");
        System.out.println("Enter your choice:");
    }
    public void startAdminMenu(){
        while (true){
            AdminMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    accountRequestQueue.displayRequests();
                    break;
                case 2:
                    accountRequestQueue.processRequest(accountManager);
                    break;
                case 3:
                    billQueue.displayBills();
                    break;
                case 4:
                    billQueue.NextBill();
                    break;
                case 5:
                    accountManager.displayAccounts();
                    break;
                case 6:
                    transactionHistory.displayTransactions();
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void submitAccountRequest() {
        System.out.print("Enter account id: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter balance: ");
        double balance = scan.nextDouble();
        scan.nextLine();

        BankAccount account = new BankAccount(id, username, balance);
        accountRequestQueue.addRequest(account);
    }
    public void payBill() {
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Bill amount: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        boolean success = accountManager.withdraw(username, amount);
        if (success) {
            System.out.println("Bill paid successfully");
            transactionHistory.addTransaction("Bill payment " + amount + " from " + username);

            System.out.print("Enter bill name: ");
            String billName = scan.nextLine();
            billQueue.addBill(billName);
        }
    }
    public void atmWithdraw() {
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter withdraw amount: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        boolean success = accountManager.withdraw(username, amount);
        if (success) {
            transactionHistory.addTransaction("ATM Withdraw " + amount + " from " + username);
        }
    }
    public void balanceEnquiry() {
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        accountManager.balanceEnquiry(username);
    }
    public void depositMoney() {
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter deposit amount: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        boolean success = accountManager.deposit(username, amount);
        if (success) {
            transactionHistory.addTransaction("Deposit " + amount + " to " + username);
        }
    }
    public void withdrawMoney() {
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter withdraw amount: ");
        double amount = scan.nextDouble();
        scan.nextLine();

        boolean success = accountManager.withdraw(username, amount);
        if (success) {
            transactionHistory.addTransaction("Withdraw " + amount + " from " + username);
        }
    }

}
