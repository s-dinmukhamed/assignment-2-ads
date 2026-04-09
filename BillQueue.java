import java.util.LinkedList;
import java.util.Queue;

public class BillQueue {
    private Queue<String> billQueue;

    public BillQueue(){
        billQueue = new LinkedList<>();
    }

    public void addBill(String billName){
        billQueue.add(billName);
        System.out.println("Aadded: " + billName);
    }

    public void NextBill(){
        if (billQueue.isEmpty()){
            System.out.println("No bills found");
        }else{
            String bill = billQueue.poll();
            System.out.println("Processing: " + bill);
        }
    }

    public void displayBills(){
        if (billQueue.isEmpty()){
            System.out.println("No bills");
        }else{
            System.out.println("Bills in queue: " );
            for(String bill : billQueue){
                System.out.println(bill);
            }
        }
    }
}
