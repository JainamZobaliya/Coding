package Recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * PowerSet
 * Problem Statement: To return power set of the given array.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 3
 * 			Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *		Test Case 2: 
 * 			Input Array: 1 2
 * 			Output: [[],[1],[2],[1,2]]
 *		Test Case 3: 
 * 			Input Array: 1
 * 			Output: [[],[1]]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class PowerSet {
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
            int arrSize = -1;
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
        // Finding Power Set of the given array
        ArrayList<ArrayList<Integer>> result = getSubset(arr, arr.length-1);
        // Printing the result
    	printResult(result);
        System.out.println("=================================="); 
    }
    
    private static ArrayList<ArrayList<Integer> > getSubset(int[] set, int index) {
        ArrayList<ArrayList<Integer> > result;
        if (index < 0) {
        	result = new ArrayList<ArrayList<Integer> >();
        	result.add(new ArrayList<Integer>()); // Adding the Empty subset
            return result;
        }
    	// Recursive Relation
    	// Exclude the Current Element
        // System.out.println("\tExcluding Index-"+index);
    	result = getSubset(set, index - 1);
    	// Include the Current Element
        // System.out.println("\tIncluding Index-"+index);
        int element = set[index];
        ArrayList<ArrayList<Integer> > moreSubsets = new ArrayList<ArrayList<Integer> >();
        for (ArrayList<Integer> subset : result) {
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.addAll(subset);
            // System.out.print("\t\tAdding element of index-"+index+" to ");
            // printArrayList(subset);
            // System.out.println();
            newSubset.add(element);
            moreSubsets.add(newSubset);
            // System.out.print("\t\t\t");
            // printArrayList(newSubset);
            // System.out.println(" is added to the result");
        }
        result.addAll(moreSubsets);
        return result;
    }
    
    private static void printResult(ArrayList<ArrayList<Integer>> result) {
    	System.out.println("Power Set Size: "+result.size());
        System.out.println("Power Set of Above Array is: ");
        System.out.print("[");   
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
        	ArrayList<Integer> curr = (ArrayList<Integer>) iterator.next();
    		printArrayList(curr);
    		System.out.print(iterator.hasNext() ? ", " : "");
		}
        System.out.println("]"); 
    }

    private static void printArrayList(ArrayList<Integer> arr) {
        System.out.print("[");   
        // Traversing the ArrayList  
        for(int i=0; i<arr.size(); ++i) {
    		System.out.print(arr.get(i));
    		System.out.print(i+1 != arr.size() ? ", " : "");  
        }
        System.out.print("]");
    }

    private static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
