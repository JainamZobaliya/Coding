/**
 * Check Odd/Even
 * Problem Statement: To Check given number is odd or even.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 12
 * 			Output: Even
 *		Test Case 2: 
 * 			Input: 13
 * 			Output: Odd
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class checkOddEven {
    public static void main(String[] args) {
        int number = 12;
        String result = "Odd";
        // Method-1 - TC: O(1), SC: O(1)
        if (number % 2 == 0) {
            result = "Even";
        }
        System.out.println("M-1: Given Number " + number + " is " + result);
        // Method-2 - TC: O(1), SC: O(1)
        //   1100    1101
        // & 0001  & 0001
        // = 0000  = 0001
        result = ((number & 1) == 1) ? "Odd" : "Even";
        System.out.println("M-2: Given Number " + number + " is " + result);
        // & is faster than %, as operations is happening on bits.
    }

}

