package Recursion;

import java.io.*;

/**
 * BubbleSort
 * Problem Statement: To sort the array in non-decreasing order using the Bubble Sort algorithm. 
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 4 3 2 7 8 2 3 1
 * 			Output: 1 2 2 3 3 4 7 8
 *		Test Case 2: 
 * 			Input Array: 1 2 2 3
 * 			Output: 1 2 2 3
 *		Test Case 3: 
 * 			Input Array: 5 8 9 6 4 2
 * 			Output: 2 4 5 6 8 9
 */

/**
 * Time Complexity: O(n*n)
 * Space Complexity: O(1)
 */

public class BubbleSort {
    static int testCaseSize, arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(arr[i]);
        }
    }

    private static void takeTestCaseInput() throws IOException  {
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
        	int arrSize = 0;
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

    private static void runTestCase(int[] arr) throws IOException  {
        // Printing the array
        System.out.print("Array before sort: ");  
        printArray(arr);
        // Sort the array using Bubble Sort algorithm.
        arr = bubbleSort(arr, 0, 0);
        // Printing the output
        System.out.print("Array after Sort: ");  
        printArray(arr);
        System.out.println("=================================="); 
    }

    private static int[] bubbleSort(int[] arr, int start , int round) {
    	if(round == arr.length-1)
    		return arr; 
    	if(start + 1 > arr.length - 1 - round) // End of current round
    		return bubbleSort(arr, 0, round+1); // Start New Round
    	if(arr[start] > arr[start+1]) {
    		// Swap
            int temp = arr[start+1];
            arr[start+1] = arr[start];
            arr[start] = temp;
        }
    	return bubbleSort(arr, start+1, round); // BubbleSort further in current round
    }

    private static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
