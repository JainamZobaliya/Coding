package Queue;

import java.util.*;
import java.io.*;

/**
 * ReverseFirstK
 * Problem Statement: To reverse the first k elements of the given queue.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: -8 2 3 -6 10
 *          Input K: 2
 * 			Output: 2 -8 3 -6 10
 * 		Test Case 2: 
 * 			Input: 12 -1 -7 8 -15 30 16 28
 *          Input K: 3
 * 			Output: -7 -1 12 8 -15 30 16 28
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

public class ReverseFirstK {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the queue size: ");
    	int size = Integer.parseInt(read.readLine());
        System.out.print("Enter the queue elements (Space Separated): ");
    	String[] arr = read.readLine().split("\\s");
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int i=0;
    	while(i<size) {
    		queue.add(Integer.parseInt(arr[i]));
    		i++;
    	}
    	System.out.print("Enter value of k: ");
    	int k = Integer.parseInt(read.readLine());
    	System.out.println("Queue is: " + queue);
    	reverseFirstK(queue, k);
    	System.out.println("Reverse Queue is: " + queue);
    }
    
    private static void reverseFirstK(Queue<Integer> queue, int k) {
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0; i<k; i++) {
    		stack.push(queue.poll());
    	}
    	while(!stack.isEmpty()) {
    		queue.add(stack.pop());
    	}
    	for(int i=0; i<queue.size() - k; i++) {
    		queue.add(queue.poll());
    	}
    }    
}

