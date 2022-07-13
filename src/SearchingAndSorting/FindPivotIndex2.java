package SearchingAndSorting;

import java.io.*;

/**
 * FindPivotIndex2
 * Problem Statement: To return the the pivot index.
 * The pivot index is the index of the smallest element in the rotated sorted array.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 6 7 3 5
 * 			Output: 2
 *		Test Case 2: 
 * 			Input Array: 3 1 2
 * 			Output: 1
 *		Test Case 3: 
 * 			Input Array: 15 18 19 12 14 15
 * 			Output: 3
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class FindPivotIndex2 {
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
    	int start = 0;
    	int end = arr.length-1;
        while(start < end) {
        	int mid = getMidIndex(start, end);
        	if(arr[mid]>=arr[0]) {
        		// On first line (/), so changing start
        		start = mid+1;
        	}
        	else {
        		// On second line (/), so changing end and mid can be the starting point of 2nd line 
        		end = mid;
        	}
        	
        }
        return start;
    }
    
    private static int getMidIndex(int start, int end) {
    	return start + (end-start)/2; // To avoid error due to range
    }

    private static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
