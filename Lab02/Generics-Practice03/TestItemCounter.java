import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestItemCounter {

    public static void main(String[] args) {

        // Create Items to Count
        Map<String, Shirt> polos = new HashMap<>(10);
        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L"));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M"));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL"));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S"));

        // Transactions
        List<DukeTransaction> transactions = new ArrayList<>(20);
        transactions.add(DukeTransaction.createTransaction("P001", "Purchase", 30));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 5));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 4));

        // Count the shirts
        for (DukeTransaction x : transactions)
        {
            if (x.getTransactionType() == "Purchase")
                polos.get(x.getProductID()).addItems(x.getCount());
            else
                polos.get(x.getProductID()).removeItems(x.getCount());
        }
        // Convert to List
        List<Shirt> ShirtList = new ArrayList<>(polos.values());

        // Init Comparators
        Comparator<Shirt> sortByCount = new SortShirtByCount();
        Comparator<Shirt> sortByDesc = new SortShirtByDesc();

        // Print Results - Sort by Description
        System.out.println("=== Inventory Report - Description ===");
        Collections.sort(ShirtList, sortByDesc);
        for(Shirt x : ShirtList)
        {
            System.out.println(x.toString());
        }
        // Print Results - Sort by Count
        System.out.println("\n=== Inventory Report - Description ===");
        Collections.sort(ShirtList, sortByCount);
        for(Shirt x : ShirtList)
        {
            System.out.println(x.toString());
        }
    }
}
