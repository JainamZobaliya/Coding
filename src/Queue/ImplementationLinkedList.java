package Queue;

import java.io.*;
import java.util.LinkedList;

/**
 * ImplementationLinkedList
 * Problem Statement: To create Queue from Linked List.
 * Operations:
 * 1. Create a Queue
 * 2. Push Data to Queue
 * 3. Pop Data from Queue
 * 4. Peek Data from Queue
 * 5. Delete Queue
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ImplementationLinkedList {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static LinkedList<Integer> queue;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Queue Implementation From Array *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Queue");
    	System.out.println("* 2. Push Data");
		System.out.println("* 3. Pop Data");
		System.out.println("* 4. Peek Data");
		System.out.println("* 5. Queue isEmpty?");
		System.out.println("* 6. Delete Queue");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createQueue();
	    	break;
	    	case 2: 
	    		push();
	    	break;
	    	case 3: 
	    		pop();
	    	break;
	    	case 4: 
	    		peek();
	    	break;
	    	case 5: 
	    		isEmpty();
	    	break;
	    	case 6: 
	    		deleteQueue();
	    	break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createQueue() throws IOException {
        System.out.println("\t*** Create a Queue ***");
        if(queue != null) {
        	System.out.print("\tDo you want to overwrite existing queue? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
    	queue = new LinkedList<Integer>();
    	System.out.println("\tSuccessfully Created Queue!!");
    }
    
    private static void push() throws IOException {
        System.out.println("\t*** Push Data to Queue ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
    	int data = getDataInput(false);
    	queue.addLast(data); // Adding data to rear
    	System.out.println("Data-"+data+" added to Queue succesfully!!");
    }
    
    private static void pop() throws IOException {
        System.out.println("\t*** Pop Data from Queue ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        if(queue.isEmpty()) {
        	System.out.println("Queue is Empty!!");
        	return;
        }
        int data = queue.removeFirst(); // Removing data from front
        System.out.println("Data-"+data+" popped from queue!!");
    }
    
    private static void peek() throws IOException {
        System.out.println("\t*** Peek Data from Queue ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        if(queue.isEmpty()) {
        	System.out.println("Queue is Empty!!");
        	return;
        }
        int data = queue.getFirst(); // data peeked from front
        System.out.println("Data-"+data+" peekeed from queue!!");
    }
    
    private static void isEmpty() throws IOException {
        System.out.println("\t*** Queue isEmpty> ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        boolean result = queue.isEmpty();
		if(result) {
			System.out.println("\tQueue is Empty!!");
		}
		else {
			System.out.println("\tQueue is not Empty!!");
		}
    }
    
    private static void deleteQueue() throws IOException {
        System.out.println("\t*** Delete the Queue ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        while(!queue.isEmpty()) {
        	pop();
        }
        queue = null;
    	System.out.println("\tSuccessfully Deleted Queue!!");
    }

    private static int getDataInput(boolean isLength) throws IOException {
        System.out.print(isLength ? "Enter length of Queue: " : "Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
