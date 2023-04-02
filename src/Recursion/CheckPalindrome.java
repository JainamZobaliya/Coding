package Recursion;

import java.io.*;

/**
 * CheckPalindrome
 * Problem Statement: To check given string is palindrome or not.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: abcde
 * 			Output: NO
 *		Test Case 2: 
 * 			Input: mom
 * 			Output: YES
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CheckPalindrome {
	static int testCaseSize;
	static String arr[];

	public static void main(String[] args) throws IOException  {
	    takeTestCaseInput();
	    for(int i=0; i<testCaseSize; ++i)
	    	runTestCase(arr[i]);
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
	    arr = new String[testCaseSize];
	    for(int i=0; i<testCaseSize; ++i){
	    	// Number - input
            System.out.print("Enter the String: ");
            arr[i] = read.readLine();
		}
	}
	
	public static void runTestCase(String str) throws IOException  {
	    System.out.print("Is  String-"+str+", a Palindrome?: ");  
	    // Find Reverse of string
	    String result = checkStr(str.toCharArray(),0,str.length()-1) ? "YES" : "NO";
	    // Printing the result
	    System.out.println(result);  
	    System.out.println("=================================="); 
	}
	
	private static Boolean checkStr(char[] str, int start, int end) {
		// Base Case
		if(start>=end)
			return true;
		//Processing Part
		if(str[start] != str[end])
			return false;
		// Recursive Relation
		return checkStr(str, start+1, end-1);
	}

}




