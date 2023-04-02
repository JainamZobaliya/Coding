package LinkedList;

import java.io.*;

import LinkedList.CircularSinglyLinkedList.Node;

/**
 * CircularSinglyLinkedList
 * Problem Statement: To create and perform operations on Circular Singly Linked List.
 * Operations:
 * 1. Create a Circular Singly Linked List                  ... TC: O(1), SC: O(1)
 * 2. Insert Node at the Beginning                          ... TC: O(n), SC: O(1)
 * 3. Insert Node at the End                                ... TC: O(n), SC: O(1)
 * 4. Insert Node at a position                             ... TC: O(n), SC: O(1)
 * 5. Delete Node from the Beginning                        ... TC: O(n), SC: O(1)
 * 6. Delete Node from the End                              ... TC: O(n), SC: O(1)
 * 7. Delete Node from a position                           ... TC: O(n), SC: O(1)
 * 8. Delete entire Linked List                             ... TC: O(1), SC: O(1)
 * 9. Search a Node in Circular Singly Linked List          ... TC: O(n), SC: O(1)
 * 10. View Circular Singly Linked List                     ... TC: O(n), SC: O(1)
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CircularSinglyLinkedList {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	Node head;
	static CircularSinglyLinkedList cll;
	
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
    	System.out.println("\n\t***** Circular Singly Linked List *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Circular Singly Linked List");
    	System.out.println("* 2. Insert Node at the Beginning");
		System.out.println("* 3. Insert Node at the End");
		System.out.println("* 4. Insert Node at a position");
		System.out.println("* 5. Delete Node from the Beginning");
		System.out.println("* 6. Delete Node from the End");
		System.out.println("* 7. Delete Node from a position");
		System.out.println("* 8. Delete Circular Singly Linked List");
		System.out.println("* 9. Search a Node in Circular Singly Linked List");
		System.out.println("* 10. View Circular Singly Linked List");
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
	    		insertAtBeginning(data[0]);
	    	}
	    	break;
	    	case 3: {
	        	int[] data = getInput(false, true);
	    		insertAtEnd(data[0]);
	    	}
	    	break;
	    	case 4: {
	        	int[] data = getInput(true, true);
	    		insertAtPosition(data[0], data[1]);
	    	}
	    	break;
	    	case 5: 
	    		deleteFromBeginning();
	    	break;
	    	case 6: 
	    		deleteFromEnd();
	    	break;
	    	case 7: { 
	        	int[] data = getInput(true, false);
	    		deleteFromPosition(data[1]);
	    	}
	    	break;
	    	case 8:
	    		deleteCLL();
			break;
	    	case 9:
	    		searchCLL();
			break;
	    	case 10:
	    		viewCLL();
			break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createCLL(int data) throws IOException {
        System.out.println("\t*** Create a Circular Singly Linked List ***");
        if(cll != null) {
        	System.out.print("\tDo you want to overwrite existing cll? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
    	Node node = new Node(data);
        cll = new CircularSinglyLinkedList();
        cll.head = node;
    	System.out.println("\tSuccessfully Created Circular Singly Linked List!!");
    }
    
    private static void viewCLL() throws IOException {
        System.out.println("\t*** View the Circular Singly Linked List ***");
        if(cll == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
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
        }
    	System.out.print(node.data);  // Last Node
    	System.out.println(" --> " + head.data);
    }
    
    private static void searchCLL() throws IOException {
        System.out.println("\t*** Search a Node in the Circular Singly Linked List ***");
        if(cll == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = cll.head;
    	Node head = cll.head;
    	if(node == null) {
    		System.out.println("cll is Empty");
    		return;
    	}
    	System.out.print("\tEnter the data to be searched: ");
    	int key = Integer.parseInt(read.readLine());
    	int position = 1;
    	if(node.data == key) {
    		System.out.println("\t"+key+" is present at position "+position);
    		return;
    	}
    	node = node.next;
        while(node!=head) {
        	++position;
        	if(node.data == key) {
        		System.out.println("\t"+key+" is present at position "+position);
        		return;
        	}
        	node = node.next;
        }
        System.out.println("\t"+key+" not found in cll!!");
    }
    
    private static void deleteCLL() throws IOException {
        System.out.println("\t*** Delete a Circular Singly Linked List ***");
        if(cll == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
        	return;
        }
        cll = null;
    	System.out.println("\tSuccessfully Deleted Circular Singly Linked List!!");
    }
    
    private static void insertAtBeginning(int data) throws IOException {
        System.out.println("\t*** Insert the Node at the Beginning ***");
        if(cll == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
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
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
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
    
    private static void insertAtPosition(int data, int pos) throws IOException {
        System.out.println("\t*** Insert the Node at a Position ***");
        if(cll == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node newNode = new Node(data);
        Node node = cll.head;
        Node head = cll.head;
    	if(pos==1 || cll.head == null) {
    		insertAtBeginning(data);
    		return;
    	}
    	int counter = 2;
        while(node.next!=head && counter != pos) {
        	node = node.next;
        	counter++;
        }
        if(node.next == null && counter<pos) {
        	System.out.println("\tInserting Node at the end as given position is less than cll size!!");
        }
    	if(counter <= pos) {
    		newNode.next = node.next;
    		node.next = newNode;
        	System.out.println("\tSuccessfully Inserted Node!!");
    	}
    }
    
    private static void deleteFromBeginning() throws IOException {
        System.out.println("\t*** Delete the Node from the Beginning ***");
        if(cll == null || cll.head == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present!! ");
        	return;
        }
		Node node = cll.head;
		Node head = cll.head;
    	if(node.next == head) { // Only Head Node
    		cll.head = null;
    	}
    	else {
    		Node secondNode = node.next;
    		while(node.next != head) { // Traverse till Last Node
    			node = node.next;
    		}
    		node.next = secondNode; // Last Node's Next to the second node
    		cll.head = secondNode; // Changing Head to second node
    	}
    	System.out.println("\tSuccessfully Deleted Node from the Beginning!!");
    }
    
    private static void deleteFromEnd() throws IOException {
        System.out.println("\t*** Delete the Node from the End ***");
        if(cll == null || cll.head == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present.!! ");
        	return;
        }
		Node node = cll.head;
		Node head = cll.head;
		Node prev = null;
    	if(node.next == head) { // Only Head Node
    		cll.head = null;
    	}
    	else {
    		while(node.next != head) { // Traverse till Last Node
    			prev = node;
    			node = node.next;
    		}
    		prev.next = head;
    	}
    	System.out.println("\tSuccessfully Deleted Node from the End!!");
    }
    
    private static void deleteFromPosition(int pos) throws IOException {
        System.out.println("\t*** Delete the Node from a Position ***");
        if(cll == null || cll.head == null) {
        	System.out.println("\tThere is No Circular Singly Linked List present. Create that First!! ");
        	return;
        }
    	if(pos==1) {
    		deleteFromBeginning();
    		return;
    	}
    	int counter = 1;
        Node head = cll.head;
        Node node = cll.head;
        Node previous = null;
        while(node.next!=head && counter < pos) {
        	previous = node;
        	node = node.next;
        	counter++;
        }
        if(node.next == null && counter<pos) {
        	System.out.println("\tDeleteing Node at the end as given position is less than cll size!!");
        }
    	if(counter <= pos) {
    		previous.next = node.next; // Thus node-Node is deleted
        	System.out.println("\tSuccessfully Deleted Node!!");
    	}
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
