package Stack;

import java.io.*;
import java.util.*;

/**
 * ImplementationQueue
 * Problem Statement: To create Stack from Queue.
 * Operations:
 * 1. Create a Stack
 * 2. Push Data to Stack
 * 3. Pop Data from Stack
 * 4. Peek Data from Stack
 * 5. Delete Stack
 */

class Queueapproach1 { // Approach-1: Making push operation costly

/**
 * Time Complexity:
 *      Push: O(n) ... As all the elements are popped out from the Queue (q1) and push them back to Queue (q2)
 *      Pop: O(1) ... As we remove the front element from the Queue (q1).
 * Space Complexity: O(n) ... As we use two queues for the implementation of a stack
 */
    // Two inbuilt queues
    static Queue<Integer> q1, q2;

    // To maintain current number of elements
    static int curr_size;
    
    Queueapproach1() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    void push(int x) {
        q2.add(x); // Push x first in empty q2        
        while (!q1.isEmpty()) { // Push all the remaining elements in q1 to q2.
            q2.add(q1.remove());
        }
        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    int pop() { 
        if (q1.isEmpty()) // if no elements are there in q1
            return -1;
        return q1.remove();
    }

    int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    boolean isEmpty() {
        return q1.size() <= 0;
    }
}

class Queueapproach2 { // Approach-2: Making pop operation costly

/**
 * Time Complexity:
 *      Push: O(1) ... As, on each push operation the new element is added at the end of the Queue
 *      Pop: O(n) ... As, on each pop operation, all the elements are popped out from the Queue (q1) except
 *                    the last element and pushed it into the Queue (q2).
 * Space Complexity: O(n) ... As we use two queues for the implementation of a stack
 */
    // Two inbuilt queues
    static Queue<Integer> q1, q2;

    // To maintain current number of elements
    static int curr_size;
    
    Queueapproach2() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    void push(int x) {
        q1.add(x); // Push x first in empty q1
    }

    int pop() { 
        if (q1.isEmpty())
            return -1;
        while (q1.size() != 1) { // Leave one element in q1 and push others in q2.
            q2.add(q1.peek());
            q1.remove();
        }
        int data = q1.remove(); // Pop the only left element from q1
        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return data;
    }

    int top() {
        if (q1.isEmpty())
            return -1;
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        
        int temp = q1.peek(); // last pushed element
        q1.remove(); // to empty the auxiliary queue after last operation
        q2.add(temp); // push last element to q2
        // swap the two queues names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    boolean isEmpty() {
        return q1.size() <= 0;
    }
}

class Queueapproach3 { // Approach-3: Only 1 Queue is used

/**
 * Time Complexity:
 *      Push: O(n)
 *      Pop: O(1)
 * Space Complexity: O(n)
 */
    // Two inbuilt queues
    static Queue<Integer> q;
    
    // To maintain current number of elements
    static int curr_size;
    
    Queueapproach3() {
        q = new LinkedList<Integer>();
    }

    void push(int x) {
        int s = q.size(); // Get previous size of queue
        q.add(x); // Push the current element
        // Pop all the previous elements and put them after current element
        for (int i = 0; i < s; i++) {
            q.add(q.remove()); // Add the front element again and delete it from front
        }
    }

    int pop() { 
        if (q.isEmpty())
            return -1;
        return q.remove();
    }

    int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    boolean isEmpty() {
        return q.size() <= 0;
    }
}

public class ImplementationQueue {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static Queueapproach1 approach1;
    static Queueapproach2 approach2;
    static Queueapproach3 approach3;
    public static void main(String[] args) throws IOException  {
    	int option = -1;
		int approach = getApproachInput();
    	do {
    		option = chooseMenu();
			performOperation(option, approach);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Stack Implementation From Queue *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Stack");
    	System.out.println("* 2. Push Data");
		System.out.println("* 3. Pop Data");
		System.out.println("* 4. Peek Data");
		System.out.println("* 5. Is Stack Empty?");
		System.out.println("* 6. Delete Stack");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option, int approach) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createStack(approach);
	    	break;
	    	case 2: 
	    		push(approach);
	    	break;
	    	case 3: 
	    		pop(approach);
	    	break;
	    	case 4: 
	    		peek(approach);
	    	break;
	    	case 5: 
	    		isEmpty(approach);
	    	break;
	    	case 6: 
	    		deleteStack(approach);
	    	break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createStack(int approach) throws IOException {
        System.out.println("\t*** Create a Stack ***");
        if(approach == 1) {
	        if(approach1 != null) {
	        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach1 = new Queueapproach1();
        }
        else if(approach == 2) {
	        if(approach2 != null) {
	        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach2 = new Queueapproach2();
        }
        else {
	        if(approach3 != null) {
	        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
	        	String option = read.readLine();
	        	if(option == "No")
	        		return;
	        }
	        approach3 = new Queueapproach3();
        }
    	System.out.println("\tSuccessfully Created Stack!!");
    }
    
    private static void push(int approach) throws IOException {
        System.out.println("\t*** Push Data to Stack ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach1.push(data);
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach2.push(data);
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	    	data = getDataInput();
	        approach3.push(data);
        }
    	System.out.println("Data-"+data+" pushed to Stack Successfully!!");
    }
    
    private static void pop(int approach) throws IOException {
        System.out.println("\t*** Pop Data from Stack ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach1.pop();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach2.pop();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach3.pop();
        }
        if(data!=-1)
        	System.out.println("Data-"+data+" popped from Stack Successfully!!");
        else
        	System.out.println("Stack is Empty!!");
    }
    
    private static void peek(int approach) throws IOException {
        System.out.println("\t*** Peek Data from Stack ***");
        int data = -1;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach1.top();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach2.top();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        data = approach3.top();
        }
        if(data!=-1)
        	System.out.println("Data-"+data+" peeked from Stack Successfully!!");
        else
        	System.out.println("Stack is Empty!!");
    }
    
    private static void deleteStack(int approach) throws IOException {
        System.out.println("\t*** Delete the Stack ***");
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        while(!approach1.isEmpty()) {
	        	pop(approach);
	        }
	        approach1 = null;
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        while(!approach2.isEmpty()) {
	        	pop(approach);
	        }
	        approach2 = null;
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        while(!approach3.isEmpty()) {
	        	pop(approach);
	        }
	        approach3 = null;
        }
    	System.out.println("\tSuccessfully Deleted Stack!!");
    }
    
    private static void isEmpty(int approach) throws IOException {
        System.out.println("\t*** Is Stack Empty? ***");
        boolean result = false;
        if(approach == 1) {
	        if(approach1 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        result = approach1.isEmpty();
        }
        else if(approach == 2) {
	        if(approach2 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        result = approach2.isEmpty();
        }
        else {
	        if(approach3 == null) {
	        	System.out.println("No Stack Exists!!");
	    		return;
	        }
	        result = approach3.isEmpty();
        }
        if(result)
        	System.out.println("Stack is Empty!!");
        else
        	System.out.println("Stack is Not Empty!!");
    }

    private static int getApproachInput() throws IOException {
        System.out.print("Different approaches of Implemenatation:"
        		+ "\n\tApproach-1. Push Operation Heavy"
        		+ "\n\tApproach-2. Pop Operation Heavy"
        		+ "\n\tApproach-3: Use only 1 Queue"
        		+ "\nEnter Your choice: ");
        return Integer.parseInt(read.readLine());
    }

    private static int getDataInput() throws IOException {
        System.out.print("Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
