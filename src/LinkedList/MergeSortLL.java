package LinkedList;

import java.io.*;

import LinkedList.CheckPalindrome.Node;

/**
 * MergeSortLL
 * Problem Statement: To sort Singly Linked List using Merge Sort Algorithm.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 5 3 2 1 4
 * 			Output: 1 2 3 4 5
 * 		Test Case : 
 * 			Input: 2 5 6 4 3 6
 * 			Output: 2 3 4 5 6 6
 */

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */

public class MergeSortLL {
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
 
 	public static Node SortAndMerge(Node list1, Node list2) { // sorting and merging two linked list
 		// Base cases
 		if (list1 == null)
 			return list2;
 		else if (list2 == null)
 			return list1;

 		Node result;
 		if (list1.data <= list2.data) {
 			result = list1;
 			result.next = SortAndMerge(list1.next, list2);
 		}
 		else {
 			result = list2;
 			result.next = SortAndMerge(list1, list2.next);
 		}

 		return result;
 	}

 	public static Node getMid(Node head) { // TC: O(N)
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

 	public static Node mergeSort(Node head) { // Sorting linked list using merge sort
 		// Base case
 		if (head == null || head.next == null) {
 			return head;
 		}
        // Splitting LL in 2 halves
 		Node mid = getMid(head);
 		Node first_half = head;
 		Node second_half = mid.next;
 		mid.next = null;
 		// Recursive Relation
 		first_half = mergeSort(first_half);
 		second_half = mergeSort(second_half);

 		// merge the two sorted list into single list.
 		return SortAndMerge(first_half, second_half);
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
