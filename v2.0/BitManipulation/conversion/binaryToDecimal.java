package conversion;
/**
 * Binary To Decimal
 * Problem Statement: To convert binary representation to its deciaml number.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1100
 * 			Output: 12
 *		Test Case 2: 
 * 			Input: 1101
 * 			Output: 13
 */

/**
 * Time Complexity: O(n) , n: length of binary No.
 * Space Complexity: O(1)
 */


public class binaryToDecimal {

    public static int getDecimalOf(String binaryString) {
        int decimalNo = 0;
        for (int i = 0; i < binaryString.length(); ++i) {
            int value = (binaryString.charAt(binaryString.length() - i - 1) - '0');
            decimalNo += (value * Math.pow(2, i));
            // System.out.println(i+" -> " + value + " * " + Math.pow(2, i) + " = "+decimalNo);
        }
        return decimalNo;
    }

    public static void main(String[] args) {
        String binaryNo = "1100";
        int decimalNo = getDecimalOf(binaryNo);
        System.out.println("binary No.: " + binaryNo);
        System.out.println("decimal No.: " + decimalNo);
    }
}

