package LinkedList;

import java.io.*;

/**
 * RemoveDuplicates
 * Problem Statement: To remove duplicates from the given Singly Linked List.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 1 2 2 3 3 4 5
 * 			Output: 1 2 3 4 5
 * 		Test Case : 
 * 			Input: 2 3 4 5 4 5 6 5 5 6 3
 * 			Output: 2 3 4 5 6
 */

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */

public class RemoveDuplicates {
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
    	head = mergeSort(head);
    	System.out.print("Sorted Linked List is: ");
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
    
 	public static Node SortedMerge(Node list1, Node list2) { // merging two linked list
 		// Base cases
 		if (list1 == null)
 			return list2;
 		else if (list2 == null)
 			return list1;

 		Node result;
 		if (list1.data <= list2.data) {
 			result = list1;
 			result.next = SortedMerge(list1.next, list2);
 		}
 		else {
 			result = list2;
 			result.next = SortedMerge(list1, list2.next);
 		}

 		return result;
 	}

 	public static Node[] splitLL(Node ptr) { // splitting list into two halves
 		// base case
 		if (ptr == null || ptr.next == null) {
 			return new Node[]{ ptr, null };
 		}
 		Node slow = ptr;
 		Node fast = ptr.next;
 		// fast moves twice and slow moves once
 		while (fast != null) {
 			fast = fast.next;
 			if (fast != null) {
 				slow = slow.next;
 				fast = fast.next;
 			}
 		}
         // splitting the linked list
 		Node[] arr = new Node[]{ ptr, slow.next };
 		slow.next = null;
 		return arr;
 	}

 	public static Node mergeSort(Node head) { // Sorting linked list using merge sort
 		// Base case
 		if (head == null || head.next == null) {
 			return head;
 		}
        
 		Node[] heads = splitLL(head);
 		Node first_half = heads[0];
 		Node second_half = heads[1];
 		// Recursive Relation
 		first_half = mergeSort(first_half);
 		second_half = mergeSort(second_half);

 		// merge the two sorted list into single list.
 		return SortedMerge(first_half, second_half);
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
