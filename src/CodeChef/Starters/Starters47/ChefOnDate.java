package CodeChef.Starters.Starters47;

import java.io.*;
/**
 * ChefOnDate
 * Problem Statement: To find Chef has enough money or not
 * URL: https://www.codechef.com/START47D/problems/CHEFONDATE
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 1
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 1 2
 * 			Output: NO
 *		Test Case 3: 
 * 			Input Array: 2 1
 * 			Output: YES
 *		Test Case 4: 
 * 			Input Array: 50 100
 * 			Output: NO
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class ChefOnDate {
	static int testCaseSize, arr[][] ;

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i][0], arr[i][1]);
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
        arr = new int[testCaseSize][2];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	arr[i][0] = Integer.parseInt(arrInput[0]); // X
        	arr[i][1] = Integer.parseInt(arrInput[1]); // Y
        }
    }

    public static void runTestCase(int x, int y) throws IOException  {
        // Compare X and Y
    	String result = x>=y ? "YES" : "NO";
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

