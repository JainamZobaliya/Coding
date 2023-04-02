package LinkedList;

import java.io.*;

/**
 * FlattenLL
 * Problem Statement: To flatten a given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 -> 4 -> 7 -> 9 -> 20 -> null
 *                 |    |    |    |
 *                 2    5    8    12
 *                 |    |    
 *                 3    6
 * 			Output: 1 2 3 4 5 6 7 8 9 12 20
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FlattenLL {
    static Node head;
	
	static class Node {
		int data;
		Node next, child;
		
		Node(int data) {
			this.data = data;
			this.next = null;
			this.child = null;
		}
	}

    public static void main(String[] args) throws IOException  {
        createLL();
    	System.out.println("Linked List is: ");
    	printSLL(head);
    	Node result = flatten(head);
    	System.out.println("Flatten Linked List is: ");
    	printSLL(result);
    }

    public static void createLL() throws IOException {
    	Node first = new Node(1);
    	first.child = new Node(2);
    	first.child.child = new Node(3);
    	
    	Node second = new Node(4);
    	second.child = new Node(5);
    	second.child.child = new Node(6);
    	
    	Node third = new Node(7);
    	third.child = new Node(8);
    	
    	Node fourth = new Node(9);
    	fourth.child = new Node(12);
    	
    	Node fifth = new Node(20);
    	
    	first.next = second;
    	second.next = third;
    	third.next = fourth;
    	fourth.next = fifth;	
    	head = first;
    }

 	private static Node flatten(Node head) { 
 		if(head == null || head.next == null)
 			return head;
 		Node down = head;
 		Node right = flatten(down.next);
 		down.next = null;
 		Node result = merge(down, right);
 		return head;
 	}
 	
 	private static Node merge(Node first, Node second) {
 		Node temp = first;
 		Node child = temp.child;
 		while(child!=null) { // Linking first's child to next
 			temp.next = child;
 			child = child.child;
 			temp = temp.next;
 		}
 		temp.next = second; // Linking last node of First to Second
 		temp = first;
		while(temp!=second) { // UnLink Child Node
	 		temp.child = null;
	 		temp = temp.next;
		}
 		return first;
 	}
    
    private static void printSLL(Node node) {
    	if(node==null) {
    		System.out.println("Empty SLL");
    	}
    	while(node.next!=null) {
    		System.out.print(node.data);
    		Node child = node.child;
    		while(child!=null) {
        		System.out.print(" -> " + child.data);
        		child = child.child;
    		}
    		System.out.println();
    		node = node.next;
    	}
    	System.out.println(node.data);
    }
    
}
