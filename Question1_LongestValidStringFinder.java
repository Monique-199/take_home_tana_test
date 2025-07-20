

import java.util.Arrays;
import java.util.List;

public class Question1_LongestValidStringFinder {
    /**
     * Returns the longest valid string from the input list that:
     * - contains only characters from the given valid characters list
     * - has no repeating identical characters in sequence
     *
     * @param validChars list of allowed characters
     * @param strings array of input strings to evaluate
     * @return the longest valid string satisfying both rules
     */
    public static String getLongestString(List<Character> validChars, String[] strings) {
        String longest = "";

        for (String s : strings) {
            if (isValid(s, validChars) && s.length() > longest.length()) {
                longest = s;
            }
        }

        return longest;
    }
    /**
     * Checks whether the input string is valid based on two rules:
     * - Contains only characters in validChars
     * - Does not contain identical consecutive characters
     *
     * @param s string to validate
     * @param validChars list of allowed characters
     * @return true if valid, false otherwise
     */
    private static boolean isValid(String s, List<Character> validChars) {
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Rule 1: invalid character
            if (!validChars.contains(current)) {
                return false;
            }

            // Rule 2: consecutive duplicate characters
            if (i > 0 && current == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
        //TEST CASES
        public static void runTests() {
            System.out.println("Running test cases----");

            List<Character> validChars = Arrays.asList('A', 'B', 'C', 'D');
            String[] inputStrings = {
                    "AABCDA",        // Invalid - has "AA"
                    "ABCDZADC",      // Invalid - contains 'Z'
                    "ABCDBCA",       // Valid
                    "ABCDABDCA"      // Valid & longest
            };

            String result = getLongestString(validChars, inputStrings);
            System.out.println("Expected: ABCDABDCA");
            System.out.println("Actual: " + result);

            // Test 2: All strings invalid
            List<Character> validChars2 = Arrays.asList('X', 'Y');
            String[] strings2 = { "AABB", "YYZ", "XYYX" };
            System.out.println("Expected: (empty string)");
            System.out.println("Actual: '" + getLongestString(validChars2, strings2) + "'");

            // Test 3: Empty list
            System.out.println("Expected: (empty string)");
            System.out.println("Actual: '" + getLongestString(validChars, new String[]{}) + "'");

            // Test 4: Edge case with 1 valid string
            String[] strings4 = { "ABCD" };
            System.out.println("Expected: ABCD");
            System.out.println("Actual: " + getLongestString(validChars, strings4));

            // Test 5: Strings with repeated valid characters (e.g., "ABBC")
            String[] strings5 = { "ABBC", "ABCD" };
            System.out.println("Expected: ABCD");
            System.out.println("Actual: " + getLongestString(validChars, strings5));
        }

        public static void main(String[] args) {
            runTests();
        }

    }
