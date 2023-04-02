package CodeChef.Starters.Starters46;

import java.io.*;
import java.util.Arrays;
/**
 * VowelAnxiety
 * Problem Statement: To print the final string after performing all the operations.
 * URL: https://www.codechef.com/START46D/problems/VOWANX
 * 	Example:
 * 		Test Case 1: 
 * 			Input String: abcdefghij
 * 			Output: hgfeabcdij
 *		Test Case 2: 
 * 			Input String: bcadage
 * 			Output: gacbade
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class VowelAnxiety {
	static int testCaseSize, arrSize[];
	static StringBuilder arr[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i]);
    }

    private static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
            	// System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        arrSize = new int[testCaseSize]; 
        arr = new StringBuilder[testCaseSize];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            arrSize[i] = Integer.parseInt(read.readLine()); 
            // Initializing StringBuilder with the user String input
        	arr[i] = new StringBuilder(read.readLine()); // S
        }
    }

    public static void runTestCase(StringBuilder str) throws IOException  {
        // find reverse String
    	String result = reverseString(str);
        // Printing the result
        System.out.println(result);
    }
    
    public static String reverseString(StringBuilder str) {
    	String result = "";
    	for(int i=1; i<str.length(); ++i) {
    		if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || 
    				str.charAt(i) == '0' || str.charAt(i) == 'u') {
    			StringBuilder strToRev = new StringBuilder(str.substring(0, i));
    			strToRev = strToRev.reverse();
    			str = str.replace(0, i, strToRev.toString());
    		}
    	}
    	result = str.toString();
    	return result;    	
    }
    
    public static boolean inspect(int num, int count) {
    	boolean result = false;
    	double personPerGrp = (double) num / count;
		if(Math.ceil(personPerGrp) == 1.0 && Math.floor(personPerGrp) == 1.0) {
			result = true;
			count = 1;
		}
		else {
			result = false;
		}
		return result;
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}

