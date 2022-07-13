package SearchingAndSorting;

import java.io.*;

/**
 * FindPivotIndex
 * Problem Statement: To return the the leftmost pivot index. If no such index exists, return -1.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index 
 * is equal to the sum of all the numbers strictly to the index's right.
 * URL: https://leetcode.com/problems/find-pivot-index/
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1,7,3,6,5,6
 * 			Output: 3
 *		Test Case 2: 
 * 			Input Array: 1,2,3
 * 			Output: -1
 *		Test Case 3: 
 * 			Input Array: 2,1,-1
 * 			Output: 0
 */

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class FindPivotIndex {
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
        System.out.print("Array: ");  
        printArray(arr);
        // find pivot index
        int index = findPivotIndex(arr);
        // Printing the output
        System.out.println("Pivot Index: "+index);
        System.out.println("=================================="); 
    }

    private static int findPivotIndex(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        // Calculating sum of all elements right to index 0
        for(int i=1; i<arr.length; ++i)
            sumRight+=arr[i];
        for(int i=0; i<arr.length; ++i){
        	// Comparing Left and Right Sum
            if(sumLeft==sumRight)
                return i;
            // Adding current element to Left-Sum
            sumLeft += arr[i];
            // Removing next element from Right-Sum
            if(i+1<arr.length)
                sumRight -= arr[i+1];
        }
        return -1;
    }

    private static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
