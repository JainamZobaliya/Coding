package SearchingAndSorting;

import java.io.*;
import java.util.Arrays;

/**
 * PaintersPartition
 * Problem Statement: To return the area of the min. time to paint all the 'n' the board by 'k' painters. 
 * URL: https://www.codingninjas.com/codestudio/problems/painter's-partition-problem_1089557
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 5 5 5 5
 * 			Input k: 2
 * 			Output: 10
 *		Test Case 2: 
 * 			Input Array: 10 20 30 40
 * 			Input k: 2
 * 			Output: 60
 *		Test Case 3: 
 * 			Input Array: 48 90
 * 			Input k: 2
 * 			Output: 90
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class PaintersPartition {
    static int testCaseSize, boards[][], k[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(boards[i], k[i]);
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
        boards = new int[testCaseSize][];
        k = new int[testCaseSize];
        for(int i=0; i<testCaseSize; ++i) {
        	int noOfBoards = -1;
            System.out.print("Enter no. of boards: ");
            noOfBoards = Integer.parseInt(read.readLine());
            System.out.print("Enter no. of painters: ");
            k[i] = Integer.parseInt(read.readLine());
	        // Instantiation array with the user input arrSize
            boards[i] = new int[noOfBoards];
	        System.out.print("Enter the size of boards (space separated): ");
	        String[] board = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<noOfBoards; ++j)
	        	boards[i][j] = Integer.parseInt(board[j]);
	    }
    }

    private static void runTestCase(int[] boards, int m) throws IOException  {
        // Printing the array
        System.out.println("Array: "+ Arrays.toString(boards));  
        // Binary Search
        int min = allocateBooks(boards, m);
        // Printing the output
        System.out.println("Output: " + min);
        System.out.println("=================================="); 
    }

    private static int allocateBooks(int[] boards, int m) {
		int start = 0, end = calculateSum(boards, 0, boards.length-1);
    	int maxTime = -1;
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
        	if(isMidPossible(boards, m, mid)) {
        		maxTime = mid;
        		end = mid - 1; // as right of mid are all answers but not min. value
        	} 
        	else { // as current mid is not possible so all values left to it would also be not possible
        		start = mid +1; 
        	}
    	}
		return maxTime;
    }

    private static boolean isMidPossible(int[] boards, int m, int mid) {
    	int boardCount = 0;
    	int painterCount = 0;
    	for(int i = 0; i < boards.length; i++) {
    		if(boardCount + boards[i] <= mid) {
    			boardCount += boards[i];
    		}
    		else {
    			++painterCount;
    			if(painterCount == m || boards[i] > mid) {
    				return false;
    			}
    			boardCount = boards[i];
    		}
    	}
    	return true;
    }
    
    private static int calculateSum(int[] arr, int start, int end) {
    	int sum = 0;
    	for(int i= start; i<=end; ++i)
    		sum+=arr[i];
    	return sum;
    }
    
    private static int getMidIndex(int start, int end) {
    	return start + (end-start)/2; // To avoid error due to range
    }
    
}
