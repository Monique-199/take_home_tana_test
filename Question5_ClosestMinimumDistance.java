package com.example.demo.model;

public class Question5_ClosestMinimumDistance {
    /**
     * Finds the shortest distance between any two closest minimum values in the array.
     * @param arr Input array of integers
     * @return Minimum distance between two same minimum values
     */
    public static int distanceBetweenClosestMinimums(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // Invalid input
        }

        int minValue = Integer.MAX_VALUE;

        // Step 1: Find the minimum value
        for (int num : arr) {
            if (num < minValue) {
                minValue = num;
            }
        }
        int lastMinIndex = -1;  // Store the last index of the minimum
        int minDistance = Integer.MAX_VALUE;

        // Step 2: Traverse array and find distances between closest minimums
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minValue) {
                if (lastMinIndex != -1) {
                    int distance = i - lastMinIndex;
                    minDistance = Math.min(minDistance, distance);
                }
                lastMinIndex = i;
            }
        }

        return minDistance;
    }
    //TEST CASES
    public static void runTests() {
        System.out.println("Running test cases---");

        int[] test1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Expected: 3");
        System.out.println("Actual: " + distanceBetweenClosestMinimums(test1));

        int[] test2 = {5, 1, 1, 1, 6};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + distanceBetweenClosestMinimums(test2));

        int[] test3 = {7, 6, 5, 4, 3, 2, 1, 1};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + distanceBetweenClosestMinimums(test3));

        int[] test4 = {10, 20, 10, 30, 10, 40};
        System.out.println("Expected: 2");
        System.out.println("Actual: " + distanceBetweenClosestMinimums(test4));

        int[] test5 = {3, 3};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + distanceBetweenClosestMinimums(test5));
    }
    public static void main(String[] args) {
        runTests();
    }
}
