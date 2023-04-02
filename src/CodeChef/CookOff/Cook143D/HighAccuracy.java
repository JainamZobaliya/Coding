package CodeChef.CookOff.Cook143D;

import java.io.*;

/**
 * HighAccuracy
 * Problem Statement: To determine min. no. of incorrect Questions
 * URL: https://www.codechef.com/COOK143D/problems/ACCURACY
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 100
 * 			Output: 0
 *		Test Case 2: 
 * 			Input: 32
 * 			Output: 1
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class HighAccuracy {
	static int testCaseSize, marks[], result[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        runTestCase();
    }

    private static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
            	// System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        marks = new int[testCaseSize];
        result = new int[testCaseSize];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i)
            marks[i] = Integer.parseInt(read.readLine());
    }

    public static void runTestCase() throws IOException  {
        // Calculate Min. Wrong Attempts
        minWrongAttempts();
        // Printing No. of Wrong Q. Attempted
        printArray(result);
    }

    private static void minWrongAttempts() {
        for(int i=0; i<testCaseSize; ++i) {
            result[i] = (int) (Math.ceil((double) marks[i] / 3) * 3 - marks[i]);
        }
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }
}
