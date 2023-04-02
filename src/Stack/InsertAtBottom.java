package Stack;

import java.io.*;
import java.util.Stack;

/**
 * InsertAtBottom
 * Problem Statement: To delete middle element from Stack.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Element: 6
 * 			Output: 1 2 3 4 5 6
 * 		Test Case 2: 
 * 			Input: 1 2 3 4
 * 			Element: 5
 * 			Output: 1 2 3 4 5
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... No new Stack is created but recursion call stack
 */

public class InsertAtBottom {

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
        System.out.print("Enter new element to be inserted: ");
    	int element = Integer.parseInt(read.readLine());
    	System.out.println("Stack is: " + stack);
    	insertAtBottom(stack, 0, size, element);
    	System.out.println("Now, Stack is: " + stack);
    	System.out.println("First Element is: " + stack.peek());
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

