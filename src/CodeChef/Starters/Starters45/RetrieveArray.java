package CodeChef.Starters.Starters45;

import java.io.*;
/**
 * RetrieveArray
 * Problem Statement: To return Array-A from Array-B.
 * URL: https://www.codechef.com/submit/ARRAYRET
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 6
 * 			Output Array: 3
 *		Test Case 2: 
 * 			Input Array: 7 8 9
 * 			Output Array: 1 2 3
 *		Test Case 3: 
 * 			Input Array: 13 15 13 14
 * 			Output Array: 2 4 2 3
 *		Test Case 3: 
 * 			Input Array: 25 20
 * 			Output Array: 10 5
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... Storing arrA
 */

public class RetrieveArray {
	static int testCaseSize, arrSize[];
	static long arrB[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(i);
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
        arrSize = new int[testCaseSize];
        arrB = new long[testCaseSize][];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
        	arrSize[i] = Integer.parseInt(read.readLine());
            arrB[i] = new long[arrSize[i]];
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            for(int j=0; j<arrSize[i]; ++j)
            	arrB[i][j] = Long.parseLong(arrInput[j]); 
        }
    }

    public static void runTestCase(int testCase) throws IOException  {
        // Generating array A from array B
    	long[] arrA = generateArrayA(arrB[testCase]);
        // Printing the result
        printArray(arrA);
    }

    private static long[] generateArrayA(long[] arrB) {
    	long[] result = new long[arrB.length];
    	long sumB = 0;
    	for(int i=0; i<arrB.length; ++i)
    		sumB += arrB[i];
    	long fN = sumB / (arrB.length + 1);
    	for(int i=0; i<result.length; ++i)
    		result[i] = arrB[i] - fN;
        return result;
	}

    public static void printArray(long arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}
