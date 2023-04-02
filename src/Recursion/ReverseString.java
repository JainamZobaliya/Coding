package Recursion;

import java.io.*;

/**
 * ReverseString
 * Problem Statement: To return reverse of given string.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: abcde
 * 			Output: edcba
 *		Test Case 2: 
 * 			Input: prog
 * 			Output: gorp
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReverseString {
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
	    System.out.print("Reverse of "+str+" is: ");  
	    // Find Reverse of string
	    String result = reverseString(str.toCharArray(),0,str.length()-1);
	    // Printing the result
	    System.out.println(result);  
	    System.out.println("=================================="); 
	}
	
	private static String reverseString2(String str, int start, int end) {
		// Base Case
		if(start>=end)
			return str;
		//Processing Part
		String startPartAsItsIs = str.substring(0, start);
		String startPart = str.substring(start, start+1); // To Swap
		String middlePart = str.substring(start+1, end);
		String endPart = str.substring(end, end+1); // To Swap
		String endPartAsItIs = str.substring(end+1, str.length());
		String newStr = startPartAsItsIs+endPart+middlePart+startPart+endPartAsItIs;
		// Recursive Relation
		return reverseString2(newStr, start+1, end-1);
	}
	
	private static String reverseString(char[] str, int start, int end) {
		// Base Case
		if(start>=end)
			return new String(str);
		//Processing Part
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;
		// Recursive Relation
		return reverseString(str, start+1, end-1);
	}

}




