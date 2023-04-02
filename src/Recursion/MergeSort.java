package Recursion;

import java.io.*;

/**
 * MergeSort
 * Problem Statement: To sort the array in non-decreasing order using the Merge Sort algorithm. 
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
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */

public class MergeSort {
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
        // Sort the array using Merge Sort algorithm.
        mergeSort(arr, 0, arr.length-1);
        // Printing the output
        System.out.print("Array after Sort: ");  
        printArray(arr);
        System.out.println("=================================="); 
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left>=right)
        	return;
        int mid = getMidIndex(left,right);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
    	// Size of two sub-arrays to be merged
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
 
        // Creating two temp arrays 
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];
 
        // Copying data to temp arrays
        for (int i = 0; i < leftSize; ++i)
        	leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; ++j)
        	rightArr[j] = arr[mid + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
        // Initial index of merged sub-array array
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
 
        // Copying remaining elements of leftArr[], if any
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
 
        // Copying remaining elements of rightArr[], if any
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
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
