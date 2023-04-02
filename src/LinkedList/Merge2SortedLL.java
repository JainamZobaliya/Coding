package LinkedList;

import java.io.*;

/**
 * Merge2SortedLL
 * Problem Statement: To sort 0's, 1's and 2's in the given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input LL-1: 1 3 5
 * 			Input LL-2: 2 4 6
 * 			Output: 1 2 3 4 5 6
 * 		Test Case : 
 * 			Input LL-1: 1 3 5
 * 			Input LL-2: 0 3 6 7
 * 			Output: 0 1 3 3 5 6 7
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Merge2SortedLL {
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
    	Node head = solve(head1, head2);
    	System.out.print("Merged Linked List is: ");
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

 	private static Node solve(Node head1, Node head2) {
 		if(head1 == null) {
 			return head2;
 		}
 		if(head2 == null) {
 			return head1;
 		}
 		if(head1.data >= head2.data) {
 			return merge(head2, head1);
 		}
 		return merge(head1, head2);
 	}
 	
 	private static Node merge(Node firstLL, Node secondLL) {
 		Node curr1 = firstLL;
 		Node curr2 = secondLL;
 		Node next1 = curr1.next;
 		Node next2 = curr2;
 		if(next1 == null) {
 			curr1.next = curr2;
 			return curr1;
 		}
 		while(next1!=null && next2!=null) {
 			if(curr2.data >= curr1.data && curr2.data <=next1.data) {
 				next2 = curr2.next;
 				curr1.next = curr2;
 				curr2.next = next1;
 				curr1 = curr2;
 				curr2 = next2;
 			}
 			else {
 				curr1 = next1;
 				next1 = next1.next;
 				if(next1 == null) {
 					curr1.next = curr2;
 					return firstLL;
 				}
 			}
 		}
		return firstLL;
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
