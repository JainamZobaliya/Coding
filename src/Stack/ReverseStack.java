package Stack;

import java.io.*;
import java.util.Stack;

/**
 * ReverseStack
 * Problem Statement: To reverse the given Stack.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 5 4 3 2 1
 * 		Test Case 2: 
 * 			Input: 1 2 3 4
 * 			Output: 4 3 2 1
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) ... No new Stack is created but recursion call stack
 */

public class ReverseStack {

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
    	reverse(stack, 0, size);
    	System.out.println("Reverse Stack is: " + stack);
    }
    
    private static void reverse(Stack<Integer> stack, int count, int size) {
    	if(stack.empty()) { // Base Case
    		return;
    	}
    	int temp = stack.pop();
    	// Recursive Relation
    	reverse(stack, count+1, size);
    	insertAtBottom(stack, 0, stack.size(), temp);
    }    
    
    private static void insertAtBottom(Stack<Integer> stack, int count, int size, int element) {
    	if(count == size) { // Base Case
    		stack.push(element);
    		return;
    	}
    	int temp = stack.pop();
    	// Recursive Relation
    	insertAtBottom(stack, count+1, size, element);
    	stack.push(temp);
    } 
}

