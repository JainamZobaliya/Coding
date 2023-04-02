
package Recursion;

import java.io.*;
import java.util.ArrayList;

/**
 * StringPermutation
 * Problem Statement: To return all possible permutations of the given String
 * URL: https://leetcode.com/problems/permutations/submissions/
 * 	Example:
 * 		Test Case 1: 
 * 			Input: abc
 * 			Output: [abc, acb, bac, bca, cab, cba]
 *		Test Case 2: 
 * 			Input Array: ""
 * 			Output: []
 *		Test Case 3: 
 * 			Input Array: ab
 * 			Output: [ab,ba]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class StringPermutation {
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
        System.out.print("Following are the Permutations of String \'"+str+"\': ");
        // Finding all Permutations of the given String
        ArrayList<String> result = new ArrayList<String>();
        result = getStringPermutation(str, 0, result);
        // Printing the result
		printArrayList(result);
        System.out.println("=================================="); 
    }
    
    private static ArrayList<String> getStringPermutation(String str, int index, ArrayList<String> result) {
	    // base case
    	if(index >= str.length()) {
    		result.add(str);
    		return result;
    	}
    	for(int i=index; i<str.length(); ++i) {
    		str = swap(str, index, i);
    		result = getStringPermutation(str, index+1, result);
    		//backtrack
    		str = swap(str, index, i);
    	}
	    return result;
	}
    
    private static String swap(String str, int i, int j) {
    	StringBuilder newString = new StringBuilder(str);
    	newString.setCharAt(i,str.charAt(j));
    	newString.setCharAt(j,str.charAt(i));
    	return newString.toString();    	
    }

    private static void printArrayList(ArrayList<String> arr) {
        System.out.print("[");   
        // Traversing the ArrayList  
        for(int i=0; i<arr.size(); ++i) {
    		System.out.print(arr.get(i).isEmpty() ? "\"\"" :  arr.get(i));
    		System.out.print(i+1 != arr.size() ? ", " : "");  
        }
        System.out.println("]");
    }

    private static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
