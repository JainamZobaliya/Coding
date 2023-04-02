package Stack;

import java.io.*;
import java.util.Stack;

/**
 * DeleteMid
 * Problem Statement: To delete middle element from Stack.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 1 2 4 5
 * 		Test Case 2: 
 * 			Input: 1 2 3 4
 * 			Output: 1 2 4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class DeleteMid {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the stack size: ");
    	int size = Integer.parseInt(read.readLine());
        System.out.print("Enter the stack elements (Space Separated): ");
    	String[] arr = read.readLine().split("\\s");
    	Stack<Integer> stack = new Stack<Integer>();
    	int i=0;
    	while(i<size) {
    		stack.push(Integer.parseInt(arr[i]));
    		i++;
    	}
    	System.out.println("Stack is: " + stack);
    	deleteMid(stack, 0, size);
    	System.out.println("Now, Stack is: " + stack);
    }
    
    private static void deleteMid(Stack<Integer> stack, int count, int size) {
    	if(count == size/2) { // Base Case
    		stack.pop();
    		return;
    	}
    	int temp = stack.pop();
    	// Recursive Relation
    	deleteMid(stack, count+1, size);
    	stack.push(temp);
    }
    
}

