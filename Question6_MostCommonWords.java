
import java.util.*;

public class Question6_MostCommonWords {
    /**
     * Returns the 3 most common words in the sentence sorted alphabetically.
     * @param sentence the input string
     * @return a list of top 3 common words sorted alphabetically
     */
    public static List<String> getTopThreeWords(String sentence) {
    //handles edge case : empty or null input, returns an empty list.
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }
        // 1.split the empty string into words
        //splitting on white space
        String[] words = sentence.trim().toLowerCase().split("\\s+");

        //2. Use HashMap to count frequency
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        // 3. Sort entries by frequency-descending then aphabetically-ascending
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((e1, e2) -> {
            int freqCompare = Integer.compare(e2.getValue(), e1.getValue()); // descending frequency
            if (freqCompare != 0) return freqCompare;
            return e1.getKey().compareTo(e2.getKey()); // ascending alphabetically
        });
        //4. Pick top 3 and sort alphabet=
        List<String> topWords = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedEntries.size()); i++) {
            topWords.add(sortedEntries.get(i).getKey());
        }
        // final alphabetical sort
        Collections.sort(topWords);
        return topWords;
    }
    //TEST CASES
    public static void runTests() {
        System.out.println("Running test cases...");

        // Test 1: Given example
        String input1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + getTopThreeWords(input1));

        // Test 2: Words with same frequency
        String input2 = "apple banana apple banana cherry";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + getTopThreeWords(input2));

        // Test 3: Fewer than 3 words
        String input3 = "only one";
        System.out.println("Input: " + input3);
        System.out.println("Output: " + getTopThreeWords(input3));

        // Test 4: Empty input
        String input4 = "  ";
        System.out.println("Input: '" + input4 + "'");
        System.out.println("Output: " + getTopThreeWords(input4));

        // Test 5: Same word repeated
        String input5 = "repeat repeat repeat";
        System.out.println("Input: " + input5);
        System.out.println("Output: " + getTopThreeWords(input5));
    }

    public static void main(String[] args) {
        runTests();
    }

}
