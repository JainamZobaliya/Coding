package CodeChef.Starters.Starters48;

import java.io.*;
/**
 * FillTheGrid
 * Problem Statement: To find Find the minimum number of 1×1 tiles you have to use to fill the grid.
 * URL: https://www.codechef.com/START48D/problems/GRIDBL
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 1
 * 			Output: 1
 *		Test Case 2: 
 * 			Input Array: 4 5
 * 			Output: 4
 *		Test Case 3: 
 * 			Input Array: 6 8
 * 			Output: 0
 *		Test Case 4: 
 * 			Input Array: 3 2
 * 			Output: 2
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class FillTheGrid {
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
        	arr[i][0] = Integer.parseInt(arrInput[0]); // N
        	arr[i][1] = Integer.parseInt(arrInput[1]); // M
        }
    }

    public static void runTestCase(int n, int m) throws IOException  {
        // Calculate min. no. of 1x1 tiles required
    	int area = n*m;
    	int req2x2 = (n % 2 == 0 && m%2 ==0) ? n*m / 4 : 
    		((n%2==0 && m%2!=0) ? n*(m-1) / 4 : 
    			((n%2!=0 && m%2==0) ? (n-1)*m / 4 : 
    				(n-1)*(m-1)/4));
    	int req1x1 = area - req2x2*4; 
        // Printing the result
        System.out.println(req1x1);
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}