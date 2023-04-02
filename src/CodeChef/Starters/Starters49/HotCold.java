package CodeChef.Starters.Starters49;

import java.io.*;
/**
 * HotCold
 * Problem Statement: To find whether the climate is HOT or COLD.
 * URL: https://www.codechef.com/START49D/problems/HOTCOLD
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 21
 * 			Output: HOT
 *		Test Case 2: 
 * 			Input: 16
 * 			Output: COLD
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class HotCold {
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
        	arr[i] = Integer.parseInt(read.readLine());// C
        }
    }

    public static void runTestCase(int c) throws IOException  {
        // find whether the climate is HOT or COLD
    	String result = c > 20 ? "HOT" : "COLD";
        // Printing the result
        System.out.println(result);
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}