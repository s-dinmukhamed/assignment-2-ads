import java.util.LinkedList;
import java.util.Queue;

public class AccountRequestQueue {
    private Queue<BankAccount> accountRequests;

    public AccountRequestQueue(){
        accountRequests = new LinkedList<>();
    }

    public void addRequest(BankAccount account){
        accountRequests.add(account);
        System.out.println("Account request: " + account.getUsername());
    }

    public void processRequest(LinkedList<BankAccount> accounts){
        if(accountRequests.isEmpty()){
            System.out.println("No pending account requests");
        }else{
            BankAccount account = accountRequests.poll();
            accounts.add(account);
            System.out.println("Account request processed: " + account.getUsername());
        }
    }

    public void displayRequests(){
        if (accountRequests.isEmpty()){
            System.out.println("No requests");
        }else{
            System.out.println("Requests: ");
            for (BankAccount acc : accountRequests){
                System.out.println(acc.getAccountID() + ". " + acc.getUsername() + " - Balance: " + acc.getBalance());
            }
        }
    }
}
