package Stack;

import java.io.*;
import java.util.Stack;
import java.util.ArrayList;

/**
 * LargestRectangleInHistogram
 * Problem Statement: Given an array of integers heights representing the histogram's bar height where the
 * width of each bar is 1, return the area of the largest rectangle in the histogram.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 2 1 5 6 2 3
 * 			Output: 10
 * 		Test Case 2: 
 * 			Input: 2 4
 * 			Output: 4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... new Stack is created
 */

public class LargestRectangleInHistogram {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the array size: ");
    	int size = Integer.parseInt(read.readLine());
        System.out.print("Enter the array elements (Space Separated): ");
    	String[] strArr = read.readLine().split("\\s");
    	int[] arr = new int[size];
    	int i=0;
    	while(i<size) {
    		arr[i] = Integer.parseInt(strArr[i]);
    		i++;
    	}
    	System.out.print("Array is: ");
    	printArray(arr);
    	int area = getLargestRectangleArea(arr, size);
    	System.out.print("Largest Rectangle Area: " + area);
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
	
	public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();
    }
}

