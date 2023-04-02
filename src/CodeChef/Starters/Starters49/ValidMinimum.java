package CodeChef.Starters.Starters49;

import java.io.*;
/**
 * ValidMinimum
 * Problem Statement: To find if there exists any valid tuple (A, B, C) or not.
 * URL: https://www.codechef.com/START49D/problems/VALIDMIN
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 5 5 5 
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 2 3 4
 * 			Output: NO
 *		Test Case 3: 
 * 			Input Array: 2 2 4
 * 			Output: YES
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class ValidMinimum {
	static int testCaseSize, arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i][0], arr[i][1], arr[i][2]);
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
        arr = new int[testCaseSize][3];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	arr[i][0] = Integer.parseInt(arrInput[0]); // x // Min(A,B)
        	arr[i][1] = Integer.parseInt(arrInput[1]); // y // Min(B,C)
        	arr[i][2] = Integer.parseInt(arrInput[2]); // z // Min(C,A)
        }
    }

    public static void runTestCase(int x, int y, int z) throws IOException  {
        // find if there exists any valid tuple (A, B, C) or not
    	String result = isValidMin(x,y,z) ? "YES" : "NO";
        // Printing the result
        System.out.println(result);
    }
    
    private static Boolean isValidMin(int x, int y, int z) {
		if ( x==y & y==z)
			return true;
		return true;
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}