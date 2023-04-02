package CodeChef.Starters.Starters45;

import java.io.*;
import java.util.Arrays;
/**
 * EvenEqualOdd
 * Problem Statement: Min Moves to make Equal no. of odd and even terms
 * URL: https://www.codechef.com/submit/EVEQODD
 * 	Example:
 * 
 * 		Test Case 1: 
 * 			Input Array: 1 2 3 4 5 6
 * 			Output: 0
 *		Test Case 2: 
 * 			Input Array: 1 3 4 8 2 6
 * 			Output: 1
 *		Test Case 3: 
 * 			Input Array: 1 5 3 5 6 7
 * 			Output: 2
 */

/**
 * Time Complexity: O(N*log(max(Ai)))+O(N*logN)
 * Space Complexity: O(N) ... Storing moves of Even No.s to Odd in an array
 */

public class EvenEqualOdd {
	static int testCaseSize;
	static long data[][];

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
        data = new long[testCaseSize][];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            int arrSize = 2*Integer.parseInt(read.readLine());
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            data[i] = new long[arrSize];
            for(int j=0; j<arrSize; ++j)
            {
            	data[i][j] = Long.parseLong(arrInput[j]);
            }
        }
    }

    public static void runTestCase(int testCase) throws IOException  {
        // Get No. of Min. Operations required
    	int minOperations = getMinOperations(testCase);
        // Printing No. of Min. Operations required
        System.out.println(minOperations);
    }

    private static int getMinOperations(int testCase) {
    	int move = 0;
//    	Arrays.sort(data[testCase]);
    	int countEven = 0, countOdd = 0, firstEvenIndex = -1, firstOddIndex = -1;
        for(int i=0; i<data[testCase].length; ++i) {
        	if(data[testCase][i]%2 == 0) {
        		countEven++;
        		if(firstEvenIndex == -1)
        			firstEvenIndex = i;
        	}
        	else {
        		countOdd++;
        	}
        }
        if(countEven!=countOdd) {
        	if(countEven>countOdd) {
        		long[] evens = new long[countEven];
        		int k = 0;
        		for(int i=0; i<data[testCase].length; ++i) {
	            	if(data[testCase][i]%2 == 0) {
	            		int countMoves = 0;
	            		while(data[testCase][i]%2 != 1) {
	            			data[testCase][i] /= 2;
	            			countMoves++;
	            		}
	            		evens[k++] = countMoves;
	            	}
        		}
        		Arrays.sort(evens);
        		int i = 0;
        		while(countEven!=countOdd) {
        			move +=  evens[i];
        			--countEven;
        			++countOdd;
        			++i;
        		}
            }
            else {
            	// Odd To Even ===> Odd * 2 = Even so 1 move per Conversion so total Conversion is (Total Length - No. of Evens)
            	move = countOdd - (data[testCase].length/2);
            }
        }
        return move;
	}

	public static void printArray(long arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}
