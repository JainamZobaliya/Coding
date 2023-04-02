package Queue;

import java.io.*;
import java.util.*;

/**
 * ImplementationQueue
 * Problem Statement: To create Queue from Stack.
 * Operations:
 * 1. Create a Queue
 * 2. Push Data to Queue
 * 3. Pop Data from Queue
 * 4. Peek Data from Queue
 * 5. Delete Queue
 */

class StackQueue1 { // Approach-1: Making enQueue operation costly

/**
 * Time Complexity:
 *      Push: O(n) ... In the worst case we have to empty entire stack 1 into stack 2.
 *      Pop: O(1)
 * Space Complexity: O(n) ... Use of stack for storing values.
 */
    // Two inbuilt stack
    static Stack<Integer> s1, s2;
    
    StackQueue1() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    void enQueue(int x) {
        while (!s1.isEmpty()) {// Move all elements from s1 to s2
            s2.push(s1.pop());
        }
        s1.push(x); // Push item into s1
        while (!s2.isEmpty()) { // Push everything back to s1
            s1.push(s2.pop());
        }
    }

    int deQueue() { 
        if (s1.isEmpty()) { // if first stack is empty
            return -1;
        }
        int x = s1.peek(); // Return top of s1
        s1.pop();
        return x;
    }

    int getFront() {
        if (s1.isEmpty()) { // if first stack is empty
            return -1;
        }
        int x = s1.peek(); // Return top of s1
        return x;
    }

    boolean isEmpty() {
        return s1.size() <= 0;
    }
}

class StackQueue2 { // Approach-2: Making deQueue operation costly

/**
 * Time Complexity:
 *      Push: O(1)
 *      Pop: O(n) ... In the worst case we have to empty the whole of stack 1 into stack 2
 * Space Complexity: O(n) ... Use of stack for storing values.
 */
    // Two inbuilt stack
    static Stack<Integer> s1, s2;
    
    StackQueue2() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    void enQueue(int x) { // Push the data onto the stack
        s1.push(x);
    }

    int deQueue() { 
        int x;
        if (s1.isEmpty() && s2.isEmpty()) // If both stacks are empty then error
        	return -1;
        // Move elements from stack1 to stack 2 only if stack2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                if (s1.isEmpty()) //If stack is empty then error
                	return -1;
                else // pop the data from the stack
                	x = s1.pop();
                s2.push(x);
            }
        }
        if (s2.isEmpty())//If stack is empty then error
        	return -1;
        else // pop the data from the stack
        	x = s2.pop();
        return x;
    }

    int getFront() {
        if (s1.isEmpty()) { // if first stack is empty
            return -1;
        }
        int x = s1.peek(); // Return top of s1
        return x;
    }

    boolean isEmpty() {
        return s1.size() <= 0;
    }
}

class StackQueue3 { // Approach-3: Only 1 Queue is used

/**
 * Time Complexity:
 *      Push: O(1)
 *      Pop: O(n) ... The difference from above approach is that in this approach element is returned and
 *                    all elements are restored back in a single call.
 * Space Complexity: O(n) ... Use of stack for storing values.
 */
    // Two inbuilt stack
    static Stack<Integer> s;
    
    StackQueue3() {
        s = new Stack<Integer>();
    }

    void enQueue(int x) {// Push the data onto the stack
        s.push(x);
    }

    int deQueue() { 
        int x, res = 0;
        if (s == null || s.isEmpty()) // Stack is empty
        	return -1;
        // Check if it is a last element of stack
        else if (s.size() == 1) // return element from stack
            return s.pop();
        else { // pop an item from the stack
            // return element from stack
            x = s.pop();
            res = deQueue(); // store the last deQueued item
            s.push(x);// push everything back to stack
            return res;
        }
    }

    int getFront() {
        if (s.isEmpty()) { // if stack is empty
            return -1;
        }
        int x = s.peek(); // Return top of s
        return x;
    }

    boolean isEmpty() {
        return s.size() <= 0;
    }
}

public class ImplementationStack {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static StackQueue1 approach1;
    static StackQueue2 approach2;
    static StackQueue3 approach3;
    public static void main(String[] args) throws IOException  {
    	int option = -1;
		int approach = getApproachInput();
    	do {
    		option = chooseMenu();
			performOperation(option, approach);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Queue Implementation From Queue *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Queue");
    	System.out.println("* 2. Push Data");
		System.out.println("* 3. Pop Data");
		System.out.println("* 4. Peek Data");
		System.out.println("* 5. Is Queue Empty?");
		System.out.println("* 6. Delete Queue");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option, int approach) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createQueue(approach);
	    	break;
	    	case 2: 
	    		enQueue(approach);
	    	break;
	    	case 3: 
	    		deQueue(approach);
	    	break;
	    	case 4: 
	    		getFront(approach);
	    	break;
	    	case 5: 
	    		isEmpty(approach);
	    	break;
	    	case 6: 
	    		deleteQueue(approach);
	    	break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createQueue(int approach) throws IOException {
        System.out.println("\t*** Create a Queue ***");
        if(approach == 1) {
	        if(approach1 != null) {
	        	System.out.print("\tDo you want to overwrite existing queue? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach1 = new StackQueue1();
        }
        else if(approach == 2) {
	        if(approach2 != null) {
	        	System.out.print("\tDo you want to overwrite existing queue? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach2 = new StackQueue2();
        }
        else {
	        if(approach3 != null) {
	        	System.out.print("\tDo you want to overwrite existing queue? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach3 = new StackQueue3();
        }
    	System.out.println("\tSuccessfully Created Queue!!");
    }
    
    private static void enQueue(int approach) throws IOException {
        System.out.println("\t*** EnQueue Data to Queue ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach1.enQueue(data);
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach2.enQueue(data);
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach3.enQueue(data);
        }
    	System.out.println("Data-"+data+" enQueued to Queue Successfully!!");
    }
    
    private static void deQueue(int approach) throws IOException {
        System.out.println("\t*** DeQueue Data from Queue ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach1.deQueue();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach2.deQueue();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach3.deQueue();
        }
        if(data!=-1)
        	System.out.println("Data-"+data+" deQueued from Queue Successfully!!");
        else
        	System.out.println("Queue is Empty!!");
    }
    
    private static void getFront(int approach) throws IOException {
        System.out.println("\t*** Peek Data from Queue ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach1.getFront();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach2.getFront();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        data = approach3.getFront();
        }
        if(data!=-1)
        	System.out.println("Data-"+data+" peeked from Queue Successfully!!");
        else
        	System.out.println("Queue is Empty!!");
    }
    
    private static void deleteQueue(int approach) throws IOException {
        System.out.println("\t*** Delete the Queue ***");
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        while(!approach1.isEmpty()) {
	        	deQueue(approach);
	        }
	        approach1 = null;
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        while(!approach2.isEmpty()) {
	        	deQueue(approach);
	        }
	        approach2 = null;
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        while(!approach3.isEmpty()) {
	        	deQueue(approach);
	        }
	        approach3 = null;
        }
    	System.out.println("\tSuccessfully Deleted Queue!!");
    }
    
    private static void isEmpty(int approach) throws IOException {
        System.out.println("\t*** Is Queue Empty? ***");
        boolean result = false;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        result = approach1.isEmpty();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        result = approach2.isEmpty();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Queue Exists!!");
	    		return;
	        }
	        result = approach3.isEmpty();
        }
        if(result)
        	System.out.println("Queue is Empty!!");
        else
        	System.out.println("Queue is Not Empty!!");
    }

    private static int getApproachInput() throws IOException {
        System.out.print("Different approaches of Implemenatation:"
        		+ "\n\tApproach-1. Enqueue Operation Heavy"
        		+ "\n\tApproach-2. Dequeue Operation Heavy"
        		+ "\n\tApproach-3: 1 Queue and Function Call Queue"
        		+ "\nEnter Your choice: ");
        return Integer.parseInt(read.readLine());
    }

    private static int getDataInput() throws IOException {
        System.out.print("Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
