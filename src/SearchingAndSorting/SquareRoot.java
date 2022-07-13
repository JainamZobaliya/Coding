package SearchingAndSorting;

import java.io.*;

/**
 * SquareRoot
 * Problem Statement: To return the square root of the number-N. If ‘N’ is not a perfect square,
 * then return the floor value of sqrt(N).
 * URL: https://leetcode.com/problems/sqrtx/
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 25
 * 			Output: 5
 *		Test Case 2: 
 * 			Input: 20
 * 			Output: 4
 *		Test Case 3: 
 * 			Input: 10
 * 			Output: 3
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class SquareRoot {
    static long testCaseSize, number[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(number[i]);
        }
    }

    private static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
                System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Long.parseLong(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        // Take input for current test case
        number = new long[(int) testCaseSize];
        for(int i=0; i<testCaseSize; ++i) {
	        System.out.print("Enter the number: ");
	        number[i] = Integer.parseInt(read.readLine());
	    }
    }

    private static void runTestCase(long number) throws IOException  {
        // Get Square Root of the number, it will lie between 0 to number
    	long sqrt = squareRoot(number);
        // Printing the output
        System.out.println("Square Root of : "+number+" is: "+sqrt);
        System.out.println("=================================="); 
    }

    private static long squareRoot(long num) {
        // Binary Search to get Square Root of the number
    	long start = 0, end = num;
    	long ans = -1;
    	while(start<=end) {
    		long mid = getMidIndex(start, end);
        	long squareOfMid = mid * mid;
    		if(squareOfMid == num)
    			return mid;
    		else if(squareOfMid>num)
    			end = mid-1;
    		else {
    			ans = mid;
    			start = mid+1;
    		}
    	}
        return ans;
    }
    
    private static long getMidIndex(long start, long end) {
    	return start + (end-start)/2; // To avoid error due to range
    }
    
}
