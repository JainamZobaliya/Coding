package Array;

import java.io.*;

/**
 * SwapAlternate
 * Problem Statement: To swap alternate elements in an array.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 4 5 6 
 * 			Output Array: 5 4 6
 *		Test Case 2: 
 * 			Input Array: 1 2 3 4
 * 			Output Array: 2 1 4 3
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SwapAlternate {
    static int testCaseSize, arrSize, arr[];

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
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***"); 
        // Take input for current test case
        takeInput();
        // Printing the array before performing operations
        System.out.println("Array elements before swapping: ");  
        printArray();
        // Swap Alternate Elements
        swapAlternateElements();
        // Printing the array after performing operations
        System.out.println("Array elements after swapping: ");  
        printArray();
        System.out.println("=================================="); 
    }

    public static void takeInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid array arrSize - input
        do{
            try{
                System.out.print("Enter arrSize of array: ");
                arrSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arrSize<=0); 
        // Instantiation array with the user input arrSize
        arr = new int[arrSize];
        System.out.print("Enter array elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing array with the user array input
        for(int i=0; i<arrInput.length; ++i)
            arr[i] = Integer.parseInt(arrInput[i]);
    }

    public static void swapAlternateElements() {
        // Loop until next element is less than array arrSize
        for(int i=0; i+1<arr.length; i+=2) {
            // Swapping Elements
            arr[i] = arr[i] + arr[i+1];
            arr[i+1] = arr[i] - arr[i+1];
            arr[i] = arr[i] - arr[i+1];
        }
    }

    public static void printArray() {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
