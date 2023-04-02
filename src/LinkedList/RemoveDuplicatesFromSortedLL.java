package LinkedList;

import java.io.*;

/**
 * RemoveDuplicatesFromSortedLL
 * Problem Statement: To remove duplicates from the given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 2 3 3 4 5
 * 			Output: 1 2 3 4 5
 * 		Test Case : 
 * 			Input: 2 3 3 4 4 5 5 5 5 6
 * 			Output: 2 3 4 5 6
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RemoveDuplicatesFromSortedLL {
    static Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

    public static void main(String[] args) throws IOException  {
        takeInput();
    	System.out.print("Linked List is: ");
    	printSLL(head);
    	removeDuplicates(head);
    	System.out.print("Reversed Linked List is: ");
    	printSLL(head);
    }

    public static void takeInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        int size = -1;
        do{
            try{
                System.out.print("Enter size of SLL: ");
                size = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(size<=0); 
        System.out.print("Enter elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing LL
        for(int j=0; j<size; ++j) {
            int data = Integer.parseInt(arrInput[j]);
            insertFromEnd(data);
        }
    }
    
    private static void insertFromEnd(int data) {
    	Node newNode = new Node(data);
    	Node node = head;
    	if(node == null) {
    		head = newNode;
    		return;
    	}
    	while(node.next != null)
    		node = node.next;
    	node.next = newNode;    	
    }
    
    private static void removeDuplicates(Node head) {
    	Node curr = head;
    	while(curr!=null && curr.next!=null) {
    		if(curr.data==curr.next.data) 
    			curr.next = curr.next.next;
    		else
    			curr = curr.next;
    	}
    }
    
    private static void printSLL(Node node) {
    	if(node==null) {
    		System.out.println("Empty SLL");
    	}
    	while(node.next!=null) {
    		System.out.print(node.data);
    		if(node.next!=null)
        		System.out.print(" -> ");
    		node = node.next;
    	}
    	System.out.println(node.data);
    }
    
}
