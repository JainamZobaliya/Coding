package Stack;

import java.io.*;
import java.util.Stack;

/**
 * SortStack
 * Problem Statement: To sort the given Stack.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 3 5 2 4
 * 			Output: 1 2 3 4 5
 * 		Test Case 2: 
 * 			Input: 5 -2 9 -7 3
 * 			Output: -7 -2 3 5 9
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) ... No new Stack is created but recursion call stack
 */

public class SortStack {

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
    	sort(stack, 0, size);
    	System.out.println("Sorted Stack is: " + stack);
    }
    
    private static void sort(Stack<Integer> stack, int count, int size) {
    	if(stack.empty()) { // Base Case
    		return;
    	}
    	int temp = stack.pop();
    	// Recursive Relation
    	sort(stack, count+1, size);
    	sortAndInsert(stack, temp);
    }    
    
    private static void sortAndInsert(Stack<Integer> stack, int element) {
    	if(stack.empty() || stack.peek() <= element) { // Base Case
    		stack.push(element);
    		return;
    	}
    	int temp = stack.pop();
    	// Recursive Relation
    	sortAndInsert(stack, element);
    	stack.push(temp);
    } 
}

