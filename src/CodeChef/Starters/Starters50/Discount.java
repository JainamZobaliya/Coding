package CodeChef.Starters.Starters50;

import java.io.*;
/**
 * Discount
 * Problem Statement: To find the amount Alice needs to pay.
 * URL: https://www.codechef.com/START50D/problems/DISCNT
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 11
 * 			Output: 89
 *		Test Case 2: 
 * 			Input: 21
 * 			Output: 79
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class Discount {
	static int testCaseSize, arr[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i]);
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
        arr = new int[testCaseSize];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            // Initializing with the user input
        	arr[i] = Integer.parseInt(read.readLine());// x
        }
    }

    public static void runTestCase(int x) throws IOException  {
        // find the amount to pay
    	int result = 100 - x; 
        // Printing the result
        System.out.println(result < 0 ? 0 : result );
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}