package CodeChef.Starters.Starters49;

import java.io.*;
/**
 * MaxTaste
 * Problem Statement: To find the maximum possible tastiness of the dish that the chef can prepare.
 * URL: https://www.codechef.com/START49D/problems/MAXTASTE
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 3 5 6 2
 * 			Output: 11
 *		Test Case 2: 
 * 			Input Array: 16 15 5 4
 * 			Output: 21
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class MaxTaste {
	static int testCaseSize, arr[][];

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
        	arr[i][0] = Integer.parseInt(arrInput[0]); // a
        	arr[i][1] = Integer.parseInt(arrInput[1]); // b
        	arr[i][2] = Integer.parseInt(arrInput[2]); // c
        	arr[i][3] = Integer.parseInt(arrInput[3]); // d
        }
    }

    public static void runTestCase(int a, int b, int c, int d) throws IOException  {
        // find whether the climate is HOT or COLD
    	int ingredient1 = a > b ? a : b;
    	int ingredient2 = c > d ? c : d;
    	int result = ingredient1 + ingredient2;
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