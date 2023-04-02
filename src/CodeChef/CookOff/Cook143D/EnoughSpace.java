package CodeChef.CookOff.Cook143D;

import java.io.*;

/**
 * EnoughSpace
 * Problem Statement: To determine Chef can save files or not.
 * URL: https://www.codechef.com/COOK143D/problems/ENSPACE
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 6 3 1 
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 2 2 2
 * 			Output: NO
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class EnoughSpace {
	static int testCaseSize, data[][];
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
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	data[i][0] = Integer.parseInt(arrInput[0]); // N
            data[i][1] = Integer.parseInt(arrInput[1]); // X
            data[i][2] = Integer.parseInt(arrInput[2]); // Y
        }
    }

    public static void runTestCase() throws IOException  {
        // Check Space
        checkSpace();
        // Printing Space Available or not
        printArray(result);
    }

    private static void checkSpace() {
        for(int i=0; i<testCaseSize; ++i) {
            result[i] = (data[i][1] + 2*data[i][2]) <= data[i][0] ? "YES" : "No";
        }
	}

    public static void printArray(String arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }
}
