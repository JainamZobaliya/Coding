package CodeChef.Starters.Starters46;

import java.io.*;
import java.util.Arrays;
/**
 * ArraySorting
 * Problem Statement: To find the maximum possible value of K.
 * URL: https://www.codechef.com/START46D/problems/ARRSORT
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 4 2 3 1
 * 			Output: 3
 *		Test Case 2: 
 * 			Input Array: 1 4 3 2 5
 * 			Output: 2
 *		Test Case 3: 
 * 			Input Array: 2 1
 * 			Output: 1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ArraySorting {
	static int testCaseSize, arrSize[], arr[][];

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
        arrSize = new int[testCaseSize]; 
        arr = new int[testCaseSize][];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            arrSize[i] = Integer.parseInt(read.readLine()); 
            arr[i] = new int[arrSize[i]];
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            for(int j=0; j<arrSize[i]; ++j) {
            	arr[i][j] = Integer.parseInt(arrInput[j]); // Pj
            }
        }
    }

    public static void runTestCase(int[] arr) throws IOException  {
        // find value of k
    	int k = findK(arr);
        // Printing the result
        System.out.println(k>0 ? k : 0);
    }
    
    public static int findK(int[] arr) {
    	int result = -1;
    	for(int i=0; i<arr.length; ++i) {
    		if(arr[i] != (i+1)) {
				result = Math.max(result, arr[i]-(i+1));
				int temp = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = temp;
    		}
    	}
    	return result;    	
    }
    
    public static boolean inspect(int num, int count) {
    	boolean result = false;
    	double personPerGrp = (double) num / count;
		if(Math.ceil(personPerGrp) == 1.0 && Math.floor(personPerGrp) == 1.0) {
			result = true;
			count = 1;
		}
		else {
			result = false;
		}
		return result;
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}

