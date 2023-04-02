package CodeChef.Starters.Starters45;

import java.io.*;
/**
 * BestOfTwo
 * Problem Statement: To return best score out of two.
 * URL: https://www.codechef.com/START45D/problems/BESTOFTWO
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 40 50 
 * 			Output Array: 50
 *		Test Case 2: 
 * 			Input Array: 80 80
 * 			Output Array: 80
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class BestOfTwo {
	static int testCaseSize, scores[][], bestOfTwo[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        runTestCase();
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
        scores = new int[testCaseSize][2];
        bestOfTwo = new int[testCaseSize];
        // Take input for all test cases
        takeInput();
    }

    public static void runTestCase() throws IOException  {
        // Get Best Of Two Scores
        getBestOfTwo();
        // Printing Best Of Two Scores
        printArray(bestOfTwo);
    }

    private static void getBestOfTwo() {
        for(int i=0; i<testCaseSize; ++i) {
            bestOfTwo[i] = scores[i][0] > scores[i][1] ? scores[i][0] : scores[i][1];
        }
	}

	public static void takeInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // System.out.print("Enter two scores X(score1) and Y(score2): ");
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
        	scores[i][0] = Integer.parseInt(arrInput[0]);
            scores[i][1] = Integer.parseInt(arrInput[1]);
        }
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}
