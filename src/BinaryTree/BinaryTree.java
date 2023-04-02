package BinaryTree;

import java.io.*;

/**
 * BinaryTree
 * Problem Statement: To create and perform operations on Binary Tree.
 * Operations:
 * 1. Create a Binary Tree
 * 2. Insert Node at the Beginning
 * 3. Insert Node at the End
 * 4. Insert Node at a position
 * 5. Delete Node from the Beginning
 * 6. Delete Node from the End
 * 7. Delete Node from a position
 * 8. Delete entire Linked List
 * 9. Search a Node in Binary Tree
 * 10. View Binary Tree
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class BinaryTree {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	static Node root;
	// static BinaryTree bTree;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Binary Tree *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Binary Tree");
    	System.out.println("* 2. Insert Node as the Right Child");
    	System.out.println("* 3. Insert Node as the Left Child");
		System.out.println("* 4. Delete Right Child Node");
		System.out.println("* 5. Delete Left Child Node");
		System.out.println("* 6. Delete Binary Tree");
		System.out.println("* 7. Search a Node in Binary Tree");
		System.out.println("* 8. View Binary Tree");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: {
	    		root = createBinaryTree(root);
	    	}
	    	break;
	    	case 2: {
	        	int data = getInput();
	    		insertRightChild(data);
	    	}
	    	break;
	    	case 3: {
	        	int data = getInput();
	    		insertLeftChild(data);
	    	}
	    	break;
	    	case 4: 
	    		deleteRightChild();
	    	break;
	    	case 5: 
	    		deleteLeftChild();
	    	break;
	    	case 6: 
	    		deleteBinaryTree();
	    	break;
	    	case 7:
	    		searchBinaryTree();
			break;
	    	case 8:
	    		viewBinaryTree();
			break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static Node createBinaryTree(Node root) throws IOException {
        System.out.println("\t*** Create a Binary Tree ***");
        if(root != null) {
        	System.out.print("\tDo you want to overwrite existing Binary Tree? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return root;
        }
        System.out.print("\tEnter data: ");
    	int data = getInput();
    	if(data == -1)
    		return null;
    	root = new Node(data);
    	System.out.print("\tEnter data for inserting in left of "+data+": ");
    	root.left = createBinaryTree(root.left); 
    	System.out.print("\tEnter data for inserting in right of "+data+": ");
    	root.right = createBinaryTree(root.right); 
    	return root;
    }
    
    private static void levelOrderTraversal() {
        System.out.println("\t*** View the Binary Tree ***");
        if(root == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = root;
    	System.out.print("\tLevel Order Traversal: ");
    	if(node == null)
    		System.out.println("Empty");
    }
    
    private static void reverseLevelOrderTraversal() {
        System.out.println("\t*** View the Binary Tree ***");
        if(root == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = root;
    	System.out.print("\tReverse Level Order Traversal: ");
    	if(node == null)
    		System.out.println("Empty");
    }
    
    private static void inOrderTraversal() {
        System.out.println("\t*** View the Binary Tree ***");
        if(root == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = root;
    	System.out.print("\tIn Order Traversal: ");
    	if(node == null)
    		System.out.println("Empty");
    }
    
    private static void preOrderTraversal() {
        System.out.println("\t*** View the Binary Tree ***");
        if(root == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = root;
    	System.out.print("\tPre Order Traversal: ");
    	if(node == null)
    		System.out.println("Empty");
    }
    
    private static void postOrderTraversal() {
        System.out.println("\t*** View the Binary Tree ***");
        if(root == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = root;
    	System.out.print("\tPost Order Traversal: ");
    	if(node == null)
    		System.out.println("Empty");
    }
    
    private static void searchBinaryTree() throws IOException {
        System.out.println("\t*** Search a Node in the Binary Tree ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node node = bTree.root;
    	System.out.print("\tEnter the data to be searched: ");
    	int key = Integer.parseInt(read.readLine());
    	if(node == null)
    		System.out.println("Binary Tree is Empty");
    	if(node.data == key)
    		System.out.println("\t"+key+" is present.");
        while(node!=null) {
        	if(node.data == key) {
        		System.out.println("\t"+key+" is present.");
        		return;
        	}
        	node = node.right;
        }
    	node = bTree.root;
        while(node!=null) {
        	if(node.data == key) {
        		System.out.println("\t"+key+" is present.");
        		return;
        	}
        	node = node.left;
        }
        System.out.println("\t"+key+" not found in Binary Tree!!");
    }
    
    private static void deleteBinaryTree() throws IOException {
        System.out.println("\t*** Delete a Binary Tree ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
        if(bTree.root == null) {
        	System.out.println("\tBinary Tree is Empty!! ");
        	return;
        }
        while(bTree.root.left!=null)
        	deleteLeftChild();
        while(bTree.root.right!=null)
        	deleteRightChild();
        bTree = null;
    	System.out.println("\tSuccessfully Deleted Binary Tree!!");
    }
    
    private static void insertRightChild(int data) throws IOException {
        System.out.println("\t*** Insert Node as the Right Child ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node newNode = new Node(data);
        if(bTree.root == null) {
        	bTree.root = newNode;
        	System.out.println("\tThere is no Binary Tree. Thus, Node root is created!! ");
        	return;
        }
        Node node = bTree.root;
        while(node.right!=null) {
        	node = node.right;
        }
        node.right = newNode;
    	System.out.println("\tSuccessfully Inserted Node as the Right Child!!");
    }
    
    private static void insertLeftChild(int data) throws IOException {
        System.out.println("\t*** Insert Node as the Left Child ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present. Create that First!! ");
        	return;
        }
    	Node newNode = new Node(data);
        if(bTree.root == null) {
        	bTree.root = newNode;
        	System.out.println("\tThere is no Root Node of Binary Tree. Thus, Node root is created!! ");
        	return;
        }
        Node node = bTree.root;
        while(node.left!=null) {
        	node = node.left;
        }
        node.left = newNode;
    	System.out.println("\tSuccessfully Inserted Node as the Left Child!!");
    }
    
    private static void deleteRightChild() throws IOException {
        System.out.println("\t*** Delete the Right Child Node ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present!! ");
        	return;
        }
    	if(bTree.root == null) {
        	System.out.println("\tBinaryTree is Empty!! ");
    	}
    	if(bTree.root.right == null) {
        	System.out.println("\tRoot of BinaryTree has no Right Child!! ");
    	}
    	else {
            Node node = bTree.root;
    		while(node.right!=null) {
    			node = node.right;
    		}
    		node = null;
        	System.out.println("\tSuccessfully Deleted the Right Child Node!!");
    	}
    }
    
    private static void deleteLeftChild() throws IOException {
        System.out.println("\t*** Delete the Left Child Node ***");
        if(bTree == null) {
        	System.out.println("\tThere is No Binary Tree present!! ");
        	return;
        }
    	if(bTree.root == null) {
        	System.out.println("\tBinaryTree is Empty!! ");
    	}
    	if(bTree.root.left == null) {
        	System.out.println("\tRoot of BinaryTree has no Left Child!! ");
    	}
    	else {
            Node node = bTree.root;
    		while(node.left!=null) {
    			node = node.left;
    		}
    		node = null;
        	System.out.println("\tSuccessfully Deleted the Left Child Node!!");
    	}
    }

    private static int getInput() throws IOException {
        int nodeData = -1;
        System.out.print("Enter data: ");
        int data = Integer.parseInt(read.readLine());
        nodeData = data;
        return nodeData;
    }
    
}
