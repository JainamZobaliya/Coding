package LinkedList;

import java.io.*;

/**
 * AddNumbers
 * Problem Statement: To add 2 numbers given in 2 Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input LL-1: 1 3 5
 * 			Input LL-2: 2 4 6
 * 			Output: 3 8 1
 * 		Test Case : 
 * 			Input LL-1: 1 3 5
 * 			Input LL-2: 9 3 6 7
 * 			Output: 9 5 0 0 2
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class AddNumbers {
    static Node head1, head2;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

    public static void main(String[] args) throws IOException  {
        head1 = takeInput(head1);
        head2 = takeInput(head2);
    	System.out.print("Linked List-1 is: ");
    	printSLL(head1);
    	System.out.print("Linked List-2 is: ");
    	printSLL(head2);
    	Node head = addLL(head1, head2);
    	System.out.print("Adding 2 List: ");
    	printSLL(head);
    }

    public static Node takeInput(Node head) throws IOException  {
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
            head = insertFromEnd(head, data);
        }
        return head;
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

 	private static Node addLL(Node head1, Node head2) {
 		head1 = reverseSLL(head1);
 		head2 = reverseSLL(head2);
 		if(head1 == null) {
 			return head2;
 		}
 		if(head2 == null) {
 			return head1;
 		}
 		Node node1 = head1;
 		Node node2 = head2;
 		Node head = null;
 		Node node = head;
 		int carry = 0;
 		while(node1 != null && node2 != null) {
 			int data = carry + node1.data + node2.data;
 			carry = data / 10;
 			data = data % 10;
 			head = insertFromEnd(head, data);
 			node1 = node1.next;
 			node2 = node2.next;
 		}
 		while(node1!=null) {
 			int data = carry + node1.data;
 			carry = data / 10;
 			data = data % 10;
 			head = insertFromEnd(head, data);
 			node1 = node1.next;
 		}
 		while(node2!=null) {
 			int data = carry + node2.data;
 			carry = data / 10;
 			data = data % 10;
 			head = insertFromEnd(head, data);
 			node2 = node2.next;
 		}
 		if(carry!=0) {
 			head = insertFromEnd(head, carry);
 		}
 		head = reverseSLL(head);
		// Now, make LL like previous!! --- OPTIONAL
 		head1 = reverseSLL(head1);
 		head2 = reverseSLL(head2);
 		return head;
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
    
    private static void printSLL(Node node) {
    	if(node==null) {
    		System.out.println("Empty SLL");
    		return;
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
