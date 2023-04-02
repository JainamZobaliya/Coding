package LinkedList;

import java.io.*;

/**
 * MiddleSLL
 * Problem Statement: To return the middle element of given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 3
 * 		Test Case : 
 * 			Input: 2 4 6 8 10 12
 * 			Output: 8
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MiddleSLL {
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
    	head.next.next.next.next = new Node(9);
    	System.out.print("Linked List is: ");
    	printSLL(head);
    	Node mid = findMiddle(head);
    	System.out.println("Middle Node is: " + mid.data);
    	Node mid2 = findMiddle2(head);
    	System.out.print("Middle Node is: " + mid2.data);
    }
    
    private static Node findMiddle(Node head) { // TC: O(N)
        Node node = head;
        if(node == null)
            return node;
        int count = 0;
        while(node.next!=null) {
            node = node.next;
            ++count;
        }
        int mid = (int) Math.ceil((float) count / 2);
        node = head;
        Node temp = null;
        count = 0;
        while(node.next!=null && count<=mid) {
            temp = node;
            node = node.next;
            ++count;
        }
        return temp;
    }
    
    private static Node findMiddle2(Node head) { // TC: O(N)
        if(head == null || head.next == null) // 0 or 1 Node
            return head;
        if(head.next.next == null) // 2 Nodes
            return head.next;
        // More than 2 nodes
        Node slow = head;
        Node fast = head.next;
        while(fast!=null) {
        	slow = slow.next;
        	fast = fast.next;
        	if(fast!=null)
        		fast = fast.next;
        }
        return slow;
    }
    
    private static void printSLL(Node node) {
    	while(node.next!=null) {
    		System.out.print(node.data);
    		if(node.next!=null)
        		System.out.print(" -> ");
    		node = node.next;
    	}
    	System.out.println(node.data);
    }
    
}
