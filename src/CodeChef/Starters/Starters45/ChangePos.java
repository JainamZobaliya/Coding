package CodeChef.Starters.Starters45;

import java.io.*;
/**
 * ChangePos
 * Problem Statement: To return min. no. of steps.
 * URL: https://www.codechef.com/START45D/problems/CHANGEPOS
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 9 8
 * 			Output: 1
 *		Test Case 2: 
 * 			Input Array: 5 5 5 7
 * 			Output: 2
 *		Test Case 3: 
 * 			Input Array: 8 6 6 8
 * 			Output: 1
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class ChangePos {
	static int testCaseSize, data[][], minMoves[];

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
        data = new int[testCaseSize][4];
        minMoves = new int[testCaseSize];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            data[i][0] = Integer.parseInt(arrInput[0]); // Sx
            data[i][1] = Integer.parseInt(arrInput[1]); // Sy
            data[i][2] = Integer.parseInt(arrInput[2]); // Ex
            data[i][3] = Integer.parseInt(arrInput[3]); // Ey
        }
    }

    public static void runTestCase() throws IOException  {
        // Get Min Moves
    	getMinMoves();
        // Printing Min Moves
        printArray(minMoves);
    }

    private static void getMinMoves() {
        for(int i=0; i<testCaseSize; ++i) {
            int sx = data[i][0]; // Sx
            int sy = data[i][1]; // Sy
            int ex = data[i][2]; // Ex
            int ey = data[i][3]; // Ey
            int move = 1;
            if(sx==ex)
            	++move;
            if(sy==ey)
            	++move;
        	minMoves[i]= move;         	
        }
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}
