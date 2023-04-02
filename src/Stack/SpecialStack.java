package Stack;

import java.io.*;
import java.util.Stack;

/**
 * SpecialStack
 * Problem Statement: Design a stack that supports getMin() in O(1) time and O(1) extra space.
 * Operations:
 * 1. Create a Stack
 * 2. Push Data to Stack
 * 3. Pop Data from Stack
 * 4. Peek Data from Stack
 * 5. Delete Stack
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class SpecialStack {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
	static Stack<Integer> stack;
	static int min = Integer.MIN_VALUE;
	
	private static boolean push(int data) {
		if(stack==null) { // Stack Overflow
			System.out.println("\tStack Overflow!!");
			return false;
		}
		if(stack.empty()) {
			stack.push(data);
			min = data;
		}
		else if(data <= min) {
			int val = 2 * data - min;
			stack.push(val);
			min = data;
		}
		else {
			stack.push(data);
		}
		return true;
	}
	
	private static int pop() {
		if(stack.empty()) { // Stack Underflow
			System.out.println("\tStack Underflow!!");
			return -1;
		}
		int data = stack.pop();
		if(data >= min) {
			return data;
		}
		else {
			int val = min;
			data = 2*min - data;
			min = data;
			return val;
		}
	}
	
	private static int peek() {
		if(stack.empty()) { // Stack Underflow
			System.out.println("\tStack Underflow!!");
			return -1;
		}
		int data = stack.peek();
		if(data >= min) {
			return data;
		}
		else {
			int val = min;
			return val;
		}
	}
	
	private static boolean deleteStack() {
		while(!stack.empty()) {
			int data = pop();
			if(data == -1) {
				System.out.println("\tStack Underflow!!");
				return false;
			}
			System.out.println("\t\tData-"+data+" popped from Stack!!");
		}
		min = Integer.MIN_VALUE;
		System.out.println("\tStack Deleted Successfully!!");
    	return true;
	}
	
	private static boolean isEmpty() {
        if(stack==null || stack.empty())
            return true;
		return stack.isEmpty();
	}
	
	private static int getMin() {
		if(stack ==null || stack.empty())
			return -1;
		return min;
	}

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Special Stack Implementation *****");
    	if(stack!=null) {
    		System.out.println("* Stack: "+stack);
    		System.out.println("* Min: "+min);
    	}
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create Stack");
    	System.out.println("* 2. Push Data to Stack");
		System.out.println("* 3. Pop Data from Stack");
		System.out.println("* 4. Peek Data from Stack");
		System.out.println("* 5. Delete Stack");
		System.out.println("* 6. Stack isEmpty?");
		System.out.println("* 7. Get Min. From Stack");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	int data = -1;
    	boolean result = false;
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createStack();
	    	break;
	    	case 2: 
	        	data = getDataInput();
	        	result = push(data);
	        	if(result)
	        		System.out.println("\t Data-"+data+" pushed to stack successfully!!");
	    	break;
	    	case 3: 
	    		data = pop();
	        	if(data!=-1)
	        		System.out.println("\t Data-"+data+" popped from stack successfully!!");
	    	break;
	    	case 4: 
	    		data = peek();
	        	if(data!=-1)
	        		System.out.println("\t Data-"+data+" peeked from stack!!");
	    	break;
	    	case 5: 
	    		deleteStack();
    		break;
	    	case 6: 
	    		isEmpty();
    		break;
	    	case 7: 
	    		data = getMin();
	    		if(data == -1)
	    			System.out.println("\tStack is Empty!!");
	    		else 
	    			System.out.println("\tMin. Value is " + data);
    		break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createStack() throws IOException {
        System.out.println("\t*** Create a Stack ***");
        if(stack != null) {
        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
		stack = new Stack<Integer>();
    	System.out.println("\tSuccessfully Created N-Stack!!");
    }

    private static int getDataInput() throws IOException {
        System.out.print("Enter data: ");
        return Integer.parseInt(read.readLine());
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
}
