package CodeChef.Starters.Starters50;

import java.io.*;
/**
 * AveragePermutation
 * Problem Statement: To find permutation such that sum of averages of all consecutive triplets is minimized.
 * URL: https://www.codechef.com/START50D/problems/AVGPERM
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 4
 * 			Output: 3 2 1 4
 *		Test Case 2: 
 * 			Input: 3
 * 			Output: 3 2 1
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


public class AveragePermutation {
	static int testCaseSize, arr[];
	static float minAvg = Float.MAX_VALUE;

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
            // Initializing with the user input
        	arr[i] = Integer.parseInt(read.readLine());// n
        }
    }

    public static void runTestCase(int n) throws IOException  {
    	minAvg = Float.MAX_VALUE;
    	int[] arr = new int[n];
    	for(int i=n; i>0; --i)
    		arr[n-i] = i;
    	// System.out.print("\tN is "+ n+" ");
    	// printArray(arr);
        // find all permutations
    	int[] result = new int[n];
    	result = getAllPermutations(arr, 0, result);
        // Printing the result
    	printArray(result);
    }
    
    private static int[] getAllPermutations(int[] arr, int index, int[] result) {
    	// Base Case
    	if(index >= arr.length) { 
    		float currMin = getMinAvgPermutation(arr);
    		if(currMin < minAvg) {
        		// System.out.println(minAvg+" --> " + currMin);
    			minAvg = currMin;
        		result = arr.clone();
        		// printArray(result);
    		}
    		return result;
    	}
    	for(int i=index; i<arr.length; ++i) {
    		swap(arr, index, i);
    		// Recursive Relation
    		result = getAllPermutations(arr, index+1, result);
    		// BackTracking
    		swap(arr, index, i);
    	}
    	return result;
    }
    
    private static float getMinAvgPermutation(int[] current) {
		float currentMin = 0;
		for(int j=0; j+3<current.length; ++j) {
			int sum = current[j] + current[j+1] + current[j+2];
			float avg = (float) sum / 3;
			currentMin += avg; 
		}
		return currentMin;
    }
    
    private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}