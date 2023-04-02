package LinkedList;

import java.io.*;

/**
 * ReverseSLL
 * Problem Statement: To reverse the given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 5 4 3 2 1
 * 		Test Case : 
 * 			Input: 2 4 6 8 10 12
 * 			Output: 12 10 8 6 4 2
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReverseSLL {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

    public static void main(String[] args) throws IOException  {
    	Node head = new Node(5);
    	head.next = new Node(6);
    	head.next.next = new Node(7);
    	head.next.next.next = new Node(8);
    	System.out.print("Linked List is: ");
    	printSLL(head);
    	Node reverseSLLHead = reverseSLL(head);
    	System.out.print("Reversed Linked List is: ");
    	printSLL(reverseSLLHead);
    	Node reverseSLLHead2 = reverseSLL2(null, reverseSLLHead, reverseSLLHead.next);
    	System.out.print("Again, Reversed Linked List is: ");
    	printSLL(reverseSLLHead2);
    }
    
    private static Node reverseSLL(Node node) { // Iterative Approach
    	Node prev = null;
    	Node current = node;
    	while(current!=null) {
        	Node nextNode = current.next;
    		current.next = prev;
    		prev = current;
    		current = nextNode;
    	}
    	return prev;
    }
    
    private static Node reverseSLL2(Node prev, Node current, Node head) { // Recursive Approach
    	// Base Case
    	if(current == null || head == null)
    		return prev;
    	// Processing Part
    	current.next = prev;
    	prev = current;
    	current = head;
    	head = current.next;
    	// Recursive Relation
    	return reverseSLL2(prev, current, head);
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
