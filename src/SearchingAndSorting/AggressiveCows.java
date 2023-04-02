package SearchingAndSorting;

import java.io.*;
import java.util.Arrays;

/**
 * AggressiveCows
 * Problem Statement: To return largest min. distance such that the min. distance between any 2 of the stall
 * is as large as possible. 
 * URL: https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 3
 * 			Input k: 2
 * 			Output: 2
 *		Test Case 2: 
 * 			Input Array: 4 2 1 3 6
 * 			Input k: 2
 * 			Output: 5
 *		Test Case 3: 
 * 			Input Array: 0 3 4 7 10 9
 * 			Input k: 4
 * 			Output: 3
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class AggressiveCows {
    static int testCaseSize, stalls[][], k[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(stalls[i], k[i]);
        }
    }

    private static void takeTestCaseInput() throws IOException  {
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
        // Take input for current test case
        stalls = new int[testCaseSize][];
        k = new int[testCaseSize];
        for(int i=0; i<testCaseSize; ++i) {
        	int noOfStalls = -1;
            System.out.print("Enter no. of stalls: ");
            noOfStalls = Integer.parseInt(read.readLine());
            System.out.print("Enter no. of cows: ");
            k[i] = Integer.parseInt(read.readLine());
	        // Instantiation array with the user input arrSize
            stalls[i] = new int[noOfStalls];
	        System.out.print("Enter the position of stalls (space separated): ");
	        String[] positions = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<noOfStalls; ++j)
	        	stalls[i][j] = Integer.parseInt(positions[j]);
	    }
    }

    private static void runTestCase(int[] position, int k) throws IOException  {
        // Printing the array
        System.out.println("Array: "+ Arrays.toString(position));  
        // Binary Search
        int maxDistance = allocateCows(position, k);
        // Printing the output
        System.out.println("Output: " + maxDistance);
        System.out.println("=================================="); 
    }

    private static int allocateCows(int[] position, int k) {
    	Arrays.sort(position);
		int start = 0, end = position[position.length-1];
    	int maxDistance = -1;
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
        	if(isMidPossible(position, k, mid)) {
        		maxDistance = mid;
        		start = mid + 1; // as right of mid are all answers but not min. value
        	} 
        	else { // as current mid is not possible so all values left to it would also be not possible
        		end = mid - 1; 
        	}
    	}
		return maxDistance;
    }

    private static boolean isMidPossible(int[] position, int k, int mid) {
    	int lastPos = position[0];
    	int cowCount = 0;
    	for(int i = 0; i < position.length; i++) {
    		if(position[i] - lastPos >= mid) {
    			cowCount++;
    			lastPos = position[i];
    			if(cowCount == k-1) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    private static int getMidIndex(int start, int end) {
    	return start + (end-start)/2; // To avoid error due to range
    }
    
}
