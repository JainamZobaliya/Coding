package LinkedList;

import java.io.*;

/**
 * SinglyLinkedList
 * Problem Statement: To create and perform operations on Singly Linked List.
 * Operations:
 * 1. Create a Singly Linked List
 * 2. Insert Node at the Beginning
 * 3. Insert Node at the End
 * 4. Insert Node at a position
 * 5. Delete Node from the Beginning
 * 6. Delete Node from the End
 * 7. Delete Node from a position
 * 8. Delete entire Linked List
 * 9. Search a Node in Singly Linked List
 * 10. View Singly Linked List
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SinglyLinkedList {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	Node head;
	static SinglyLinkedList sll;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
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
    	System.out.println("* 2. Insert Node at the Beginning");
		System.out.println("* 3. Insert Node at the End");
		System.out.println("* 4. Insert Node at a position");
		System.out.println("* 5. Delete Node from the Beginning");
		System.out.println("* 6. Delete Node from the End");
		System.out.println("* 7. Delete Node from a position");
		System.out.println("* 8. Delete Singly Linked List");
		System.out.println("* 9. Search a Node in Singly Linked List");
		System.out.println("* 10. View Singly Linked List");
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
	    		createSLL(data[0]);
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
	    		deleteSLL();
			break;
	    	case 9:
	    		searchSLL();
			break;
	    	case 10:
	    		viewSLL();
			break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createSLL(int data) throws IOException {
        System.out.println("\t*** Create a Singly Linked List ***");
        if(sll != null) {
        	System.out.print("\tDo you want to overwrite existing SLL? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
    	Node node = new Node(data);
        sll = new SinglyLinkedList();
        sll.head = node;
    	System.out.println("\tSuccessfully Created Singly Linked List!!");
    }
    
    private static void viewSLL() throws IOException {
        System.out.println("\t*** View the Singly Linked List ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = sll.head;
    	System.out.print("\tYour SLL: ");
    	if(node == null)
    		System.out.println("Empty");
        while(node!=null) {
        	System.out.print(node.data);
        	if(node.next != null)
            	System.out.print(" -> ");
        	node = node.next;
        }
    }
    
    private static void searchSLL() throws IOException {
        System.out.println("\t*** Search a Node in the Singly Linked List ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = sll.head;
    	System.out.print("\tEnter the data to be searched: ");
    	int key = Integer.parseInt(read.readLine());
    	if(node == null)
    		System.out.println("Sll is Empty");
    	int position = 1;
        while(node!=null) {
        	if(node.data == key) {
        		System.out.println("\t"+key+" is present at position "+position);
        		return;
        	}
        	++position;
        	node = node.next;
        }
        System.out.println("\t"+key+" not found in SLL!!");
    }
    
    private static void deleteSLL() throws IOException {
        System.out.println("\t*** Delete a Singly Linked List ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
        sll = null;
    	System.out.println("\tSuccessfully Deleted Singly Linked List!!");
    }
    
    private static void insertAtBeginning(int data) throws IOException {
        System.out.println("\t*** Insert the Node at the Beginning ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = new Node(data);
        node.next = sll.head;
        sll.head = node;
    	System.out.println("\tSuccessfully Inserted Node at the Beginning!!");
    }
    
    private static void insertAtEnd(int data) throws IOException {
        System.out.println("\t*** Insert the Node at the End ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = new Node(data);
        Node start = sll.head;
        while(start.next!=null)
        	start = start.next;
        start.next = node;
    	System.out.println("\tSuccessfully Inserted Node at the End!!");
    }
    
    private static void insertAtPosition(int data, int pos) throws IOException {
        System.out.println("\t*** Insert the Node at a Position ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	Node node = new Node(data);
    	int counter = 1;
    	if(pos==1) {
    		insertAtBeginning(data);
    		return;
    	}
    	counter++;
        Node start = sll.head;
        while(start.next!=null && counter != pos) {
        	start = start.next;
        	counter++;
        }
        if(start.next == null && counter<pos) {
        	System.out.println("\tInserting Node at the end as given position is less than SLL size!!");
        }
    	if(counter <= pos) {
            node.next = start.next;
            start.next = node;
        	System.out.println("\tSuccessfully Inserted Node!!");
    	}
    }
    
    private static void deleteFromBeginning() throws IOException {
        System.out.println("\t*** Delete the Node from the Beginning ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present!! ");
        	return;
        }
    	if(sll.head.next == null) {
    		sll.head = null;
    	}
    	else {
    		sll.head = sll.head.next;
    	}
    	System.out.println("\tSuccessfully Deleted Node from the Beginning!!");
    }
    
    private static void deleteFromEnd() throws IOException {
        System.out.println("\t*** Delete the Node from the End ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present.!! ");
        	return;
        }
        Node start = sll.head;
        Node prev = null;
        while(start.next!=null) {
        	prev = start;
        	start = start.next;
        }
        prev.next = null;
    	System.out.println("\tSuccessfully Deleted Node from the End!!");
    }
    
    private static void deleteFromPosition(int pos) throws IOException {
        System.out.println("\t*** Delete the Node from a Position ***");
        if(sll == null) {
        	System.out.println("\tThere is No Singly Linked List present. Create that First!! ");
        	return;
        }
    	if(pos==1) {
    		deleteFromBeginning();
    		return;
    	}
    	int counter = 1;
        Node start = sll.head;
        Node prev = null;
        while(start.next!=null && counter < pos) {
        	prev = start;
        	start = start.next;
        	counter++;
        }
        if(start.next == null && counter<pos) {
        	System.out.println("\tDeleteing Node at the end as given position is less than SLL size!!");
        }
    	if(counter <= pos) {
            prev.next = start.next; // Thus Node 'start' is deleted
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
