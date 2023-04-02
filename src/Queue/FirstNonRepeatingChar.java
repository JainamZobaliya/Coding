package Queue;

import java.util.*;
import java.io.*;

/**
 * FirstNonRepeatingChar
 * Problem Statement: To find first non repeating character from stream.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: a a b c
 * 			Output: a # b b
 * 		Test Case 2: 
 * 			Input: z z
 * 			Output: z #
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class FirstNonRepeatingChar {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the Stream String: ");
    	String str = read.readLine();
    	System.out.println("Stream is: " + str);
    	String result = getFirstNonRepeating(str);
    	System.out.println("First Non-Repeating Char. Stream: " + result);
    }
    
    private static String getFirstNonRepeating(String str) {
    	Queue<Character> queue = new LinkedList<Character>();
    	StringBuilder result = new StringBuilder();
    	int[] counter = new int[26];
    	for(int i=0; i<str.length(); ++i) {
    		char ch = str.charAt(i);
    		int pos = ch - 'a';
    		counter[pos]++;
    		queue.add(ch);
        	while(!queue.isEmpty()) {
        		ch = queue.peek();
        		pos = ch - 'a';
        		if(counter[pos]>1) { // Repeating Character
        			queue.poll();
        		}
        		else { // Non-Repeating Character
        			result.append(ch);
        			break;
        		}
        	}
    		if(queue.isEmpty()) { // Repeating Character
    			result.append("#");
    		}
    	}
    	return result.toString();
    }    
}

