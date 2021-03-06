package SearchingAndSorting;

import java.io.*;

/**
 * FirstAndLastOccurrence
 * Problem Statement: To return the first and last occurrence of an element from the array. 
 * URL: https://www.codingninjas.com/codestudio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 0 5 5 6 6 6
 * 			Input Key: 3
 * 			Output Array: -1 -1 ... Not Present in the array
 *		Test Case 2: 
 * 			Input Array: 0 0 1 1 2 2 2 2
 * 			Input Key: 2
 * 			Output Array: 4 7
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class FirstAndLastOccurrence {
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
	        System.out.print("Enter sorted array elements(space separated and in ascending order): ");
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
        // search first occurrence of key using Binary Search
        int firstIndex = firstOccurrence(arr, key);
        // search last occurrence of key using Binary Search
        int lastIndex = lastOccurrence(arr, key);
        // Printing the output
        System.out.println("Search Key: "+key+"\nOutput: "+firstIndex+" "+lastIndex);
        int totalOccurrence = firstIndex == -1 ? 0 : (lastIndex-firstIndex+1);
        System.out.println("Total Occurrence of "+key+" in array: "+totalOccurrence);
        System.out.println("=================================="); 
    }

    private static int firstOccurrence(int[] arr, int searchKey) {
    	int start = 0, end = arr.length-1;
    	int index = -1;
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
    		if(arr[mid] == searchKey) { // element at mid index is the searchKey
    			index = mid;
    			end = mid - 1; // To search in the leftPart for other occurrences, if any
    		}
    		else if(arr[mid]>searchKey) // searchKey might be in left part
    			end = mid-1;
    		else // searchKey might be in right part
    			start = mid+1;
    	}
        return index;
    }

    private static int lastOccurrence(int[] arr, int searchKey) {
    	int start = 0, end = arr.length-1;
    	int index = -1;
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
    		if(arr[mid] == searchKey) { // element at mid index is the searchKey
    			index = mid;
    			start = mid + 1; // To search in the rightPart for other occurrences, if any
    		}
    		else if(arr[mid]>searchKey) // searchKey might be in left part
    			end = mid-1;
    		else // searchKey might be in right part
    			start = mid+1;
    	}
        return index;
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
