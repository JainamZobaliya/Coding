package Recursion;

import java.io.*;

/**
 * Power
 * Problem Statement: To find a Power of a b.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 5 5
 * 			Output: 3125
 *		Test Case 2: 
 * 			Input: 6 * 8
 * 			Output: 1679616
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */

public class Power {
	static int testCaseSize, arr[][];

	public static void main(String[] args) throws IOException  {
	    takeTestCaseInput();
	    for(int i=0; i<testCaseSize; ++i)
	    	runTestCase(arr[i][0], arr[i][1]);
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
	    arr = new int[testCaseSize][2];
	    for(int i=0; i<testCaseSize; ++i){
	    	// Number - input
	        System.out.print("Enter base and power(space separated): ");
	        String[] arrInput = read.readLine().split("\s");
            arr[i][0] = Integer.parseInt(arrInput[0]); // a
            arr[i][1] = Integer.parseInt(arrInput[1]); // b
		}
	}
	
	public static void runTestCase(int base, int power) throws IOException  {
	    System.out.print(base+" ^ "+ power +" is : ");  
	    // Calculate base Power of power (base ^ power)
	    Long result = calculatePower(base, power);
	    // Printing the result
	    System.out.println(result);  
	    System.out.println("=================================="); 
	}
	
	private static Long calculatePower(int base, int power) {
		// Base Case
		if(power == 0)
			return (long) 1;
		// Recursive Relation
		Long currentAns = calculatePower(base, power/2);
		// For Odd Power it is base * base^(power/2) * base^(power/2)
		// For Even Power it is base^(power/2) * base^(power/2)
		return power%2 == 0 ? (currentAns*currentAns) : (base * currentAns * currentAns);
	}

}




