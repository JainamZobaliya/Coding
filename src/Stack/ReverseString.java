package Stack;

import java.io.*;
import java.util.Stack;

/**
 * ReverseString
 * Problem Statement: To reverse a string using Stack.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: abcde
 * 			Output: edcba
 * 		Test Case 2: 
 * 			Input: abcd
 * 			Output: ccba
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ReverseString {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the string: ");
    	String str = read.readLine();
    	System.out.println("String is: "+str);
    	String reverse = reverse(str);
    	System.out.println("Reverse String is: "+reverse);
    }
    
    private static String reverse(String str) {
    	StringBuilder reverse = new StringBuilder();
    	int i=0;
    	Stack<Character> stack = new Stack<Character>();
    	while(i<str.length()) { // Pushing string char in stack
    		stack.push(str.charAt(i));
    		++i;
    	}
    	while(!stack.empty()) { // Popping stack and appending to reverse string
    		reverse.append(stack.pop());
    	}
    	return reverse.toString();
    }
    
}
