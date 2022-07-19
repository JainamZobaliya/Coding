package SearchingAndSorting;

import java.io.*;

/**
 * SquareRootWithPrecision
 * Problem Statement: To return the square root of the number-N.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 37
 * 			Output: 6.08276
 *		Test Case 2: 
 * 			Input: 3
 * 			Output: 1.732
 *		Test Case 3: 
 * 			Input: 25
 * 			Output: 5
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class SquareRootWithPrecision {
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
	        number[i] = Long.parseLong(read.readLine());
	    }
    }

    private static void runTestCase(long number) throws IOException  {
        // Get Square Root of the number, it will lie between 0 to number
    	double sqrt = squareRoot(number);
        // Printing the output
        System.out.println("Square Root of : "+number+" is: "+sqrt);
        System.out.println("=================================="); 
    }

    private static float squareRoot(long num) {
        // Binary Search to get Square Root of the number
    	long start = 0, end = num;
    	float ans = -1;
    	while(start<=end) {
    		long mid = getMidIndex(start, end);
    		double squareOfMid = mid * mid;
    		if(squareOfMid == num)
    			return mid;
    		else if(squareOfMid>num)
    			end = mid-1;
    		else {
    			ans = mid;
    			start = mid+1;
    		}
    	}
    	ans = precision(ans, num, 5);
        return ans;
    }
    
    private static float precision(double prefix, float number, int maxPrecision) {
    	float factor = 1;
    	float ans = (float)prefix;
    	for(int i=0; i<maxPrecision; ++i) {
    		factor /= 10;
    		for(float j=ans; j*j<= number;) {
    			ans = j;
    			j=j+factor;
    		}
    	}
    	return ans;
    }
    
    private static long getMidIndex(long start, long end) {
    	return start + (end-start)/2; // To avoid error due to range
    }
    
}
