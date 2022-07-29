package Recursion;

import java.io.*;

/**
 * FibonacciSeries
 * Problem Statement: To print N'th term of Fibonacci Series.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 5
 * 			Output: 5
 *		Test Case 2: 
 * 			Input: 4
 * 			Output: 3
 */

/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)) if we consider the function call stack size, otherwise O(1).
 */

public class FibonacciSeries {
	static int testCaseSize, arr[];

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
	    arr = new int[testCaseSize];
	    for(int i=0; i<testCaseSize; ++i){
	    	// Number - input
            System.out.print("Enter the Number: ");
            arr[i] = Integer.parseInt(read.readLine());
		}
	}
	
	public static void runTestCase(int n) throws IOException  {
	    System.out.print(n +" terms of Fibonacci Series are: ");  
	    // Find N terms of Fibonacci Series
	    String result = fibonnaciSeries(n);
    	// Printing the result
    	System.out.println(result);  
	    System.out.println("=================================="); 
	}
	
	
	private static String fibonnaciSeries(int n) {
		StringBuilder resultStr = new StringBuilder("");
	    while(n>0) {
	    	int result = findFibonnaci(n--);
	    	resultStr = new StringBuilder(result+"").append(" ").append(resultStr);
	    }
		return resultStr.toString();
	}
	
	
	private static int findFibonnaci(int n) {
		// Base Case
		if(n == 0)
			return 0;
		else if(n==1)
			return 1;
		// Recursive Relation
		int sum = findFibonnaci(n-2) + findFibonnaci(n-1);
		return sum;
	}
}




