package CodeChef.Starters.Starters50;

import java.io.*;
/**
 * MileageMatters
 * Problem Statement: To find the car chef should rent in order to minimize the cost of his travel.
 * URL: https://www.codechef.com/START50D/problems/MILEAGE
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 20 10 8 2 4
 * 			Output: DIESEL
 *		Test Case 2: 
 * 			Input: 50 12 12 4 3
 * 			Output: PETROL
 *		Test Case 3: 
 * 			Input: 40 3 15 8 40
 * 			Output: ANY
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class MileageMatters {
	static int testCaseSize, arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i][0], arr[i][1], arr[i][2], arr[i][3], arr[i][4]);
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
        arr = new int[testCaseSize][5];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
        	String[] str = read.readLine().split("\\s");
            // Initializing with the user input
        	arr[i][0] = Integer.parseInt(str[0]);// n
        	arr[i][1] = Integer.parseInt(str[1]);// x
        	arr[i][2] = Integer.parseInt(str[2]);// y
        	arr[i][3] = Integer.parseInt(str[3]);// a
        	arr[i][4] = Integer.parseInt(str[4]);// b
        }
    }

    public static void runTestCase(int n, int x, int y, int a, int b) throws IOException  {
        // Calculate the amount for diesel
    	float diesel = ((float)n / a ) * x;
        // Calculate the amount for petrol
    	float petrol = ((float)n / b ) * y;
    	// Find the car type
    	float result = diesel - petrol; 
        // Printing the result
    	if(result == 0) {
            System.out.println("ANY");
    	}
    	else if(result > 0) {
            System.out.println("DIESEL");
    	}
    	else 
            System.out.println("PETROL");
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}