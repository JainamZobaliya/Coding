package Array;

import java.io.*;

/**
 * FindUnique
 * Problem Statement: To find unique element from an array. 
 * URL: https://www.codingninjas.com/codestudio/problems/find-unique_625159
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 2 3 1 6 3 6 2
 * 			Output: 1
 *		Test Case 2: 
 * 			Input Array: 2 4 7 2 7
 * 			Output: 4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FindUnique {
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
        System.out.println("Array: ");  
        printArray();
        // Swap Alternate Elements
        int unique = findUniqueElement();
        // Printing the array after performing operations
        System.out.println("Unique Element in given array is: "+unique);
        System.out.println("=================================="); 
    }

    public static void takeInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid array arrSize - input and arrSize should be an odd number
        do{
            try{
                System.out.print("Enter arrSize of array: ");
                arrSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arrSize<=0 || arrSize%2==0); 
        // Instantiation array with the user input arrSize
        arr = new int[arrSize];
        System.out.print("Enter array elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing array with the user array input
        for(int i=0; i<arrSize; ++i)
            arr[i] = Integer.parseInt(arrInput[i]);
    }

    public static int findUniqueElement() {
        // Loop until next element is less than array arrSize
    	int unique = arr[0];
        for(int i=1; i<arr.length; i++) {
            // XOR of all array elements
        	unique = unique ^ arr[i];
        }
        return unique;
    }

    public static void printArray() {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
