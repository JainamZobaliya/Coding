package CodeChef.CookOff.Cook143D;

import java.io.*;
import java.util.Arrays;

/**
 * KMex
 * Problem Statement: To determine if K can be min. non negative number from M elements of an array
 * URL: https://www.codechef.com/COOK143D/problems/KMEX
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 0 1 3 0 3
 * 			Input M: 4
 * 			Input K: 2
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 0 1
 * 			Input M: 1
 * 			Input K: 2
 * 			Output: NO
 */

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class KMex {
	static int testCaseSize, data[][], arr[][];
	static String result[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        runTestCase();
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
        data = new int[testCaseSize][3];
        result = new String[testCaseSize];
        arr = new int[testCaseSize][];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	data[i][0] = Integer.parseInt(arrInput[0]); // N
            data[i][1] = Integer.parseInt(arrInput[1]); // M
            data[i][2] = Integer.parseInt(arrInput[2]); // K
            arr[i] = new int[data[i][0]];
            // Storing Array-input
            arrInput = read.readLine().split("\\s");
            for(int j=0; j<data[i][0]; ++j) {
            	arr[i][j] = Integer.parseInt(arrInput[j]);
            }
        }
    }

    public static void runTestCase() throws IOException  {
        // Check KMEX
        checkKMex();
        // Printing k is mex or not
        printArray(result);
    }

    private static void checkKMex() {
        for(int i=0; i<testCaseSize; ++i) {
        	int countK = 0;
        	int k = data[i][2];
        	for(int j=0; j<arr[i].length; j++) {
        		if(arr[i][j] == k)
        			++countK;
        	}
        	getMex(arr[i]);
            result[i] = (data[i][0] - countK) >= data[i][1] ? "YES" : "No";
        }
	}
    
    public static int getMex(int[] arr) {
    	int mex = 0;
    	Arrays.sort(arr);
    	for(int i=0; i<arr.length; ++i) {
    		if(arr[i] == mex)
    			mex++;
    		if(arr[i]>mex)
    			break;
    	}
    	System.out.println("MEX is: " + mex);
    	return mex;
    }

    public static void printArray(String arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }
}
