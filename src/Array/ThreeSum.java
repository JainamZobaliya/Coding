package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ThreeSum
 * Problem Statement: To find 3 numbers whose sum is equal to given number.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 10 5 5 5 2 
 * 			Input Number: 12 
 * 			Output Matrix: [[5,5,2]]
 *		Test Case 2: 
 * 			Input Array: 1 2 3 4 
 * 			Input Number: 11 
 * 			Output Matrix: []
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) ... Not consider space to store the triplets
 */

public class ThreeSum {
	static int testCaseSize, arrSize[], arr[][], sum[];
	static ArrayList<ArrayList<Integer>> triplets;

	public static void main(String[] args) throws IOException  {
	    takeTestCaseInput();
	    for(int i=0; i<testCaseSize; ++i)
	    	runTestCase(i);
	}
	
	public static void takeTestCaseInput() throws IOException  {
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
	    triplets = new ArrayList<ArrayList<Integer>>();
	    arrSize = new int[testCaseSize];
	    sum = new int[testCaseSize];
	    arr = new int[testCaseSize][];
	    for(int i=0; i<testCaseSize; ++i){
	    	// Taking a valid array arrSize - input
	        do{
	            try{
	                System.out.print("Enter arrSize of array: ");
	                arrSize[i] = Integer.parseInt(read.readLine());
	            } catch (Exception err) {
	                System.out.println("Error: " + err);
	            }
	        } while(arrSize[i]<=0); 
	        System.out.print("Enter array elements(space separated): ");
	        String[] arrInput = read.readLine().split("\s");
	        // Initializing array with the user array input
	        arr[i] = new int[arrSize[i]];
	        for(int j=0; j<arrInput.length; ++j)
	            arr[i][j] = Integer.parseInt(arrInput[j]);
	        System.out.print("Enter sum: ");
	        sum[i] = Integer.parseInt(read.readLine());
		}
	}
	
	public static void runTestCase(int testCaseNum) throws IOException  {
		System.out.println("*** Test Case: "+(testCaseNum+1)+" ***");
	    // Printing the array before performing operations
	    System.out.print("Array: ");  
	    printArray(arr[testCaseNum]);
	    // Find Three Sum Elements
	    getThreeSum(arr[testCaseNum], sum[testCaseNum]);
	    // Printing the result
//	    System.out.println("Following Three Numbers have sum as "+sum[testCaseNum]+": " );
//	    printArrayList(triplets.get(testCaseNum));
	    System.out.println("=================================="); 
	}
	
	public static void getThreeSum(int[] arr, int sum) {
//		// Approach-1: Using 3 Loops ==> TC: O(n^3), SC: O(1)
//		Boolean result = false;
//	    for(int i=0; i<arr.length; ++i) {
//	        for(int j=i+1; j<arr.length; ++j) {
//	            for(int k=j+1; k<arr.length; ++k) {
//	                if(arr[i]+arr[j]+arr[k]==sum){
//	                    ArrayList<Integer> trip = new ArrayList<Integer>();
//	                    trip.add(arr[i]);
//	                    trip.add(arr[j]);
//	                    trip.add(arr[k]);
//	                    Collections.sort(trip);
//	                    if(!triplets.contains(trip)){
//	                        triplets.add(trip);
//	                        result = true;
//	                    }
//	                }
//	            }
//	        }
//	    }
//	    if(!result)
//            triplets.add(new ArrayList<Integer>());
		// Approach-2: Using 2 pointer ==> TC: O(n^2), SC: O(1)
		Boolean result = false;
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> tripper = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<arr.length-2; ++i) {
			int left = i+1;
			int right = arr.length - 1;
			while(left<right) {
				int tempSum = sum - arr[i];
				int sum2 = arr[left] + arr[right];
				if(sum2==tempSum) {
					ArrayList<Integer> trip = new ArrayList<Integer>();
                    trip.add(arr[i]);
                    trip.add(arr[left]);
                    trip.add(arr[right]);
                    Collections.sort(trip);
                    if(!tripper.contains(trip)){
                    	tripper.add(trip);
                    }
                    result = true;
                    ++left;
                    --right;
                    
				} 
				else if (sum2>tempSum)
					--right;
				else
					++left;
			}
		}
	    // Printing the result
	    System.out.println("Following Three Numbers have sum as "+sum+": " );
		if(!result)
			System.out.println(-1);
		else
			for(int i=0; i<tripper.size(); ++i)
				printArrayList(tripper.get(i));
//            triplets.add(new ArrayList<Integer>());
		// Approach-3: Using HashMap ==> TC: O(n^2), SC: O(n)
	}
	
	private static void printArrayList(ArrayList<Integer> trip) {
		if(trip.size() == 0)
			System.out.println(-1);
		else {
			printArray(trip.toArray());
		}
	}
	
	public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();
    }
	
	public static void printArray(Object[] objects) {
        // Traversing the array  
        for(int i=0; i<objects.length; ++i) 
            System.out.print(objects[i] + " ");  
        System.out.println();   
    }

}




