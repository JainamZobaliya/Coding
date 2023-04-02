package LinkedList;

import java.io.*;

/**
 * CloneLL
 * Problem Statement: To clone the given Singly Linked List.
 * URL: https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Output: 1 2 3 4 5
 * 		Test Case : 
 * 			Input: 1 2 2
 * 			Output: 1 2 2
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CloneLL {
    static Node head;
	
	static class Node {
		int data;
		Node next, random;
		
		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

    public static void main(String[] args) throws IOException  {
        createLL();
    	System.out.println("Linked List is: ");
    	printSLL(head);
    	Node result = cloneLL(head);
    	System.out.println("Cloned List is: ");
    	printSLL(result);
    }

    public static void createLL() throws IOException {
    	Node first = new Node(1);
    	Node second = new Node(2);
    	Node third = new Node(3);
    	Node fourth = new Node(4);
    	Node fifth = new Node(5);
    	first.next = second;
    	second.next = third;
    	third.next = fourth;
    	fourth.next = fifth;
    	first.random = third;
    	second.random = first;
    	third.random = fifth;
    	fourth.random = third;
    	fifth.random = second;    	
    	head = first;
    }
    
    private static Node insertFromEnd(Node head, int data) {
    	Node newNode = new Node(data);
    	Node node = head;
    	if(node == null) {
    		head = newNode;
    		return head;
    	}
    	while(node.next != null)
    		node = node.next;
    	node.next = newNode;    
    	return head;
    }

 	private static Node cloneLL(Node head) { 
 		Node cloneHead = null;
 		Node node = head;
 		while(node!=null) {
 			cloneHead = insertFromEnd(cloneHead, node.data);
 			node = node.next;
 		}
 		node = head;
 		Node tail = head;
 		Node tail2 = cloneHead;
 		Node node2 = cloneHead;
 		while(tail!=null) {
 			node = tail;
 			tail = tail.next;
 			node.next = node2;
 			tail2 = tail2.next;
 			node2.next = tail;
 			node2 = tail2;
 		}
 		node = head;
 		node2 = cloneHead;
 		while(node2!=null) {
 			if(node!=null && node.random!=null)
 				node2.random = node.random.next;
 			node2 = node2.next;
 			node.next = node2; // Making original LL as it is
 			node = node.next;
 			if(node2!=null)
 				node2 = node2.next; // Back to clone next node
 		}
 		return cloneHead; 		
 	}
    
    private static void printSLL(Node node) {
    	if(node==null) {
    		System.out.println("Empty SLL");
    	}
    	while(node.next!=null) {
    		System.out.print(node.data);
    		if(node.random!=null) {
        		System.out.println(" -> " + node.random.data);
    		}
    		node = node.next;
    	}
    	System.out.println(node.data);
    }
    
}
