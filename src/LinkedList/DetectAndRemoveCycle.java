package LinkedList;

import java.io.*;

import LinkedList.CircularSinglyLinkedList.Node;

/**
 * DetectAndRemoveCycle
 * Problem Statement: To Detect And Remove Cycle from Singly Linked List.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class DetectAndRemoveCycle {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	Node head;
	static DetectAndRemoveCycle cll;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = this;
		}
	}

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Singly Linked List *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Singly Linked List");
		System.out.println("* 2. Insert Node at the End");
		System.out.println("* 3. View Singly Linked List");
		System.out.println("* 4. Detect Cycle in Linked List");
		System.out.println("* 5. Detect Starting Point of Cycle in Linked List");
		System.out.println("* 6. Remove Cycle in Linked List");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: {
	        	int[] data = getInput(false, true);
	    		createCLL(data[0]);
	    	}
	    	break;
	    	case 2: {
	        	int[] data = getInput(false, true);
	    		insertAtEnd(data[0]);
	    	}
	    	break;
	    	case 3:
	    		viewCLL();
			break;
	    	case 4: {
	    		Node detector = detectCycle();
	    		if(detector == null) {
	    			System.out.println("\t Loop is not present!!");
	    		}
	    		else {
	    			System.out.println("\t Loop is present!!");
	    		}
	    	}
			break;
	    	case 5: {
	    		Node start = detectStartOfCycle();
	    		if(start == null) {
	    			System.out.println("\t Loop is not present!!");
	    		}
	    		else {
	    			System.out.println("\t Loop start's from "+start.data+"!!");
	    		}
	    	}
			break;
	    	case 6:
	    		removeCycle();
			break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createCLL(int data) throws IOException {
        System.out.println("\t*** Create a Singly Linked List ***");
        if(cll != null) {
        	System.out.print("\tDo you want to overwrite existing cll? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
    	Node node = new Node(data);
        cll = new DetectAndRemoveCycle();
        cll.head = node;
    	System.out.println("\tSuccessfully Created Singly Linked List!!");
    }
    
    private static void viewCLL() throws IOException {
        System.out.println("\t*** View the Linked List ***");
        if(cll == null) {
        	System.out.println("\tThere is No Linked List present. Create that First!! ");
        	return;
        }
    	Node node = cll.head;
    	Node head = cll.head;
    	System.out.print("\tYour cll: ");
    	if(node == null) {
    		System.out.println("Empty");
    		return;
    	}
        while(node.next!=head) {
        	System.out.print(node.data + " --> ");
        	node = node.next;
        	if(node == null) {
            	System.out.println("Null");
            	return;
        	}
        }
    	System.out.print(node.data);  // Last Node
    	System.out.println(" --> " + head.data);
    }
    
    private static void insertAtBeginning(int data) throws IOException {
        System.out.println("\t*** Insert the Node at the Beginning ***");
        if(cll == null) {
        	System.out.println("\tThere is No Linked List present. Create that First!! ");
        	return;
        }
    	Node newNode = new Node(data);
        if(cll.head == null) {
        	cll.head = newNode;
        	return;
        }
    	Node head = cll.head;
    	Node node = cll.head;
		newNode.next = head;
    	if(node.next == head) { // i.e. There was only one Node in CLL
    		node.next = newNode;
    	}
    	else {
    		while(node.next!=head) { // Traverse till Last Node
    			node = node.next;
    		}
    		node.next = newNode;  // Changing next of last Node in CLL
    	}
		cll.head = newNode;
    	System.out.println("\tSuccessfully Inserted Node at the Beginning!!");
    }
    
    private static void insertAtEnd(int data) throws IOException {
        System.out.println("\t*** Insert the Node at the End ***");
        if(cll == null) {
        	System.out.println("\tThere is No Linked List present. Create that First!! ");
        	return;
        }
        if(cll.head == null) {
        	insertAtBeginning(data);
        	return;
        }
    	Node newNode = new Node(data);
    	Node head = cll.head;
    	Node node = cll.head;
		newNode.next = head;
    	if(node.next == head) { // i.e. There was only one Node in CLL
    		node.next = newNode;
    	}
    	else {
    		while(node.next!=head) { // Traverse till Last Node
    			node = node.next;
    		}
    		node.next = newNode;  // Changing next of last Node in CLL
    	}
    	System.out.println("\tSuccessfully Inserted Node at the End!!");
    }
    
    private static Node detectCycle() {
    	if(cll == null || cll.head == null) {
        	return null;
    	}
    	Node slow = cll.head;
    	Node fast = cll.head;
    	while(fast!=null && fast.next!=null) { // Traversing the LL
    		slow = slow.next;
    		fast = fast.next;
    		if(fast!=null)
    			fast = fast.next;
        	if(slow==fast)  // Cycle / Loop is Present
        		return slow;
    	}
    	if(fast == null || fast.next == null) { // No Cycle / Loop Present
    		return null;    	
    	}
    	return null;  // No Cycle / Loop Present
    }
    
    private static Node detectStartOfCycle() {
    	Node detector = detectCycle();
    	if(detector == null) { // No Cycle / Loop Present
    		return null;
    	}
    	Node fast = detector;
    	Node slow = cll.head;
    	while(slow!=fast) { // Traversing the LL
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return slow; // Returning the starting point of Cycle / Loop
    }
    
    private static void removeCycle() {
    	Node start = detectStartOfCycle();
    	if(start == null) { // No Operation to be performed
    		return;
    	}
    	Node node = start.next;
    	while(node.next!=start) {
    		node = node.next;
    	}
    	node.next = null;
    }

    private static int[] getInput(boolean getPosition, boolean insertion) throws IOException {
        int[] nodeData = {-1, -1};
    	if(insertion) {
	        System.out.print("Enter data: ");
	        int data = Integer.parseInt(read.readLine());
	        nodeData[0] = data;
    	}
        if(getPosition) {
            System.out.print(insertion ? 
            		"Enter position where the node is to be inserted: " 
            		: "Enter position of the node which is to be deleted: ");
            int position = Integer.parseInt(read.readLine());
	        nodeData[1] = position;
        }
        return nodeData;
    }
    
}
