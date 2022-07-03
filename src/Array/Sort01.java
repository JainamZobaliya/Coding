package Array;

import java.io.*;
import java.util.Arrays;

/**
 * Sort01
 * Problem Statement: To sort an array containing only 0 1.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 0 0 1
 * 			Output Array: 0 0 1 1
 *		Test Case 2: 
 * 			Input Array: 0 1 1 0 0 0 1 1
 * 			Output Array: 0 0 0 0 1 1 1 1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Sort01 {
    static int testCaseSize, arrSize[], arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(i);
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
        // Instantiation array with the user input testCaseSize
        arrSize = new int[testCaseSize];
        arr = new int[testCaseSize][];
        for(int i=0; i<testCaseSize; ++i) {
            // take ith test Case Input
        	takeInput(i);
        }
    }

    public static void takeInput(int testCaseNum) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid array arrSize - input
        do{
            try{
                System.out.print("Enter arrSize of array: ");
                arrSize[testCaseNum] = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arrSize[testCaseNum]<=0); 
        System.out.print("Enter array elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing array with the user array input
        arr[testCaseNum] = new int[arrSize[testCaseNum]];
        for(int i=0; i<arrSize[testCaseNum]; ++i)
            arr[testCaseNum][i] = Integer.parseInt(arrInput[i]);
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***");
        // Printing the array before performing operations
        System.out.print("Array: ");  
        printArray(arr[caseNum]);
        // Sort 0 1
        sortArray01(arr[caseNum]);
        // Printing the sorted array
        System.out.print("Sorted Array: ");  
        printArray(arr[caseNum]);
        System.out.println("=================================="); 
    }

    public static void sortArray01(int[] arr) {
//    	// Approach-1: Using 2 loops ==> TC: O(N), SC: O(1)
//    	int count0 = 0, count1 = 0;
//    	// Counting 0's and 1's in array
//    	for(int i=0; i<arr.length; ++i) {
//    		count0 = arr[i] == 0 ? ++count0 : count0;
//    		count1 = arr[i] == 1 ? ++count1 : count1;
//    	}
//    	// Re-assigning value as per the counts
//    	for(int i=0; i<count0; ++i) {
//    		 arr[i] = 0;
//    	}
//    	for(int i=count0; (i-count0)<count1; ++i) {
//   		 arr[i] = 1;
//    	}
//    	// Approach-2: Using Arrays.sort() ==> TC: O(NlogN), SC: O(1)
//    	Arrays.sort(arr);
    	// Approach-3: Using 2 Pointer ==> TC: O(N), SC: O(1)
    	int left = 0, right = arr.length - 1;
    	while(left<right) {
    		// Increment left till 0 is found
    		while(arr[left]==0)
    			++left;
    		// Decrement right till 1 is found
    		while(arr[right]==1)
    			--right;
    		// Swap 0's and 1's 
    		if(left<right) {
    			swapArrayElement(arr, left, right);
    			++left;
    			--right;
    		}
    	}
    }

    public static void swapArrayElement(int[] arr, int i, int j) {
        // Swapping Elements
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
