package Stack;

import java.io.*;
import java.util.Stack;

/**
 * ValidParenthesis
 * Problem Statement: To determine whether the parentheses are balanced or not.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: [()]{}{[()()]()}
 * 			Output: Balanced
 * 		Test Case 2: 
 * 			Input: [(])
 * 			Output: Not Balanced
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... stack size
 */

public class ValidParenthesis {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the string: ");
    	String str = read.readLine();
    	System.out.println("String is: "+str);
    	boolean result = isValidParenthesis(str);
    	System.out.println(result ? "Balanced" : "Not Balanced");
    }
    
    private static boolean isValidParenthesis(String expression) {
        boolean isBalanced = false;
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        while(i<expression.length()) {
            char currentChar = expression.charAt(i);
            switch(currentChar) { // Push Opening Brackets to Stack
                case '{':
                case '[':
                case '(':
                    stack.push(currentChar);
                    ++i;
                continue;
                default:
                break;
            }
            if(stack.empty()) { // Closing Bracket found but Stack is empty
                return false;
            }
            char top = stack.peek();
            if((top == '[' && currentChar ==']') ||(top == '{' && currentChar =='}') ||
            		(top == '(' && currentChar ==')') ){  // Popping Opening Brackets from Stack
                stack.pop();
                isBalanced = true;
                ++i;
           }
            else {
			    return false;
			}
        }
        if(!stack.empty()) {
            isBalanced = false;
        }
        return isBalanced;
    }
    
}

