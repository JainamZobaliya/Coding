package Stack;

import java.io.*;
import java.util.Stack;

/**
 * NextSmallerElement
 * Problem Statement: To find next smaller element for each array element.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 2 1 4 3
 * 			Output: 1 -1 3 -1
 * 		Test Case 2: 
 * 			Input: 1 3 2
 * 			Output: -1 2 -1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... new Stack is created
 */

public class NextSmallerElement {

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
    	int[] result = nextSmallerElement(arr, size);
    	System.out.print("Next Smaller Elements is: ");
    	printArray(result);
    }
    
    private static int[] nextSmallerElement(int[] arr, int size) {
    	if(size == 0)
    		return new int[-1];
    	int i = size - 1;
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] result = new int[size];
    	stack.push(-1); // As right most element's smaller element is None so -1;
    	while(i!=-1) {
    		int top = stack.peek();
    		if(top < arr[i]) {
    			stack.push(arr[i]); // Adding ith element to stack;
    			result[i] = top;
    		}
    		else {
    			while(!stack.empty() && stack.peek() >= arr[i]) { // Removing larger elements from stack 
    				stack.pop();
    			}
    			result[i] = stack.peek();
    			stack.push(arr[i]); // Adding ith element to stack;
    		}
    		i--;
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

