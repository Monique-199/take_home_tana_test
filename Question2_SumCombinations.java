
import java.util.*;

public class Question2_SumCombinations {
    /**
     * This method returns the number of unique combinations of elements in the array
     * that sum up to the given result.
     * @return number of unique combinations that add up to the result
     */
    public static int countCombinations(int result, int[] numbers) {
        // Use a set to avoid duplicate combinations (like [1,4,5] and [5,4,1])
        Set<List<Integer>> uniqueCombinations = new HashSet<>();
        findCombinations(0, numbers, result, new ArrayList<>(), uniqueCombinations);
        return uniqueCombinations.size();
    }
    /**
     * Helper recursive method to explore all combinations
     *
     * @param start current index in the array
     * @param numbers the array of numbers
     * @param target remaining sum to match
     * @param current current combination being built
     * @param resultSet set to store unique valid combinations
     */
    private static void findCombinations(int start, int[] numbers, int target,
                                         List<Integer> current,
                                         Set<List<Integer>> resultSet) {
        if (target == 0) {
            // Found a valid combination; sort to avoid duplicates in different order
            List<Integer> combination = new ArrayList<>(current);
            Collections.sort(combination);
            resultSet.add(combination);
            return;
        }

        if (target < 0 || start >= numbers.length) {
            return; // base case: stop recursion
        }
        // For each index, decide whether to include that number or not
        for (int i = start; i < numbers.length; i++) {
            current.add(numbers[i]);  // Choose
            findCombinations(i + 1, numbers, target - numbers[i], current, resultSet);  // Explore
            current.remove(current.size() - 1);  // Un-choose (backtrack)
        }
    }
    //TEST CASES
    public static void runTests() {
        System.out.println("Running test cases---");

        // Test 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int result1 = 10;
        System.out.println("Expected: 3");
        System.out.println("Actual: " + countCombinations(result1, arr1));

        // Test 2
        int[] arr2 = {1, 2, 4, 7, 5};
        int result2 = 17;
        System.out.println("Expected: 1");
        System.out.println("Actual: " + countCombinations(result2, arr2));

        // Test 3: No valid combinations
        int[] arr3 = {2, 4, 6};
        int result3 = 1;
        System.out.println("Expected: 0");
        System.out.println("Actual: " + countCombinations(result3, arr3));

        // Test 4: One element equals target
        int[] arr4 = {1, 5, 7, 10};
        int result4 = 10;
        System.out.println("Expected: 1");
        System.out.println("Actual: " + countCombinations(result4, arr4));

        // Test 5: Empty array
        int[] arr5 = {};
        int result5 = 5;
        System.out.println("Expected: 0");
        System.out.println("Actual: " + countCombinations(result5, arr5));
    }

    public static void main(String[] args) {
        runTests();
    }

}
