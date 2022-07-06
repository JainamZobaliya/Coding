package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * FindUniqueOccurrences
 * Problem Statement: To return an array of all the integers that appears twice. 
 * URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 4,3,2,7,8,2,3,1
 * 			Output Array: 2,3
 *		Test Case 2: 
 * 			Input Array: 1,1,2
 * 			Output Array: 1
 *		Test Case 3: 
 * 			Input Array: 1
 * 			Output Array: [] ... empty array
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FindAllDuplicates {
    static int testCaseSize, arrSize[], arr[][], soln[][];

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
        // Take input for current test case
        // Taking a valid array arrSize - input and arrSize should be an odd number
        arrSize = new int[testCaseSize];
        arr = new int[testCaseSize][];
        soln = new int[testCaseSize][];
        for(int i=0; i<testCaseSize; ++i) {
	        do{
	            try{
	                System.out.print("Enter arrSize of array: ");
	                arrSize[i] = Integer.parseInt(read.readLine());
	            } catch (Exception err) {
	                System.out.println("Error: " + err);
	            }
	        } while(arrSize[i]<=0); 
	        // Instantiation array with the user input arrSize
	        arr[i] = new int[arrSize[i]];
	        System.out.print("Enter array elements(space separated): ");
	        String[] arrInput = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<arrSize[i]; ++j)
	            arr[i][j] = Integer.parseInt(arrInput[j]);
	    }
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***"); 
        // Printing the array
        System.out.println("Array: ");  
        printArray(arr[caseNum]);
        // Finding Duplicate Elements
        soln[caseNum] = findDuplicates(arr[caseNum]);
        // Printing the output
        System.out.println("Following are duplicate elements in given array: ");
        printArray(soln[caseNum]);
        System.out.println("=================================="); 
    }

    public static int[] findDuplicates(int[] arr) {
    	ArrayList<Integer> duplicates = new ArrayList<Integer>();
    	for(int i=0; i<arr.length;++i) {
    		int index = Math.abs(arr[i])-1;
    		if(arr[index]<0)
    			duplicates.add(Math.abs(arr[i]));
    		else
    			arr[index] = -arr[index];
    	}
    	int[] duplicatesArr = new int[duplicates.size()];
    	Iterator<Integer> itr = duplicates.iterator();
    	int i = 0;
    	while(itr.hasNext()) {
    		duplicatesArr[i++] = (int) itr.next();
    	}
        return duplicatesArr;
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
