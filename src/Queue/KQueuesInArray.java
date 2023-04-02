package Queue;

import java.io.*;

/**
 * KQueuesInArray
 * Problem Statement: To create K Queues in a array.
 * Operations:
 * 1. Create a N-Queue
 * 2. Push Data to Queue
 * 3. Pop Data from Queue
 * 4. Peek Data from Queue
 * 5. Delete Queue
 * 6. Delete N-Queue
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class KQueue {
	int[] queue, front, rear, next;
	int queueNum;
	int freeSpot;
	
	KQueue(int queueSize, int queueNum) {
		queue = new int[queueSize];
		next = new int[queueSize];
		front = new int[queueNum];
		rear = new int[queueNum];
		this.queueNum = queueNum;
		resetQueue();
	}
	
	void resetQueue() {
		int i=0;
		while(i!=this.queueNum) {
			this.front[i] = -1;
			this.rear[i] = -1;
			++i;
		}
		freeSpot = 0;
		i=0;
		while(i<queue.length) {
			this.next[i] = i+1;
			++i;
		}
		this.next[queue.length-1] = -1;
	}
	
	boolean push(int data, int currQueue) {
		int index = freeSpot;
		if(index==-1 || currQueue > queueNum) { // Queue Overflow
			return false;
		}
		freeSpot = next[index];
		if(front[currQueue-1] == -1) { // If first element of q., then updating its front
			front[currQueue-1] = index;
		}
		else { // To link new data to previous data block of same q.
			next[rear[currQueue-1]] = index;
		}
		next[index] = -1; // As current index is occupied
		rear[currQueue-1] = index; // Updating rear of current q. with new occupied index
		queue[index] = data; // Pushing data
		return true;
	}
	
	int pop(int currQueue) {
		if(front[currQueue-1] == -1) { // Queue Underflow
			return -1;
		}
		int index = front[currQueue-1]; // First Position of current q.
		front[currQueue-1] = next[index]; // Changing front position with the new first element of q.
		next[index] = freeSpot; // data at index is popped so that index is now free
		freeSpot = index;
		return queue[index];
	}
	
	int peek(int currQueue) {
		if(front[currQueue-1] == -1) { // Queue Underflow
			return -1;
		}
		return queue[front[currQueue-1]];
	}
	
	boolean deleteQueue(int currQueue) {
		if(front[currQueue-1] == -1) {
	    	System.out.println("\tQueue-"+currQueue+" Not Exists!!");
	    	return false;
		}
		while(front[currQueue-1] != -1) {
			int data = pop(currQueue);
			if(data != -1) {
				System.out.println("\t\tData-" + data + " popped from Queue-"+currQueue);
			}
		}
    	System.out.println("\tSuccessfully Deleted Queue-"+currQueue+"!!");
    	return true;
	}

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
}

public class KQueuesInArray {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static KQueue queue;
    static int noOfQueue;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** N Queue Implementation From Array *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create N Queue");
    	System.out.println("* 2. Push Data to Queue");
		System.out.println("* 3. Pop Data to Queue");
		System.out.println("* 4. Peek Data to Queue");
		System.out.println("* 5. Delete Queue");
		System.out.println("* 6. Delete Entire N-Queue");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	int queueNum = -1;
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	        	int queueSize = getDataInput(true);
	        	System.out.print("Enter the Queue Num: ");
	        	noOfQueue = Integer.parseInt(read.readLine());
	    		createQueue(queueSize, noOfQueue);
	    	break;
	    	case 2: 
	        	int data = getDataInput(false);
	        	queueNum = getQueueNumInput();
	    		push(data, queueNum);
	    	break;
	    	case 3: 
	    		queueNum = getQueueNumInput();
	    		pop(queueNum);
	    	break;
	    	case 4: 
	    		queueNum = getQueueNumInput();
	    		peek(queueNum);
	    	break;
	    	case 5: 
	    		queueNum = getQueueNumInput();
	    		deleteQueue(queueNum);
	    	break;
	    	case 6:
	    		deleteKQueue();
    		break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createQueue(int queueSize, int noOfQueue) throws IOException {
        System.out.println("\t*** Create a Queue ***");
        if(queue != null) {
        	System.out.print("\tDo you want to overwrite existing Queue? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
        queue = new KQueue(queueSize, noOfQueue);
    	System.out.println("\tSuccessfully Created N-Queue!!");
    }
    
    private static void push(int data, int currQueue) throws IOException {
        System.out.println("\t*** Push Data to Queue-"+currQueue+" ***");
        if(queue == null) {
        	System.out.println("Queue-"+currQueue+" doesn't Exists!!");
    		return;
        }
        boolean result = queue.push(data, currQueue);
        System.out.println(result ? "Pushed Data: " + data + " successfully!!" : "Queue OverFlow!!");
    }
    
    private static void pop(int currQueue) throws IOException {
        System.out.println("\t*** Pop Data from Queue-"+currQueue+" ***");
        if(queue == null) {
        	System.out.println("Queue-"+currQueue+" doesn't Exists!!");
    		return;
        }
        int data = queue.pop(currQueue);
        System.out.println(data != -1 ? "Data-" + data + " popped from Queue-"+currQueue : "Queue UnderFlow!!");
    }
    
    private static void peek(int currQueue) throws IOException {
        System.out.println("\t*** Peek Data from Queue-"+currQueue+" ***");
        if(queue == null) {
        	System.out.println("Queue-"+currQueue+" doesn't Exists!!");
    		return;
        }
        int data = queue.peek(currQueue);
        System.out.println(data != -1 ? "Peek Data: " + data : "Queue UnderFlow!!");
    }
    
    private static void deleteQueue(int currQueue) throws IOException {
        System.out.println("\t*** Delete the Queue-"+currQueue+" ***");
        if(queue == null) {
        	System.out.println("Queue-"+currQueue+" doesn't Exists!!");
    		return;
        }
        queue.deleteQueue(currQueue);
    }
    
    private static void deleteKQueue() throws IOException {
        System.out.println("\t*** Delete the N-Queue ***");
        if(queue == null) {
        	System.out.println("N-Queue doesn't Exists!!");
    		return;
        }
        int queueNum = noOfQueue;
        while(queueNum>0) {
        	boolean result = queue.deleteQueue(queueNum);
            System.out.println(result ? "Queue-" + queueNum + " deleted successfully!!" :
            	"Failed to delete Queue-"+queueNum+"!!");
        	--queueNum;
        }
        queue = null;
    	System.out.println("\tSuccessfully Deleted N-Queue!!");
    }

    private static int getQueueNumInput() throws IOException {
    	System.out.print("Enter the Queue Num: ");
    	return Integer.parseInt(read.readLine());
    }

    private static int getDataInput(boolean isLength) throws IOException {
        System.out.print(isLength ? "Enter length of Queue: " : "Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
