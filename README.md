Tufin Junior Developer Technical Assessment

**Language Used:** Java 17  
**Project Folder:** `take-home-tana-test`

This repository contains Java solutions to the 7 technical questions provided by Tufin. Each question is implemented in a separate file and follows best practices: clean code, meaningful variable names, inline comments explaining logic, and test cases for validation.
HOW TO RUN
From the terminal (or your IDE):

javac QuestionX_*.java
java QuestionX_*
Replace X with the question number e.g javac Question1_LongestValidStringFinder.java
Then java Question1_LongestValidStringFinder

Question 1 - Question1_GetLongestString.java
Goal: To find the longest string with no consecutive duplicates and only valid characters.
Approach: Loop through the array, validate each string, and return the longest valid one.

Question 2 - Question2_UniqueSums.java
Goal: To count the number of unique combinations that sum to a target value.
Approach: Backtracking with a Set to track sorted combinations for uniqueness.

Question 3 - Question3_ArrayToZero.java
Goal: Determine if array can be reduced to all zeros (except the first) using a[i] = a[i] - a[i-1].
Approach: Simulate backward with modulo; return 0 if invalid or division by zero.

Question 4 - Question4_UniqueProduct.java
Goal: Find the first product that appears only once.
Approach: Use LinkedHashMap to count frequencies while maintaining order.

Question 5 - Question5_ClosestMinimumDistance.java
Goal: Find the smallest distance between two identical minimum elements.
Approach: Track last seen index of minimum and calculate min distance.

Question 6 - Question6_CommonWords.java
Goal: Return the 3 most frequent words in a sentence.
Approach: Count word frequencies using a map, then sort and return top 3 alphabetically.

Question 7 - Question7_RotateLinkedList.java
Goal: Rotate a linked list n times to the right.
Approach: Find length, create circular link, break at correct index.
