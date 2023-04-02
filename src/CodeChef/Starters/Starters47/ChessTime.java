package CodeChef.Starters.Starters47;

import java.io.*;
/**
 * ChessTime
 * Problem Statement: To find the maximum number of complete chess games Chef can play.
 * URL: https://www.codechef.com/START47D/problems/CHESSTIME
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1
 * 			Output: 3
 *		Test Case 2: 
 * 			Input: 10
 * 			Output: 30
 *		Test Case 3: 
 * 			Input: 7
 * 			Output: 21
 *		Test Case 4: 
 * 			Input: 3
 * 			Output: 9
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class ChessTime {
	static int testCaseSize, arr[] ;

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
            // Initializing array with the user array input
        	arr[i] = Integer.parseInt(read.readLine()); // N
        }
    }

    public static void runTestCase(int n) throws IOException  {
        // Calculate the maximum number of complete chess games Chef can play
    	int result = (n*60 / 20);
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

