package LinkedList;

import java.io.*;

/**
 * Sort012
 * Problem Statement: To sort 0's, 1's and 2's in the given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 2 1 0 0 1 2 1
 * 			Output: 0 0 1 1 1 2 2
 * 		Test Case : 
 * 			Input: 1 1 2 0 2 2
 * 			Output: 0 1 1 2 2 2
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Sort012 {
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
    	head = sort(head);
    	System.out.print("Sorted Linked List is: ");
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

 	private static Node sort(Node head) { 
 		// Base case
 		if (head == null || head.next == null) {
 			return head;
 		}
 		Node zeroHead = null;
 		Node zeroTail = null;
 		Node oneHead = null;
 		Node oneTail = null;
 		Node twoHead = null;
 		Node twoTail = null;
 		Node node = head;
 		while(node != null) {
 			if(node.data==0) {
 				if(zeroTail == null) {
 					zeroHead = node;
 					zeroTail = zeroHead;
 				}
 				else {
 					zeroTail.next = node;
 					zeroTail = zeroTail.next;
 				}
				node = node.next;
				zeroTail.next = null;
 			}
 			else if(node.data==1) {
 				if(oneTail == null) {
 					oneHead = node;
 					oneTail = oneHead;
 				}
 				else {
 					oneTail.next = node;
 					oneTail = oneTail.next;
 				}
				node = node.next;
				oneTail.next = null;
 			}
 			else if(node.data==2) {
 				if(twoTail == null) {
 					twoHead = node;
 					twoTail = twoHead;
 				}
 				else {
 					twoTail.next = node;
 					twoTail = twoTail.next;
 				}
				node = node.next;
				twoTail.next = null;
 			}
 		} 		
 		// Connecting 0's, 1's and 2's LL
 		if(zeroTail!=null && oneHead!=null) {
 			zeroTail.next = oneHead;
 		}	
 		else if(zeroTail!=null && twoHead!=null) { // i.e No 1's in LL
 			zeroTail.next = twoHead;
 		}
 		if(oneTail!=null && twoHead!=null) {
 			oneTail.next = twoHead;
 		}
 		if(zeroHead!=null) {
 			head = zeroHead;
 		}
 		else if(oneHead!=null) { // i.e No 0's in LL
 			head = oneHead;
 		}
 		else if(twoHead!=null) { // i.e No 0's and 1's in LL
 			head = twoHead;
 		}
 		return head;        
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
