
/**
 * Bit Masking
 * Problem Statement: To Perform Operations using Bit Masking.
 * Operations:
 *      1. Find ith bit.
 *      2. Set ith bit.
 *      3. Clear ith bit.
 *      4. Find no. of bits to change a to b
 *      5. No. of digits in Binary No. = log n base 2 + 1
 *      6. No. of digits in Decimal No. = log n base 10 + 1
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 110010101, i=5
 * 			Output-1: 0
 * 			Output-2: 110110101
 * 			Output-3: 110010101
 * 			Output-4: a=110010101, b=10100101 => 3
 * 			Output-5: 4 (100) -> log 4 base 2 + 1 = 3 
 * 			Output-6: 4 -> log 4 base 10 + 1 = 1
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

import conversion.decimalToBinary;

public class bitMasking {

    private static int findBit(int i, int decimalNo) {
        int mask = 1 << i; // 1 << 5 => 0001 << 5 => 00100000
        int bit = decimalNo & mask; // 110010101 & 00100000 => 000000000
        // System.out.println(decimalToBinary.getBinaryOf(decimalNo));
        // System.out.println(decimalToBinary.getBinaryOf(mask));
        // System.out.println(decimalToBinary.getBinaryOf(bit));
        int result = bit == 0 ? 0 : 1;
        return result;    
    }

    private static int setBit(int i, int decimalNo) {
        int mask = 1 << i; // 1 << 5 => 0001 << 5 => 00100000
        int bit = decimalNo | mask; // 110010101 | 00100000 => 111010101
        // System.out.println(decimalToBinary.getBinaryOf(decimalNo));
        // System.out.println(decimalToBinary.getBinaryOf(mask));
        // System.out.println(decimalToBinary.getBinaryOf(bit));
        return bit;    
    }

    private static int clearBit(int i, int decimalNo) {
        int mask = ~(1 << i); // ~(1 << 5) => ~(0001 << 5) => ~(00100000) => 11011111
        int bit = decimalNo & mask; // 110010101 & 11011111 => 110010101
        // System.out.println(decimalToBinary.getBinaryOf(decimalNo));
        // System.out.println(decimalToBinary.getBinaryOf(mask));
        // System.out.println(decimalToBinary.getBinaryOf(bit));
        return bit;    
    }

    private static int countBit(int number1, int number2) {
        /* Method-1: Using odd/even check
            number1 = 8 -> 2**3 -> 1000
            number2 = 4 -> 2**2 -> 0100
            count = 0
            check odd/even of number1 and number2
            if odd, ++count,
            remove last bit from number1 and number2 i.e. right Shift
            do again, untill number1 and number2 becomes 0
            TC: O(logn+1), SC: O(1)
         */
        int count = 0;
        while (number1 != 0 || number2 != 0) {
            if ((number1 & 1) != (number2 & 1)) {
                count++;
            }
            number1 = number1 >> 1;
            number2 = number2 >> 1;
        }
        return count;    
    }

    public static void main(String[] args) {
        int number = 102; 
        int operation = 4;
        int i = 5;
        switch (operation) {
            case 1:
                int bit = findBit(i, number);
                String binaryString = decimalToBinary.getBinaryOf(number);
                System.out.println("Given Decimal No.: " + number);
                System.out.println("Given Bit String: " + binaryString);
                System.out.println("Bit at position " + i + " : " + bit);
            break;
            case 2:
                int newNumber = setBit(i, number);
                binaryString = decimalToBinary.getBinaryOf(number);
                String newBinaryString = decimalToBinary.getBinaryOf(newNumber);
                System.out.println("Given Decimal No.: " + number + " => " + binaryString);
                System.out.println("After Setting Bit at " + i + "'th position, No.: " + newNumber + " => " + newBinaryString);
            break;
            case 3:
                newNumber = clearBit(i, number);
                binaryString = decimalToBinary.getBinaryOf(number);
                newBinaryString = decimalToBinary.getBinaryOf(newNumber);
                System.out.println("Given Decimal No.: " + number + " => " + binaryString);
                System.out.println("After Clearing Bit at " + i + "'th position, No.: " + newNumber + " => " + newBinaryString);
            break;
            case 4:
                int number1 = 14;
                int number2 = 20;
                int count = countBit(number1, number2);
                String number1BinaryString = decimalToBinary.getBinaryOf(number1);
                String number2BinaryString = decimalToBinary.getBinaryOf(number2);
                System.out.println("Given Number-1: " + number1 + " => " + number1BinaryString);
                System.out.println("Given Number-2: " + number2 + " => " + number2BinaryString);
                System.out.println(count + " bits need to be flipped to convert " + number1 + " to " + number2);
            break;
        default:
            System.out.println("Invalid Operation");
            break;
        }
    }
}