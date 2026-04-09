package assignment2;

public class BankAccount {
    int AccountID;
    String username;
    double balance;

    public BankAccount(int AccountID, String username, double balance ){
        this.AccountID = AccountID;
        this.username = username;
        this.balance = balance;
    }

    public int getAccountID(){
            return AccountID;
    }
    public String getUsername(){
        return username;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Account ID: " + getAccountID());
        System.out.println("Username: " + getUsername());
        System.out.println("Balance: " + getBalance());
    }

}
