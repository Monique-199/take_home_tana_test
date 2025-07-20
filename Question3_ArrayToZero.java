

public class Question3_ArrayToZero {
    /**
     * Check if it's possible to reduce all elements except the first to zero
     * using the operation: a[i] = a[i] - a[i - 1]
     *
     * @param a input array with positive integers
     * @return 1 if possible, 0 otherwise
     */
    public static int canReduceToZero(int[] a) {
        // Step 1: Loop from the end toward the front
        for (int i = a.length - 1; i > 0; i--) {
            // If the left element is greater than the current one, we can't proceed
            if (a[i] < a[i - 1]) {
                return 0;
            }

            // Guard against division by zero
            if (a[i - 1] == 0) {
                return 0;
            }

            // Simulate subtracting a[i - 1] from a[i] until a[i] becomes 0
            a[i] = a[i] % a[i - 1];
        }

        // Check that all except the first element are 0
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 0) {
                return 0;
            }
        }

        return 1;
    }

    //TEST CASES
    public static void runTests() {
        System.out.println("Running test cases...");

        // Test 1: Example from test question
        int[] arr1 = {1, 2, 3};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + canReduceToZero(arr1));

        // Test 2: Already reduced
        int[] arr2 = {3, 0, 0, 0};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + canReduceToZero(arr2));

        // Test 3: Not reducible
        int[] arr3 = {5, 4, 3};
        System.out.println("Expected: 0");
        System.out.println("Actual: " + canReduceToZero(arr3));

        // Test 4: Only one element
        int[] arr4 = {10};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + canReduceToZero(arr4));

        // Test 5: All elements equal
        int[] arr5 = {2, 2, 2, 2};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + canReduceToZero(arr5));

        // Test 6: Decreasing but valid steps
        int[] arr6 = {1, 2, 4, 8};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + canReduceToZero(arr6));
    }

    public static void main(String[] args) {
        runTests();
    }
}
