package Array;

import java.io.*;
import java.util.ArrayList;

/**
 * FindUniqueOccurrences
 * Problem Statement: To find if the number of occurrences of each value in the array is unique or not. 
 * URL: https://leetcode.com/problems/unique-number-of-occurrences/
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1,2,2,1,1,3
 * 			Output: true
 *		Test Case 2: 
 * 			Input Array: 1,2
 * 			Output: false
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

public class FindUniqueOccurrences {
    static int testCaseSize, arrSize[], arr[][];
    
    static class Pair{
    	int num, count;
    	Pair(int num, int count) {
    		this.num = num;
    		this.count = count;
    	}
    }

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(i);
        }
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
        // Take input for current test case
        // Taking a valid array arrSize - input and arrSize should be an odd number
        arrSize = new int[testCaseSize];
        arr = new int[testCaseSize][];
        for(int i=0; i<testCaseSize; ++i) {
	        do{
	            try{
	                System.out.print("Enter arrSize of array: ");
	                arrSize[i] = Integer.parseInt(read.readLine());
	            } catch (Exception err) {
	                System.out.println("Error: " + err);
	            }
	        } while(arrSize[i]<=0); 
	        // Instantiation array with the user input arrSize
	        arr[i] = new int[arrSize[i]];
	        System.out.print("Enter array elements(space separated): ");
	        String[] arrInput = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<arrSize[i]; ++j)
	            arr[i][j] = Integer.parseInt(arrInput[j]);
	    }
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***"); 
        // Printing the array
        System.out.println("Array: ");  
        printArray(arr[caseNum]);
        // Finding Unique Occurrence of Elements
        Boolean unique = isUniqueOccurrence(arr[caseNum]);
        // Printing the output
        System.out.println("Unique Element in given array is: "+unique);
        System.out.println("=================================="); 
    }

    public static Boolean isUniqueOccurrence(int[] arr) {
    	Boolean unique = false;
    	ArrayList<Pair> pairs = new ArrayList<Pair>();
    	pairs.add(new Pair(arr[0], 1));
        for(int i=1; i<arr.length; i++) {
        	Boolean found = false;
        	for(int j=0;j<pairs.size(); ++j) {
        		if(pairs.get(j).num == arr[i]) {
        			pairs.get(j).count = 1+pairs.get(j).count;
        	        found = true;
        		}
        	}
        	if(!found) {
    			Pair p = new Pair(arr[i], 1);
    			pairs.add(p);
        	}
        }        
        for(int i=0;i<pairs.size(); ++i) {
        	for(int j=i+1;j<pairs.size(); ++j) {
        		if(pairs.get(i).count == pairs.get(j).count)
        			return false;
        	}
        	unique = true;
        }
        return unique;
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
