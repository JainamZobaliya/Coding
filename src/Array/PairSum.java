package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * PairSum
 * Problem Statement: To find sorted pair of numbers whose sum is equal to given number.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 3 4 5 
 * 			Input Number: 5 
 * 			Output Matrix: [[1,4],[2,3]]
 *		Test Case 2: 
 * 			Input Array: 2 -3 3 3 -2
 * 			Input Number: 0 
 * 			Output Matrix: [[-3,3],[-3,3], [-2,2]]
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2) ... max pair possible is sum of (n-1) natural number
 */

public class PairSum {
    static int arrSize, arr[], sum, pairSum[][];
    
    static class Pair{
    	int x, y;
    	Pair(int x,int y){
    		this.x = x;
    		this.y = y;
    	}
    };

    public static void main(String[] args) throws IOException  {
    	takeInput();
        runTestCase();
    }

    public static void takeInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid array arrSize - input
        do{
            try{
                System.out.print("Enter arrSize of array: ");
                arrSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arrSize<=0); 
        System.out.print("Enter array elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing array with the user array input
        arr = new int[arrSize];
        for(int i=0; i<arrInput.length; ++i)
            arr[i] = Integer.parseInt(arrInput[i]);
        System.out.print("Enter sum: ");
        sum = Integer.parseInt(read.readLine());
    }

    public static void runTestCase() throws IOException  {
        // Printing the array before performing operations
        System.out.print("Array: ");  
        printArray(arr);
        // Find Duplicate Element
        getPairSum(arr, sum);
        // Printing the result
        System.out.println("Following pairs have sum as "+sum+": " );
        print2dArray(pairSum);
        System.out.println("=================================="); 
    }

    public static void getPairSum(int[] arr, int sum) {
    	// Since, we don't know the number of pairs ... creating arrayList.
    	ArrayList<Pair> pair = new ArrayList<Pair>();
    	for(int i=0; i<arr.length; ++i) {
        	for(int j=i+1; j<arr.length; ++j) {
	    		if(arr[i]+arr[j]==sum)
	    			pair.add(new Pair(Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])));
        	}
    	}
    	// Transferring values from arrayList to 2d array.
    	pairSum = new int[pair.size()][2];
    	for(int i=0; i<pair.size(); ++i) {
    		pairSum[i][0] = pair.get(i).x;
    		pairSum[i][1] = pair.get(i).y;
    	}
    	// To sort arrays based on their first number.
    	final Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
               if(arr1[0] > arr2[0]) return 1;
               else 
            	   return -1;
            }
        };
		Arrays.sort(pairSum, comp);
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }

    public static void print2dArray(int[][] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) {
            for(int j=0; j<arr[i].length; ++j) 
            	System.out.print(arr[i][j] + " ");  
        	System.out.println();   
        }
    }
    
}
