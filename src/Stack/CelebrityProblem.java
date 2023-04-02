package Stack;

import java.io.*;
import java.util.Stack;

/**
 * CelebrityProblem
 * Problem Statement: To return the index of the celebrity. If no such celebrity is present, return -1.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 0 1 0
 *                 0 0 0
 *                 0 1 0
 * 			Output: 1
 * 		Test Case 2: 
 * 			Input: 0 1
 *                 1 0
 * 			Output: -1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... new Stack is created
 */

public class CelebrityProblem {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the array size: ");
    	int size = Integer.parseInt(read.readLine());
    	int row = 0;
    	int[][] arr = new int[size][size];
    	while(row<size) {
	        System.out.print("Enter the elements (Space Separated) for row-"+row+": ");
	    	String[] strArr = read.readLine().split("\\s");
	    	int i=0;
	    	while(i<size) {
	    		arr[row][i] = Integer.parseInt(strArr[i]);
	    		i++;
	    	}
	    	++row;
    	}
    	System.out.println("Array is: ");
    	print2dArray(arr);
    	int index = getCelebrityIndex(arr, size);
    	System.out.print("Celebrity Index: " + index);
    }
    
    private static int getCelebrityIndex(int[][] arr, int size) {
    	if(arr.length==0) {
    		return -1;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0; i<size; ++i) {
    		stack.push(i);
    	}
    	while(!stack.empty() && stack.size()!=1) {
    		int a = stack.pop();
    		int b = stack.pop();
    		if(knows(arr, a, b)) {
    			stack.push(b);
    		}
    		else if(knows(arr, b, a)) {
    			stack.push(a);
    		}
    	}
    	if(stack.empty())
    		return -1;
    	int potentialCandidate = stack.pop();
    	int zeroCount = 0;
    	for(int i=0; i<size; ++i) { // Checking potential Candidate's row
    		if(arr[potentialCandidate][i] == 0)
    			++zeroCount;
    	}
    	int oneCount = 0;
    	for(int i=0; i<size; ++i) { // Checking potential Candidate's column
    		if(arr[i][potentialCandidate] == 1)
    			++oneCount;
    	}
    	if(zeroCount == size && oneCount == size-1)
    		return potentialCandidate;
    	return -1;
    }
    
    private static boolean knows(int arr[][], int a, int b) {
		if(arr[a][b] == 1)
			return true;
    	return false;
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

