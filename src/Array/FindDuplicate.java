package Array;

import java.io.*;

/**
 * FindDuplicate
 * Problem Statement: To find duplicate element from an array.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 3 2 
 * 			Output: 2
 *		Test Case 2: 
 * 			Input Array: 8 7 6 5 7 4 3 2 1
 * 			Output: 7
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FindDuplicate {
    static int testCaseSize, arrSize[], arr[][], duplicateElement[];

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
        duplicateElement = new int[testCaseSize];
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
        for(int i=0; i<arrInput.length; ++i)
            arr[testCaseNum][i] = Integer.parseInt(arrInput[i]);
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***");
        // Printing the array before performing operations
        System.out.print("Array: ");  
        printArray(arr[caseNum]);
        // Find Duplicate Element
        duplicateElement[caseNum] = getDuplicateElement(arr[caseNum]);
        // Printing the result
        System.out.println("Duplicate Element is: " + duplicateElement[caseNum]);
        System.out.println("=================================="); 
    }

    public static int getDuplicateElement(int[] arr) {
    	// Approach-1: Using XOR ==> TC: O(N), SC: O(1)
    	int duplicateElement = 0;
    	for(int i=0; i<arr.length; ++i) {
    		duplicateElement = duplicateElement ^ arr[i];
    	}
    	for(int i=1; i<arr.length; ++i) {
    		duplicateElement = duplicateElement ^ i;
    	}
    	return duplicateElement;
    	// Approach-2: Using SUM ==> TC: O(N), SC: O(1)
//    	int sum = arr.length * (arr.length-1) / 2; // Sum of N Natural Numbers: N*(N+1) / 2
//    	for(int i=0; i<arr.length; ++i) {
//    		sum = sum - arr[i];
//    	}
//    	return sum*-1;
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
