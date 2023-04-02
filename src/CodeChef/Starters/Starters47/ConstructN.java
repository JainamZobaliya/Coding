package CodeChef.Starters.Starters47;

import java.io.*;
/**
 * ConstructN
 * Problem Statement: To find if it is possible to represent N as the sum of several(possibly zero) 2's 
 * and several(possibly zero) 7's.
 * URL: https://www.codechef.com/START47D/problems/CONN
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 2
 * 			Output: YES
 *		Test Case 2: 
 * 			Input: 5
 * 			Output: NO
 *		Test Case 3: 
 * 			Input: 7
 * 			Output: YES
 *		Test Case 4: 
 * 			Input: 11
 * 			Output: YES
 */

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class ConstructN {
	static int testCaseSize, arr[] ;

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
        arr = new int[testCaseSize];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            // Initializing array with the user array input
        	arr[i] = Integer.parseInt(read.readLine()); // N
        }
    }

    public static void runTestCase(int n) throws IOException  {
        // Calculate x and y in 2x+7y = N
    	double x = n % 2 ;
    	double y = n % 7 ;
    	
        if( x==0 || y==0) {
        	System.out.println("YES");
        	return;
        }
        int num = n;
        while(num>0) {
        	num = num - 7;
        	if(num>0) {
	        	x = num % 2;
	        	if(x==0) {
	            	System.out.println("YES");
	            	return;
            }    
        	}
        }
        num = n;
        while(num>0) {
        	num = num - 2;
        	if(num>0) {
	        	y = num % 7;
	        	if(y==0) {
	            	System.out.println("YES");
	            	return;
	            }  
        	}
        }
    	System.out.println("NO");
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}

