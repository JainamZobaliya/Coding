package Recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * SubSequences
 * Problem Statement: To return Sub-Sequences of the given String.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: abc
 * 			Output: ["", "a", "b", "c", "ab", "ac", "bc", "abc"]
 *		Test Case 2: 
 * 			Input: ab
 * 			Output: ["", "a", "b", "c", "ab"]
 *		Test Case 3: 
 * 			Input: a
 * 			Output: ["", "a"]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SubSequences {
    static int testCaseSize;
    static String arr[];

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
        arr = new String[testCaseSize];
        for(int i=0; i<testCaseSize; ++i) {
	        System.out.print("Enter the String: ");
	        // Initializing array with the user string input
	        arr[i] = read.readLine();
	    }
    }

    private static void runTestCase(String str) throws IOException  {
        // Printing the array
        System.out.print("Following are the Subsequences of String \'"+str+"\': ");
        // Finding Power Set of the given array
        String curr = "";
        ArrayList<String> result = new ArrayList<String>();
        getSubSequence(str, 0, curr, result);
        // Printing the result
		printArrayList(result);
        System.out.println("\n=================================="); 
    }
    
    private static void getSubSequence(String str, int index, String curr, ArrayList<String> result) {
	    // base case
	    if (index >= str.length()) {
	    	// System.out.println("Adding - "+curr);
	        result.add(curr);
	        return;
	    }
	    // Recursive Relation
	    // Excluding the current element
	    getSubSequence(str, index + 1, curr, result);
	    // Including the current element
	    getSubSequence(str, index + 1, curr + str.charAt(index), result);
	 
	}

    private static void printArrayList(ArrayList<String> arr) {
        System.out.print("[");   
        // Traversing the ArrayList  
        for(int i=0; i<arr.size(); ++i) {
    		System.out.print(arr.get(i).isEmpty() ? "\"\"" :  arr.get(i));
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
