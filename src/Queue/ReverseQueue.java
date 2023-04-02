package Queue;

import java.util.*;
import java.io.*;

/**
 * ReverseQueue
 * Problem Statement: To reverse the given queue.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 5 4 3 2 1
 * 		Test Case 2: 
 * 			Input: 1 2 3 4
 * 			Output: 4 3 2 1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) ... No new Queue is created but recursion call stack
 */

public class ReverseQueue {

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
    	System.out.println("Queue is: " + queue);
    	reverse(queue, 0, size);
    	System.out.println("Reverse Queue is: " + queue);
    }
    
    private static void reverse(Queue<Integer> queue, int count, int size) {
    	if(queue.peek() == null) { // Base Case
    		return;
    	}
    	int temp = queue.poll();
    	// Recursive Relation
    	reverse(queue, count+1, size);
		queue.add(temp);
    }    
}

