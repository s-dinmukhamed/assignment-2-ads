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

}
