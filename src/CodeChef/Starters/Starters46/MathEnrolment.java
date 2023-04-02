package CodeChef.Starters.Starters46;

import java.io.*;
/**
 * MathEnrolment
 * Problem Statement: To find the the minimum number of seats required to be added.
 * URL: https://www.codechef.com/START46D/problems/M1ENROL
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 1
 * 			Output: 0
 *		Test Case 2: 
 * 			Input Array: 4 2
 * 			Output: 0
 *		Test Case 3: 
 * 			Input Array: 2 4
 * 			Output: 2
 *		Test Case 4: 
 * 			Input Array: 12 34
 * 			Output: 22
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class MathEnrolment {
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
        // Calculate total no. of extra seats
    	int result = y - x;
        // Printing the result
        System.out.println(result < 0 ? 0 : result);
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}

