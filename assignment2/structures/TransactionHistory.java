package assignment2.structures;

import java.util.Stack;

public class TransactionHistory {
    private Stack<String> history;

    public TransactionHistory(){
        history = new Stack<>();
    }

    public void addTransaction(String transaction){
        history.push(transaction);
    }
    public void lastTransaction(){
        if(history.isEmpty()){
            System.out.println("No transaction found");
        }else{
            System.out.println("Last transaction: " + history.peek());
        }
    }
    public void cancelLastTransaction(){
        if(history.isEmpty()){
            System.out.println("No transaction found");
        }else{
            String removed = history.pop();
            System.out.println("Removed: " + removed);
        }
    }
    public void displayTransactions(){
        if(history.isEmpty()){
            System.out.println("No transaction found");
        }else{
            System.out.println("Transaction History: ");
            for (String transaction : history){
                System.out.println(transaction);
            }
        }
    }
}
