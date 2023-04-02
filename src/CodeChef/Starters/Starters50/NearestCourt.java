package CodeChef.Starters.Starters50;

import java.io.*;
/**
 * NearestCourt
 * Problem Statement: To find a court such that the maximum distance travelled by either player is minimized.
 * URL: https://www.codechef.com/START50D/problems/NEARESTCOURT
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 3 5
 * 			Output: 1
 *		Test Case 2: 
 * 			Input: 1 10
 * 			Output: 5
 *		Test Case 3: 
 * 			Input: 63 31
 * 			Output: 16
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class NearestCourt {
	static int testCaseSize, arr[][];

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
        	String[] str = read.readLine().split("\\s");
            // Initializing with the user input
        	arr[i][0] = Integer.parseInt(str[0]);// x
        	arr[i][1] = Integer.parseInt(str[1]);// y
        }
    }

    public static void runTestCase(int x, int y) throws IOException  {
        // Calculate the mid Point
    	int mid = (int) Math.ceil((x + y) / (float)2);
        // Return min of |x-mid| and |y-mid|
    	int result = Math.max(Math.abs(x-mid), Math.abs(y-mid)); 
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