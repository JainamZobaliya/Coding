/**
 * swap 2 Numbers
 * Problem Statement: To Swap given 2 number's.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 12 13
 * 			Output: 13 12
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class swap2Numbers {
    public static void main(String[] args) {
        int number_1 = 12;
        int number_2 = 13;
        System.out.println("M-1: Before Operations: " + number_1 + ", " + number_2);
        // Method-1 - TC: O(1), SC: O(1)
        int temp = number_1;
        number_1 = number_2;
        number_2 = temp;
        System.out.println("M-1: After Operations: " + number_1 + ", " + number_2);
        number_1 = 12;
        number_2 = 13;
        System.out.println("M-2: Before Operations: " + number_1 + ", " + number_2);
        // Method-2 - TC: O(1), SC: O(1)
        //  a    1100
        //  b    1101
        // c=a^b 1100 ^ 1101 = 0001
        // b=c^b 0001 ^ 1101 = 1100
        // a=c^a 0001 ^ 1100 = 1101 
        temp = number_1 ^ number_2;
        number_1 = temp ^ number_1;
        number_2 = temp ^ number_2;
        System.out.println("M-1: After Operations: " + number_1 + ", " + number_2);
    }
}

