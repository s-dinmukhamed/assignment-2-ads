package assignment2.structures;

import java.util.LinkedList;
import assignment2.*;

public class AccountManager {
    private LinkedList<BankAccount> accounts;

    public AccountManager(){
        accounts = new LinkedList<>();
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
        System.out.println("Account added successfully");
    }
    public BankAccount findAccount(String username){
        for(BankAccount account : accounts){
            if (username.equals(account.getUsername())){
                return account;
            }
        }
        return null;
    }
    public void displayAccounts(){
        if(accounts.isEmpty()){
            System.out.println("Account not found");
            return;
        }
        System.out.println("Accounts: ");
        for (BankAccount account : accounts){
            System.out.println(account.getAccountID() + ". " + account.getUsername() + " - Balance: " + account.getBalance());
        }
    }
    public boolean deposit(String username, double amount) {
        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        account.deposit(amount);
        System.out.println("New balance: " + account.getBalance());
        return true;
    }
    public boolean withdraw(String username, double amount) {
        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        if (account.withdraw(amount)) {
            System.out.println("New balance: " + account.getBalance());
            return true;
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }
    public void balanceEnquiry(String username) {
        BankAccount account = findAccount(username);

        if (account == null) {
            System.out.println("Account not found");
        } else {
            System.out.println("Balance: " + account.getBalance());
        }
    }
}
