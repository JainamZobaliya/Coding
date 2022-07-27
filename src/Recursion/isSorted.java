package Recursion;

import java.io.*;

/**
 * isSorted
 * Problem Statement: To find whether array is sorted or not.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 4 3 2 7
 * 			Output: NO
 *		Test Case 2: 
 * 			Input Array: 1 1 2
 * 			Output: YES
 *		Test Case 3: 
 * 			Input Array: 1
 * 			Output: YES
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class isSorted {
    static int testCaseSize, arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(arr[i]);
        }
    }

    public static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
                System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        // Take input for current test case
        arr = new int[testCaseSize][];
        for(int i=0; i<testCaseSize; ++i) {
            int arrSize = -1;
	        do{
	            try{
	                System.out.print("Enter arrSize of array: ");
	                arrSize = Integer.parseInt(read.readLine());
	            } catch (Exception err) {
	                System.out.println("Error: " + err);
	            }
	        } while(arrSize<=0); 
	        // Instantiation array with the user input arrSize
	        arr[i] = new int[arrSize];
	        System.out.print("Enter array elements(space separated): ");
	        String[] arrInput = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<arrSize; ++j)
	            arr[i][j] = Integer.parseInt(arrInput[j]);
	    }
    }

    public static void runTestCase(int[] arr) throws IOException  {
        // Printing the array
        System.out.print("Array: ");  
        printArray(arr);
        // Checking is Array Sorted
        String result = isArraySorted(arr, arr.length-1) ? "YES" : "NO";
        // Printing the result
        System.out.println("is Array Sorted?: "+result);
        System.out.println("=================================="); 
    }

    private static Boolean isArraySorted(int[] arr, int position) {
    	// Base Case
    	if(position==0) // Only 1 element is sorted
    		return true;
		// Recursive Relation
		Boolean result = isArraySorted(arr, position-1);
		// Processing Part
		// Compare if current and previous element are sorted and rest all previous elements are sorted
		return result && arr[position-1] <= arr[position]; 
	}

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
