package CodeChef.Starters.Starters48;

import java.io.*;
/**
 * FillCandies
 * Problem Statement: To find the minimum number of bags Chef needs to put every candy into a bag.
 * URL: https://www.codechef.com/START48D/problems/FILLCANDIES
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 6 2 3
 * 			Output: 1
 *		Test Case 2: 
 * 			Input Array: 3 1 2
 * 			Output: 2
 *		Test Case 3: 
 * 			Input Array: 8 4 1
 * 			Output: 2
 *		Test Case 4: 
 * 			Input Array: 25 4 2
 * 			Output: 4
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class FillCandies {
	static int testCaseSize, arr[][] ;

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
        	arr[i][0] = Integer.parseInt(arrInput[0]); // N
        	arr[i][1] = Integer.parseInt(arrInput[1]); // K
        	arr[i][2] = Integer.parseInt(arrInput[2]); // M
        }
    }

    public static void runTestCase(int n, int k, int m) throws IOException  {
        // Calculate no. of bags required
    	int result = (int) Math.ceil(n/(double)(k*m));
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