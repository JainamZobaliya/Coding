package CodeChef.Starters.Starters48;

import java.io.*;
/**
 * BuyLamps
 * Problem Statement: To find the minimum amount of money Chef needs to pay for lamps.
 * URL: https://www.codechef.com/START48D/problems/BUYLAMP
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 2 2 5 1
 * 			Output: 10
 *		Test Case 2: 
 * 			Input Array: 4 1 3 1
 * 			Output: 6
 *		Test Case 3: 
 * 			Input Array: 3 0 4 7
 * 			Output: 12
 *		Test Case 4: 
 * 			Input Array: 5 2 3 4
 * 			Output: 15
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class BuyLamps {
	static int testCaseSize, arr[][] ;

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
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
        arr = new int[testCaseSize][4];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	arr[i][0] = Integer.parseInt(arrInput[0]); // N
        	arr[i][1] = Integer.parseInt(arrInput[1]); // K
        	arr[i][2] = Integer.parseInt(arrInput[2]); // X
        	arr[i][3] = Integer.parseInt(arrInput[3]); // Y
        }
    }

    public static void runTestCase(int n, int k, int x, int y) throws IOException  {
        // Calculate min. amount to pay
    	int fixedAmount = k*x;
    	int moreAmount = x<y ? (n-k)*x : (n-k)*y; 
    	int result = fixedAmount + moreAmount;
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