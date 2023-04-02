package Stack;

import java.io.*;
import java.util.Stack;

/**
 * MinimumCost
 * Problem Statement: To return the minimum cost to make given string valid.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: {{}}
 * 			Output: 0
 * 		Test Case 2: 
 * 			Input: }{}
 * 			Output: -1
 * 		Test Case 3: 
 * 			Input: {}{{
 * 			Output: 1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... No new Stack is created but recursion call stack
 */

public class MinimumCost {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the string: ");
    	String str = read.readLine();
    	System.out.println("String is: "+str);
    	int result = findMinimumCost(str);
    	System.out.println("Minimum Cost: " + result);
    }
    
    private static int findMinimumCost(String str) {
    	if( str.length() == 0 || str.length()%2 != 0) { // Odd Length
    		return -1;
    	}
    	// For Even Length
    	Stack<Character> stack = new Stack<Character>();
    	int i=0;
    	// Creating Stack of invalid Parentheses
    	while(i!=str.length()) {
    		char ch = str.charAt(i);
    		if(ch == '{')
    			stack.push(ch);
    		else {
    			if(!stack.empty()) {
    				char top = stack.peek();
    				if(top == '{') {
    					stack.pop();
    				}
    				else {
    					stack.push(ch);
    				}
    			}
				else {
					stack.push(ch);
				}
    		}
    		++i;
    	}
    	// Counting invalid open and close Parentheses
    	int open = 0, close = 0;
    	while(!stack.empty()) {
    		char top = stack.pop();
    		if(top == '{')
    			++open;
    		else
    			++close;
    	}
    	return ((open+1) / 2) + ((close+1) / 2);
    }
}

