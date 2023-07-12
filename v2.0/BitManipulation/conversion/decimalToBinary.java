package conversion;
/**
 * Decimal To Binary
 * Problem Statement: To convert decimal number to its binary representation.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 12
 * 			Output: 1100
 *		Test Case 2: 
 * 			Input: 13
 * 			Output: 1101
 */

/**
 * Time Complexity: O(logn) base 2, n is decimal No.
 * Space Complexity: O(1)
 */


public class decimalToBinary {    
    public static String getBinaryOf(int decimalNo) {
        String binaryNo = "";
        while (decimalNo != 0) {
            int remainder = decimalNo % 2;
            decimalNo = decimalNo / 2;
            binaryNo = remainder + "" + binaryNo;
        }
        return binaryNo;
    }
    public static void main(String[] args) {
        int decimalNo = 14;
        String binaryNo = getBinaryOf(decimalNo);
        System.out.println("decimal No.: " + decimalNo);
        System.out.println("binary No.: " + binaryNo);
    }
}
