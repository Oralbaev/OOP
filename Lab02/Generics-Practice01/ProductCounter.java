import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
    Map<String, Integer> productCountMap = new HashMap<>();
    // Create a Name Mapping Map
    Map<String, String> productNames = new TreeMap<>();


    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1s07", "1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");

        // Create Product Counter Object and process data
        ProductCounter example = new ProductCounter(productNames);
        example.processList(parts);
        example.printReport();
    }

    public ProductCounter(Map<String, String> productNames) {
        this.productNames = new TreeMap<>(productNames);
    }

    public void processList(String[] list) {
        for (String x : list) {
            productCountMap.put(x, productCountMap.getOrDefault(x, 0) + 1);
        }
    }

    public void printReport() {
        System.out.println("=== Product Report ===");
        for (Map.Entry<String, String> x : productNames.entrySet())
        {
            String name = x.getKey();
            String art = x.getValue();
            int num = productCountMap.getOrDefault(art, 0);
            System.out.println("Name: " + name + " \t" + "Count: " + num);
        }
    }
}
