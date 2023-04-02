package Stack;

import java.io.*;
import java.util.Stack;

/**
 * RedundantBrackets
 * Problem Statement: To check if the given string contains a redundant brackets or not.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: (a+b)
 * 			Output: No
 * 		Test Case 2: 
 * 			Input: ((a+b))
 * 			Output: Yes
 * 		Test Case 3: 
 * 			Input: (a+c*b)+(c))
 * 			Output: Yes
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... No new Stack is created but recursion call stack
 */

public class RedundantBrackets {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the string: ");
    	String str = read.readLine();
    	System.out.println("String is: "+str);
    	boolean result = checkRedundancy(str);
    	System.out.println(result ? "Yes" : "No");
    }
    
    private static boolean checkRedundancy(String str) {
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0; i<str.length(); ++i) {
    		char ch = str.charAt(i);
    		if(ch == '(' || ch == '+' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
    			stack.push(ch);
    		}
    		else {
    			if(ch == ')') {
    		    	boolean isRedundant = true;
    				while(!stack.empty() && stack.peek() != '(') {
    					char top = stack.pop(); // Pop Operators
    					if(top == '+' || top == '+' || top == '-' || top == '*' || top == '/') {
    						isRedundant = false;
    					}
    				}
    				if(!stack.empty())
    					stack.pop(); // Pop closing brackets
    				if(isRedundant)
    					return true;
    			}
    		}
    	}
		return false;
    }
}

