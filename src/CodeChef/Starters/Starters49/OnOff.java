package CodeChef.Starters.Starters49;

import java.io.*;
/**
 * OnOff
 * Problem Statement: To determine the final state of the bulb.
 * URL: https://www.codechef.com/START49D/problems/ON_OFF
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


public class OnOff {
	static int testCaseSize, buttonsCount[];
	static String buttonsState[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(buttonsCount[i], buttonsState[i][0], buttonsState[i][1]);
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
        buttonsCount = new int[testCaseSize];
        buttonsState = new String[testCaseSize][2];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            // Initializing with the user input
        	buttonsCount[i] = Integer.parseInt(read.readLine());// n
        	buttonsState[i][0] = read.readLine();// S
        	buttonsState[i][1] = read.readLine();// R
        }
    }

    public static void runTestCase(int n, String s, String r) throws IOException  {
        // determine the final state of the bulb
    	int result = 0;
    	Boolean initialBulbState = false;
    	Boolean finalBulbState = false;
    	for(int i=0; i<n; ++i) {
    		char initialState = s.charAt(i);
    		char finalState = r.charAt(i);
    		if(initialState == finalState) {
    			initialBulbState = initialState == '0' ? false : true;
    			finalBulbState = initialBulbState;
    		}
    		else {
    			initialBulbState = initialState == '0' ? false : true;
    			finalBulbState = !initialBulbState;
    		}
    	}
        // Printing the result
        System.out.println(finalBulbState ? 1 : 0);
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}