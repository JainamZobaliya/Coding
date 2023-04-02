package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * MaxRectangle
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

public class MaxRectangle {

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
    	int area = getMaxArea(arr, size);
    	System.out.print("Max Area: " + area);
    }
    
    private static int getMaxArea(int[][] arr, int size) {
    	if(arr.length==0) {
    		return -1;
    	}
    	int maxArea = Integer.MIN_VALUE;
    	for(int i=0; i<size; ++i) {
	    	for(int j=0; j<size; ++j) {
	    		if(arr[i][j] == 0)
	    			arr[i][j] = 0;
	    		else if(i>0)
	    			arr[i][j] = arr[i-1][j] + arr[i][j];
	    	}
			int area = getLargestRectangleArea(arr[i], size);
			maxArea = Math.max(maxArea, area);
    	}
    	return maxArea;    	
    }
    
    private static int getLargestRectangleArea(int[] arr, int size) {
    	if(arr.length==0) {
    		return 0;
    	}
    	ArrayList<Integer> next = nextSmallerElement(arr, size);
    	ArrayList<Integer> previous = previousSmallerElement(arr, size);
    	int maxArea = Integer.MIN_VALUE;
    	for(int i=0; i<arr.length; ++i) {
    		int length = arr[i];
    		if(next.get(i) == -1)
    			next.set(i, size);
    		int breadth = next.get(i) - previous.get(i) - 1;
    		int area = length * breadth;
    		maxArea = Math.max(maxArea, area);    		
    	}
    	return maxArea;
    }
    
    private static ArrayList<Integer> nextSmallerElement(int[] arr, int size) {
    	int i = size - 1;
    	Stack<Integer> stack = new Stack<Integer>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(size == 0) {
    		return result;
    	}
        int j = 0;
        while(j<size) {
            result.add(-1);
            j++;
        }
    	stack.push(-1); // As right most element's smaller element is None so -1;
    	while(i!=-1) {
			while(stack.peek() != -1 && arr[stack.peek()] >= arr[i]) { // Removing larger elements from stack 
				stack.pop();
			}
			result.set(i, stack.peek());
			stack.push(i); // Storing i to stack as we want indexes;
    		i--;
    	}
    	return result;
    }    
    
    private static ArrayList<Integer> previousSmallerElement(int[] arr, int size) {
    	int i = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(size == 0) {
    		return result;
    	}
        int j = 0;
        while(j<size) {
            result.add(-1);
            j++;
        }
    	stack.push(-1); // As right most element's smaller element is None so -1;
    	while(i!=size) {
			while(stack.peek() != -1 && arr[stack.peek()] >= arr[i]) { // Removing larger elements from stack 
				stack.pop();
			}
			result.set(i, stack.peek());
			stack.push(i); // Storing i to stack as we want indexes;
    		i++;
    	}
    	return result;
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

