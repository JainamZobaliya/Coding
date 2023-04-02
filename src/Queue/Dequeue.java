package Queue;

import java.io.*;

/**
 * Dequeue
 * Problem Statement: To create Dequeue from array.
 * Operations:
 * 1. Create a Dequeue
 * 2. Push Data to Front
 * 3. Push Data to Rear
 * 4. Pop Data to Front
 * 5. Pop Data to Rear
 * 6. Peek Data from Front
 * 7. Peek Data from Rear
 * 8. is Dequeue Empty?
 * 9. is Dequeue Full?
 * 10. Delete Dequeue
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class QueueForDequeue {
	int[] queue;
	int front = -1, rear = -1;
	
	QueueForDequeue(int data) {
		queue = new int[data];
		front = -1;
		rear = -1;
	}
	
	void pushFront(int data) {
		if(isFull()) {
			System.out.println("\tQueue is Full!!");
			return;
		}
		if(front == -1) {
			front = 0;
			rear = 0;
		}
        else if(front == 0) {
            front = queue.length-1;
        }
		else
			--front;
		queue[front] = data;
		System.out.println("\tData-"+data+" pushed to queue from front.");
	}
	
	void pushRear(int data) {
		if(isFull()) {
			System.out.println("\tQueue is Full!!");
			return;
		}
		if(rear == -1) {
			front = 0;
			rear = 0;
		}
		else if(rear == queue.length-1) {
			rear = 0;
		}
		else
			++rear;
		queue[rear] = data;
		System.out.println("\tData-"+data+" pushed to queue from rear.");
	}
	
	void popFront() {
		if(isEmpty()) {
			System.out.println("\tQueue is Empty!!");
			return;
		}
		int data = queue[front];
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else if(front == queue.length-1) {
			front = 0;
		}
		else {
			++front;
		}
		System.out.println("Data-"+data+" popped from front of Queue.");	
	}
	
	void popRear() {
		if(isEmpty()) {
			System.out.println("\tQueue is Empty!!");
			return;
		}
		int data = queue[rear];
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else if(rear == 0) {
			rear = queue.length-1;
		}
		else {
			--rear;
		}
		System.out.println("Data-"+data+" popped from rear of Queue.");	
	}
	
	void getFront() {
		if(isEmpty()) {
			System.out.println("\tQueue is Empty!!");
			return;
		}
		int data = queue[front];
		System.out.println("Data-"+data+" peeked from front of Queue.");	
	}
	
	void getRear() {
		if(isEmpty()) {
			System.out.println("\tQueue is Empty!!");
			return;
		}
		int data = queue[rear];
		System.out.println("Data-"+data+" peeked from rear of Queue.");	
	}
	
	void deleteQueue() {
		if(queue == null || isEmpty()) {
			System.out.println("\tDequeue does not exists!!");
		}
        while(!isEmpty()) {
        	popFront();
        }
        queue = null;
        System.out.println("\tDequeue Deleted Successfully!!");
	}
	
    boolean isFull() {
        return ( (front == 0 && rear == queue.length-1) || front == rear+1);
    }
	
    boolean isEmpty() {
        return front == -1 && rear == -1;
    }
}

public class Dequeue {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static QueueForDequeue queue;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Queue Implementation From Array *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create a Queue");
    	System.out.println("* 2. Push Data to Front");
    	System.out.println("* 3. Push Data to Rear");
    	System.out.println("* 4. Pop Data from Front");
    	System.out.println("* 5. Pop Data from Rear");
    	System.out.println("* 6. Peek Data from Front");
    	System.out.println("* 7. Peek Data from Rear");
		System.out.println("* 8. Queue isEmpty?");
		System.out.println("* 9. Queue isFull?");
		System.out.println("* 10. Delete Queue");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createQueue();
	    	break;
	    	case 2: 
	    		pushFront();
	    	break;
	    	case 3: 
	    		pushRear();
	    	break;
	    	case 4: 
	    		popFront();
	    	break;
	    	case 5: 
	    		popRear();
	    	break;
	    	case 6: 
	    		getFront();
	    	break;
	    	case 7: 
	    		getRear();
	    	break;
	    	case 8: 
	    		isEmpty();
	    	break;
	    	case 9: 
	    		isFull();
	    	break;
	    	case 10: 
	    		deleteQueue();
	    	break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createQueue() throws IOException {
        System.out.println("\t*** Create a Queue ***");
        if(queue != null) {
        	System.out.print("\tDo you want to overwrite existing queue? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
    	int length = getDataInput(true);
    	queue = new QueueForDequeue(length);
    	System.out.println("\tSuccessfully Created Queue!!");
    }
    
    private static void pushFront() throws IOException {
        System.out.println("\t*** Push Data to Front ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
    	int data = getDataInput(false);
    	queue.pushFront(data);
    }
    
    private static void pushRear() throws IOException {
        System.out.println("\t*** Push Data to Rear ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
    	int data = getDataInput(false);
    	queue.pushRear(data);
    }
    
    private static void popFront() throws IOException {
        System.out.println("\t*** Pop Data from Front ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        queue.popFront();
    }
    
    private static void popRear() throws IOException {
        System.out.println("\t*** Pop Data from Rear ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        queue.popRear();
    }
    
    private static void getFront() throws IOException {
        System.out.println("\t*** Peek Data from Front ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        queue.getFront();
    }
    
    private static void getRear() throws IOException {
        System.out.println("\t*** Peek Data from Rear ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        queue.getRear();
    }
    
    private static void isEmpty() throws IOException {
        System.out.println("\t*** Queue isEmpty? ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        boolean result = queue.isEmpty();
		if(result) {
			System.out.println("\tQueue is Empty!!");
		}
		else {
			System.out.println("\tQueue is not Empty!!");
		}
    }
    
    private static void isFull() throws IOException {
        System.out.println("\t*** Queue isFull? ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        boolean result = queue.isFull();
		if(result) {
			System.out.println("\tQueue is Full!!");
		}
		else {
			System.out.println("\tQueue is not Full!!");
		}
    }
    
    private static void deleteQueue() throws IOException {
        System.out.println("\t*** Delete the Queue ***");
        if(queue == null) {
        	System.out.println("No Queue Exists!!");
    		return;
        }
        queue.deleteQueue();
        queue = null;
    	System.out.println("\tSuccessfully Deleted Queue!!");
    }

    private static int getDataInput(boolean isLength) throws IOException {
        System.out.print(isLength ? "Enter length of Queue: " : "Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
