package LinkedList;

import java.io.*;

/**
 * CheckPalindrome
 * Problem Statement: To check Palindrome of given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 1
 * 			Output: Yes
 * 		Test Case : 
 * 			Input: 1 2 2
 * 			Output: No
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CheckPalindrome {
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
    	boolean result = isPlaindrome(head);
    	System.out.println(result ? "Above LL is Palindrome!!" : "Above LL is not Palindrome!!");
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

 	private static boolean isPlaindrome(Node head) { 
 		// Base case
 		if (head == null || head.next == null) {
 			return true;
 		}
 		boolean result = false;
 		Node head1 = head;
 		Node mid = getMid(head);
 		Node head2 = mid.next;
 		mid.next = null;
 		head2 = reverseSLL(head2);
 		Node node1 = head1;
 		Node node2 = head2;
 		while(node1 != null && node2 != null) {
 			if(node1.data == node2.data) {
 				result = true;
 			}
 			else {
 				result = false;
 				break;
 			}
 			node1 = node1.next;
 			node2 = node2.next;
 		}
 		// Now, make LL like previous!! --- OPTIONAL
 		head2 = reverseSLL(head2);
 		mid.next = head2;
 		return result; 		
 	}
    
    private static Node getMid(Node head) { // TC: O(N)
        if(head == null || head.next == null || head.next.next == null) // 0, 1 or 2 Node
            return head;
        // More than 2 nodes
        Node slow = head;
        Node fast = head.next;
        while(fast !=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next;
        	if(fast!=null)
        		fast = fast.next;
        }
        return slow;
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
