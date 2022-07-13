package SearchingAndSorting;

import java.io.*;

/**
 * SearchInRotatedSortedArray
 * Problem Statement: To find the index at which ‘Key’ is present in array.
 * URL: https://www.codingninjas.com/codestudio/problems/search-in-rotated-sorted-array_1082554
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 8 9 4 5
 * 			Input Key: 2 
 * 			Output: -1
 *		Test Case 2: 
 * 			Input Array: 2 4 5 6 8 9 1
 * 			Input Key: 2 
 * 			Output: 0
 *		Test Case 3: 
 * 			Input Array: 2 3 5 8
 * 			Input Key: 3
 * 			Output: 1
 *		Test Case 3: 
 * 			Input Array: 5
 * 			Input Key: 5 
 * 			Output: 0
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class SearchInRotatedSortedArray {
    static int testCaseSize, arr[][], key[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(arr[i], key[i]);
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
        key = new int[testCaseSize];
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
            System.out.print("Enter the key to be searched: ");
            key[i] = Integer.parseInt(read.readLine());
	    }
    }

    private static void runTestCase(int[] arr, int key) throws IOException  {
        // Printing the array
        System.out.print("Array: ");  
        printArray(arr);
        // find index of key
        int index = searchKey(arr, key);
        // Printing the output
        System.out.println("Index of Key-"+key+" is: "+index);
        System.out.println("=================================="); 
    }

    private static int binarySearch(int[] arr, int searchKey, int start, int end) {
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
    		if(arr[mid] == searchKey) // element at mid index is the searchKey
    			return mid;
    		else if(arr[mid]>searchKey) // searchKey might be in left part // for descending order change sign
    			end = mid-1;
    		else // searchKey might be in right part
    			start = mid+1;
    	}
        return -1;
    }
    
    private static int searchKey(int[] arr, int key) {
    	// Apply BinarySearch on 1st line or 2nd line, based on where the key lies.
    	int pivotIndex = findPivotIndex(arr);
    	if(key >= arr[pivotIndex] && key <= arr[arr.length-1]) {
    		// On 2nd line (/) or not on line
    		return binarySearch(arr, key, pivotIndex, arr.length-1);
    	}
		// On 1st line (/) or not on line
		return binarySearch(arr, key, 0, pivotIndex-1);    	
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
