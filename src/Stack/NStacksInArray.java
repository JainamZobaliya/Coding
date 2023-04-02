package Stack;

import java.io.*;

/**
 * NStacksInArray
 * Problem Statement: To create N stack in a array.
 * Operations:
 * 1. Create a N-Stack
 * 2. Push Data to Stack
 * 3. Pop Data from Stack
 * 4. Peek Data from Stack
 * 5. Delete Stack
 * 6. Delete N-Stack
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class NStack {
	int[] stack, top, next;
	int stackNum;
	int freeSpot;
	
	NStack(int stackSize, int stackNum) {
		stack = new int[stackSize];
		next = new int[stackSize];
		top = new int[stackNum];
		this.stackNum = stackNum;
		resetStack();
	}
	
	void resetStack() {
		int i=0;
		while(i!=this.stackNum) {
			this.top[i] = -1;
			++i;
		}
		freeSpot = 0;
		i=0;
		while(i<stack.length) {
			this.next[i] = i+1;
			++i;
		}
		this.next[stack.length-1] = -1;
	}
	
	boolean push(int data, int currStack) {
		int index = freeSpot;
		if(index==-1 || currStack > stackNum) { // Stack Overflow
			return false;
		}
		freeSpot = next[index];
		stack[index] = data;
		next[index] = top[currStack-1];
		top[currStack-1] = index;
		return true;
	}
	
	int pop(int currStack) {
		if(top[currStack-1] == -1) { // Stack Underflow
			return -1;
		}
		int index = top[currStack-1];
		top[currStack-1] = next[index];
		next[index] = freeSpot;
		freeSpot = index;
		return stack[index];
	}
	
	int peek(int currStack) {
		if(top[currStack-1] == -1) { // Stack Underflow
			return -1;
		}
		return stack[top[currStack-1]];
	}
	
	boolean deleteStack(int currStack) {
		if(top[currStack-1] == -1) {
	    	System.out.println("\tStack-"+currStack+" Not Exists!!");
	    	return false;
		}
		while(top[currStack-1] != -1) {
			int data = pop(currStack);
			if(data != -1) {
				System.out.println("\t\tData-" + data + " popped from Stack-"+currStack);
			}
		}
    	System.out.println("\tSuccessfully Deleted Stack-"+currStack+"!!");
    	return true;
	}

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
}

public class NStacksInArray {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static NStack stack;
    static int noOfStack;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** N Stack Implementation From Array *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create N Stack");
    	System.out.println("* 2. Push Data to Stack");
		System.out.println("* 3. Pop Data to Stack");
		System.out.println("* 4. Peek Data to Stack");
		System.out.println("* 5. Delete Stack");
		System.out.println("* 6. Delete Entire N-Stack");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	int stackNum = -1;
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	        	int stackSize = getDataInput(true);
	        	System.out.print("Enter the Stack Num: ");
	        	noOfStack = Integer.parseInt(read.readLine());
	    		createStack(stackSize, noOfStack);
	    	break;
	    	case 2: 
	        	int data = getDataInput(false);
	        	stackNum = getStackNumInput();
	    		push(data, stackNum);
	    	break;
	    	case 3: 
	        	stackNum = getStackNumInput();
	    		pop(stackNum);
	    	break;
	    	case 4: 
	        	stackNum = getStackNumInput();
	    		peek(stackNum);
	    	break;
	    	case 5: 
	        	stackNum = getStackNumInput();
	    		deleteStack(stackNum);
	    	break;
	    	case 6:
	    		deleteNStack();
    		break;
			default:
				System.out.println(" INVALID OPTION!!!");
    	}
    }
    
    private static void createStack(int stackSize, int noOfStack) throws IOException {
        System.out.println("\t*** Create a Stack ***");
        if(stack != null) {
        	System.out.print("\tDo you want to overwrite existing stack? (Yes or No) ");
        	String option = read.readLine();
        	if(option == "No")
        		return;
        }
        stack = new NStack(stackSize, noOfStack);
    	System.out.println("\tSuccessfully Created N-Stack!!");
    }
    
    private static void push(int data, int currStack) throws IOException {
        System.out.println("\t*** Push Data to Stack-"+currStack+" ***");
        if(stack == null) {
        	System.out.println("Stack-"+currStack+" doesn't Exists!!");
    		return;
        }
        boolean result = stack.push(data, currStack);
        System.out.println(result ? "Pushed Data: " + data + " successfully!!" : "Stack OverFlow!!");
    }
    
    private static void pop(int currStack) throws IOException {
        System.out.println("\t*** Pop Data from Stack-"+currStack+" ***");
        if(stack == null) {
        	System.out.println("Stack-"+currStack+" doesn't Exists!!");
    		return;
        }
        int data = stack.pop(currStack);
        System.out.println(data != -1 ? "Data-" + data + " popped from Stack-"+currStack : "Stack UnderFlow!!");
    }
    
    private static void peek(int currStack) throws IOException {
        System.out.println("\t*** Peek Data from Stack-"+currStack+" ***");
        if(stack == null) {
        	System.out.println("Stack-"+currStack+" doesn't Exists!!");
    		return;
        }
        int data = stack.peek(currStack);
        System.out.println(data != -1 ? "Peek Data: " + data : "Stack UnderFlow!!");
    }
    
    private static void deleteStack(int currStack) throws IOException {
        System.out.println("\t*** Delete the Stack-"+currStack+" ***");
        if(stack == null) {
        	System.out.println("Stack-"+currStack+" doesn't Exists!!");
    		return;
        }
        stack.deleteStack(currStack);
    }
    
    private static void deleteNStack() throws IOException {
        System.out.println("\t*** Delete the N-Stack ***");
        if(stack == null) {
        	System.out.println("N-Stack doesn't Exists!!");
    		return;
        }
        int stackNum = noOfStack;
        while(stackNum>0) {
        	boolean result = stack.deleteStack(stackNum);
            System.out.println(result ? "Stack-" + stackNum + " deleted successfully!!" :
            	"Failed to delete Stack-"+stackNum+"!!");
        	--stackNum;
        }
        stack = null;
    	System.out.println("\tSuccessfully Deleted N-Stack!!");
    }

    private static int getStackNumInput() throws IOException {
    	System.out.print("Enter the Stack Num: ");
    	return Integer.parseInt(read.readLine());
    }

    private static int getDataInput(boolean isLength) throws IOException {
        System.out.print(isLength ? "Enter length of Stack: " : "Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
