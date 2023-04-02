package CodeChef.Starters.Starters45;

import java.io.*;
/**
 * AdjacenSumParity
 * Problem Statement: To check whether valid array A exists or not.
 * URL: https://www.codechef.com/submit/ADJSUMPAR
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 0 0
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 1 0
 * 			Output: NO
 *		Test Case 3: 
 * 			Input Array: 1 0 1 0
 * 			Output: YES
 *		Test Case 4: 
 * 			Input Array: 1 0 0
 * 			Output: NO
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class AdjacentSumParity {
	static int testCaseSize, arrSize[], binaryData[][];

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
        arrSize = new int[testCaseSize];
        binaryData = new int[testCaseSize][];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
        	arrSize[i] = Integer.parseInt(read.readLine());
            binaryData[i] = new int[arrSize[i]];
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            for(int j=0; j<arrSize[i]; ++j)
            	binaryData[i][j] = Integer.parseInt(arrInput[j]); 
        }
    }

    public static void runTestCase(int testCase) throws IOException  {
        // Checking whether valid A exists or not
    	Boolean existsOrNot = checkForA(binaryData[testCase]);
        // Printing the result
        System.out.println(existsOrNot ? "Yes" : "No");
    }

    private static Boolean checkForA(int[] arrB) {
    	Boolean result = false;
		int assumeA = 0;
		int count = 0;
		do {
			int nextA = assumeA; // Assuming A[0] = 0
	    	for(int i=0;i<arrB.length; ++i) {
	    		// if A[i] and B[i] are odd or if both are even, then A[i+1] even else A[i+1] is odd
				if((arrB[i] == 0 && nextA == 0) || (arrB[i] == 1 && nextA == 1))
					nextA = 0;
				else if((arrB[i] == 1 && nextA == 0) || (arrB[i] == 0 && nextA == 1))
					nextA = 1;
	    	}
	    	++count;
	    	// if A[0] same as Assumed-A[0], then array A exists
	    	if(nextA == assumeA) {
	    		result = true;
	    		break;
	    	}
	    	else { // Now changing Assumption i.e. A[0] = 1
	    		assumeA = 1;
	    	}
		} while(count == 2); // if our assumption doesn't matches, then Array-A doesnt exits
        return result;
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}
