package Recursion;

import java.io.*;

/**
 * QuickSort
 * Problem Statement: To sort the array in non-decreasing order using the Quick Sort algorithm. 
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
 * Space Complexity: O(n)
 */

public class QuickSort {
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
        // Sort the array using Quick Sort algorithm.
        quickSort(arr, 0, arr.length-1);
        // Printing the output
        System.out.print("Array after Sort: ");  
        printArray(arr);
        System.out.println("=================================="); 
    }

    private static void quickSort(int[] arr, int low, int high) {
    	if(low>=high)
    		return;
        // pi is partitioning index, arr[p] is now at right place 
        int pi = partition(arr, low, high);
        // Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
    
    private static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high]; 
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1); 
      
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot) 
            {
                i++; // Increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
