package Queue;

import java.util.*;
import java.io.*;

/**
 * Interleave
 * Problem Statement: To rearrange the elements by interleaving the first half and second half of the queue.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5 6 7 8
 * 			Output: 1 5 2 6 3 4 7 8
 * 		Test Case 2: 
 * 			Input: 1 2 3 4 5
 * 			Output: 1 4 2 5 3
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Interleave {

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
    	Queue<Integer> inter1 = interleave1(queue);
    	System.out.println("Interleaved Queue is: " + inter1);
    	Queue<Integer> inter2 = interleave2(queue);
    	System.out.println("Interleaved Queue is: " + inter2);
    }
    
    private static Queue<Integer> interleave1(Queue<Integer> queue) { // Approach-1: TC: O(n), SC: O(n)
    	if(queue.size()==0) { // Base Case
    		return queue;
    	}
    	Queue<Integer> originalQueue = new LinkedList<Integer>();
    	originalQueue.addAll(queue);
    	Queue<Integer> newQueue = new LinkedList<Integer>();
    	int halfSize = (int) Math.ceil(originalQueue.size()/(double)2);
    	for(int i=0; i < halfSize; ++i) { // Adding first half to new queue
    		newQueue.add(originalQueue.poll());
    	}
    	while(!newQueue.isEmpty()) { // Interleaving first half (new queue) and second half (orig. queue)
    		originalQueue.add(newQueue.poll());
			originalQueue.add(originalQueue.poll());
    		if(newQueue.size()==1 && queue.size()%2==1)
    			originalQueue.add(newQueue.poll());
    	}
    	return originalQueue;
    }    
    
    private static Queue<Integer> interleave2(Queue<Integer> queue) { // Approach-2: TC: O(n), SC: O(n)
    	if(queue.peek() == null) { // Base Case
    		return queue;
    	}
    	Queue<Integer> originalQueue = new LinkedList<Integer>();
    	originalQueue.addAll(queue);
    	int halfSize = (int) Math.ceil((double)originalQueue.size()/2);
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0; i < halfSize; ++i) { // Adding first half to new queue
    		stack.push(originalQueue.poll());
    	}
    	while(!stack.isEmpty()) { // Emptying the stack and pushing at rear of queue
    		originalQueue.add(stack.pop());
    	}
    	for(int i=0; i < originalQueue.size() - halfSize; ++i) { // Adding first half to end of queue
    		originalQueue.add(originalQueue.poll());
    	}
    	for(int i=0; i < halfSize; ++i) {
    		// Adding first half to new queue, so now stack has elements in reverse order
    		stack.push(originalQueue.poll());
    	}
    	while(!stack.isEmpty()) { // Emptying the stack and pushing at rear of queue
    		originalQueue.add(stack.pop());
    		originalQueue.add(originalQueue.poll());
    		if(stack.size()==1 && queue.size()%2==1)
    			originalQueue.add(stack.pop());
    	}
    	return originalQueue;
    }    
}

