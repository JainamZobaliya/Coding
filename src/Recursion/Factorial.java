package Recursion;

import java.io.*;

/**
 * Factorial
 * Problem Statement: To find factorial of a given number.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 5
 * 			Output: 120
 *		Test Case 2: 
 * 			Input: 4
 * 			Output: 24
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Factorial {
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
	    System.out.print("Factorial of "+ n +" is : ");  
	    // Find Factorial of N
	    int result = findFactorial(n);
	    // Printing the result
	    System.out.println(result);  
	    System.out.println("=================================="); 
	}
	
	private static int findFactorial(int n) {
		// Base Case
		if(n == 0)
			return 1;
		// Recursive Relation
		return n * findFactorial(n-1);
	}

}




