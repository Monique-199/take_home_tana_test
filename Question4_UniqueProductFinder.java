
import java.util.LinkedHashMap;
import java.util.Map;

public class Question4_UniqueProductFinder {
    /**
     * Finds the first unique product in the array (only appears once).
     *
     * @param products array of product names
     * @return the first unique product, or null if none found
     */
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        // Use LinkedHashMap to preserve insertion order
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        // Step 1: Count occurrences
        for (String product : products) {
            frequencyMap.put(product, frequencyMap.getOrDefault(product, 0) + 1);
        }

        // Step 2: Find the first entry with count = 1
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // First unique product
            }
        }
        return null; // No unique product found
    }
    //TEST CASES
    public static void runTests() {
        System.out.println("Running test cases.====");

        // Test 1: Given example
        String[] test1 = { "Apple", "Computer", "Apple", "Bag" };
        System.out.println("Expected: Computer");
        System.out.println("Actual: " + firstUniqueProduct(test1));

        // Test 2: No unique products
        String[] test2 = { "Phone", "Phone", "Tablet", "Tablet" };
        System.out.println("Expected: null");
        System.out.println("Actual: " + firstUniqueProduct(test2));

        // Test 3: All unique
        String[] test3 = { "Pen", "Pencil", "Notebook" };
        System.out.println("Expected: Pen");
        System.out.println("Actual: " + firstUniqueProduct(test3));

        // Test 4: Empty array
        String[] test4 = {};
        System.out.println("Expected: null");
        System.out.println("Actual: " + firstUniqueProduct(test4));

        // Test 5: Single item
        String[] test5 = { "Monitor" };
        System.out.println("Expected: Monitor");
        System.out.println("Actual: " + firstUniqueProduct(test5));
        // Test 6: Unique item at the end
        String[] test6 = { "Mouse", "Mouse", "Keyboard" };
        System.out.println("Expected: Keyboard");
        System.out.println("Actual: " + firstUniqueProduct(test6));
    }

    public static void main(String[] args) {
        runTests();
    }
}
