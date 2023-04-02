package CodeChef.CookOff.Cook143D;

import java.io.*;

/**
 * Tea
 * Problem Statement: To determine min. amount Chef has to pay.
 * URL: https://www.codechef.com/COOK143D/problems/TEA
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 6 3 3 
 * 			Output: 6
 *		Test Case 2: 
 * 			Input Array: 5 7 2
 * 			Output: 2
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class Tea {
	static int testCaseSize, data[][], result[];

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
        result = new int[testCaseSize];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	data[i][0] = Integer.parseInt(arrInput[0]); // X
            data[i][1] = Integer.parseInt(arrInput[1]); // Y
            data[i][2] = Integer.parseInt(arrInput[2]); // Z
        }
    }

    public static void runTestCase() throws IOException  {
        // Calculate Min. Amount
        calcMinAmt();
        // Printing Min Amount too pay
        printArray(result);
    }

    private static void calcMinAmt() {
        for(int i=0; i<testCaseSize; ++i) {
            result[i] = (int) (Math.ceil(data[i][0] / (double)data[i][1]) * data[i][2]);
        }
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }
}
