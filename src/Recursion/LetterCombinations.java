package Recursion;

import java.io.*;
import java.util.ArrayList;

/**
 * LetterCombinations
 * Problem Statement: To return all possible letter combinations that the number could represent.
 * URL: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 	Example:
 * 		Test Case 1: 
 * 			Input: "23"
 * 			Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *		Test Case 2: 
 * 			Input Array: ""
 * 			Output: [""]
 *		Test Case 3: 
 * 			Input Array: "2"
 * 			Output: ["a","b","c"]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LetterCombinations {
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
        // Finding all possible Letter Combinations
        ArrayList<String> result = new ArrayList<String>();
        result = getletterCombinations(str, 0, "", result);
        // Printing the result
		printArrayList(result);
        System.out.println("=================================="); 
    }
    
    private static ArrayList<String> getletterCombinations(String str, int index, String output, ArrayList<String> result) {
	    // base case
    	if(index >= str.length()) {
            if(output != "")
    		    result.add(output);
    		return result;
    	}
	    String currentNumber = String.valueOf(str.charAt(index));
	    String[] currentLetter = getPossibleLetters(currentNumber);
	    for(int i=0; i<currentLetter.length; ++i) {
	    	//Recursive Relation
	    	result = getletterCombinations(str, index+1, output+currentLetter[i], result);
	    }
	    return result;
	}
    
    private static String[] getPossibleLetters (String number) {
    	switch(number) {
	    	case "2": {
	    		String[] numPad = {"a", "b", "c"};
	    		return numPad;
	    	}
			case "3": {
	    		String[] numPad = {"d", "e", "f"};
	    		return numPad;
	    	}
			case "4": {
	    		String[] numPad = {"g", "h", "i"};
	    		return numPad;
	    	}
			case "5": {
	    		String[] numPad = {"j", "k", "l"};
	    		return numPad;
	    	}
			case "6": {
	    		String[] numPad = {"m", "n", "o"};
	    		return numPad;
	    	}
			case "7": {
	    		String[] numPad = {"p", "q", "r", "s"};
	    		return numPad;
	    	}
			case "8": {
	    		String[] numPad = {"t", "u", "v"};
	    		return numPad;
	    	}
			case "9": {
	    		String[] numPad = {"w", "x", "y", "z"};
	    		return numPad;
	    	}
			default: {
	    		String[] numPad = {""};
	    		return numPad;
			}
    	}
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
