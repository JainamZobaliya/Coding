package CodeChef.Starters.Starters45;

import java.io.*;
import java.util.Arrays;
/**
 * MultiplyXors
 * Problem Statement: To get X such that [(A^X) * (B^X)] is maximum
 * URL: https://www.codechef.com/submit/XORMUL
 * 	Example:
 * 
 * 		Test Case 1: 
 * 			Input Array: 1 0 0
 * 			Output: 1
 *		Test Case 2: 
 * 			Input Array: 3 4 6
 * 			Output: 3
 *		Test Case 3: 
 * 			Input Array: 2 2 1
 * 			Output: 0
 */

/**
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */

public class MultiplyXors {
	static int testCaseSize, data[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(i);
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
        data = new int[testCaseSize][3];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            for(int j=0; j<3; ++j)
            {
            	data[i][j] = Integer.parseInt(arrInput[j]);
            }
        }
    }

    public static void runTestCase(int testCase) throws IOException  {
        // Get X such that [(A^X) * (B^X)] is maximum
    	int x = getX(data[testCase][0], data[testCase][1], data[testCase][2]);
        // Printing value of X
        System.out.println(x);
    }

    private static int getX(int n, int a, int b) {
    	int x = 0, count = 0;
		for(int i=n-1; i>=0; --i) {
			int bitA = ((1<<i) & a);
			int bitB = ((1<<i) & b);
			int decimalEquilvalent = (1<<i);
			System.out.println("\tde: "+decimalEquilvalent);
			if(bitA == bitB) {
				System.out.println("\tSame: "+bitA);
				if(bitA == 0)
					x += decimalEquilvalent;
			}
			else if(count == 0) {
				System.out.println("\tbitB: "+bitB);
				if(bitB == 1)
					x += decimalEquilvalent;
				++count;
			}
			else {
				System.out.println("\tbitA: "+bitA);
				if(bitA == 1)
					x += decimalEquilvalent;
			}
			System.out.println("\tAns: "+x);
		}
        return x;
	}

	public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}
