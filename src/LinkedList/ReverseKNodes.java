package LinkedList;

import java.io.*;

/**
 * ReverseSLL
 * Problem Statement: To reverse the given Singly Linked List with k Nodes.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 3 4 5
 * 			Input-K: 2
 * 			Output: 2 1 4 3 5
 * 		Test Case : 
 * 			Input: 1 2 3 4 5
 * 			Input-K: 3
 * 			Output: 3 2 1 5 4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ReverseKNodes {
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
        int k = takeInput();
    	System.out.print("Linked List is: ");
    	printSLL(head);
    	Node reverseKSLLHead = reverseKSLL(head, k);
    	System.out.print("Reversed Linked List is: ");
    	printSLL(reverseKSLLHead);
    }

    public static int takeInput() throws IOException  {
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
            System.out.print("Enter value of k: ");
            return Integer.parseInt(read.readLine());
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
    
    private static Node reverseKSLL(Node head, int k) { // Recursive Approach
    	Node prev = null;
    	Node current = head;
    	Node nextNode = null;
    	int count = 0;
    	while(current!=null && count < k) {
    		nextNode = current.next;
    		current.next = prev;
    		prev = current;
    		current = nextNode;
    		count++;
    	}
    	if(nextNode!=null) { // Recursive Relation
    		head.next = reverseKSLL(nextNode, k);
    	}
    	return prev;
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
