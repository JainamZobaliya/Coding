package Stack;

import java.io.*;

/**
 * ImplementationLinkedList
 * Problem Statement: To create stack from Linked List.
 * Operations:
 * 1. Create a Stack
 * 2. Push Data to Stack
 * 3. Pop Data from Stack
 * 4. Peek Data from Stack
 * 5. Delete Stack
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class StackFromSLL {
	Node top;
	
	StackFromSLL(int data) {
		top = new Node(data);
	}
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void push(int data) {
		if(top==null) { // Stack is Null
			System.out.println("No Stack Exists!!");
		}
		else { 
			Node start = new Node(data);
			// Insert At Beginning
			start.next = top;
			top = start;
			System.out.println("\tData-"+data+" pushed to stack.");
		}
	}
	
	void pop() {
		if(top==null) { // Stack is Null
			System.out.println("No Stack Exists!!");
		}
		else {
			int data = top.data;
			top = top.next; // Delete from Beginning
			System.out.println("\tData-"+data+" popped from stack.");
		}
	}
	
	void peek() {
		if(top==null) { // Stack is Null
			System.out.println("\tStack is Empty!!");
		}
		else {
			int data = top.data;
			System.out.println("\tData-"+data+" peeked from stack.");
		}
	}
}

public class ImplementationLinkedList {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static StackFromSLL stack;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Stack Implementation From Singly Linked List *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Stack");
    	System.out.println("* 2. Push Data");
		System.out.println("* 3. Pop Data");
		System.out.println("* 4. Peek Data");
		System.out.println("* 5. Delete Stack");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createStack();
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
	    		deleteStack();
	    	break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createStack() throws IOException {
        System.out.println("\t*** Create a Stack ***");
        if(stack != null) {
        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
        int data = getDataInput();
        stack = new StackFromSLL(data);
    	System.out.println("\tSuccessfully Created Stack!!");
    }
    
    private static void push() throws IOException {
        System.out.println("\t*** Push Data to Stack ***");
        if(stack == null) {
        	System.out.println("No Stack Exists!!");
    		return;
        }
    	int data = getDataInput();
        stack.push(data);
    }
    
    private static void pop() throws IOException {
        System.out.println("\t*** Pop Data from Stack ***");
        if(stack == null) {
        	System.out.println("No Stack Exists!!");
    		return;
        }
        stack.pop();
    }
    
    private static void peek() throws IOException {
        System.out.println("\t*** Peek Data from Stack ***");
        if(stack == null) {
        	System.out.println("No Stack Exists!!");
    		return;
        }
        stack.peek();
    }
    
    private static void deleteStack() throws IOException {
        System.out.println("\t*** Delete the Stack ***");
        if(stack == null) {
        	System.out.println("No Stack Exists!!");
    		return;
        }
        stack = null;
    	System.out.println("\tSuccessfully Deleted Stack!!");
    }

    private static int getDataInput() throws IOException {
        System.out.print("Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
