package Stack;

import java.io.*;

/**
 * TwoStack
 * Problem Statement: To create two stack from a array.
 * Operations:
 * 1. Create a Stack-1
 * 2. Push Data to Stack-1
 * 3. Pop Data from Stack-1
 * 4. Peek Data from Stack-1
 * 5. Delete Stack-1
 * 6. Push Data to Stack-2
 * 7. Pop Data from Stack-2
 * 8. Peek Data from Stack-2
 * 9. Delete Stack-2
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class MyStack {
	int[] stack;
	int top1 = -1;
	int top2 = -1;
	
	MyStack(int data) {
		stack = new int[data];
		top2 = data; // stack.length
	}
	
	void push1(int data) {
		if(this.top1+1<stack.length && this.top1+1<this.top2) {
			this.top1+=1;
			stack[this.top1] = data;
			System.out.println("\tData-"+data+" pushed to stack-1.");
		}
		else { // top1 > stack.length || top+1 clashes with top2
			System.out.println("\t Stack-1 Overflow!!");
		}
	}
	
	void pop1() {
		if(this.top1>=0) {
			System.out.println("Data-"+stack[this.top1]+" popped from stack-1.");		
			this.top1-=1;
		}
		else { // top1 < 0
			System.out.println("\t Stack-1 Underlow!!");
		}
	}
	
	void peek1() {
		if(this.top1>=0) {
			System.out.println("Data-"+stack[this.top1]+" peeked from stack-1.");
		}
		else { // top1 < 0
			System.out.println("\t Stack-1 Underlow!!");
		}
	}
	
	void deleteStack1() {
		if(this.top1<0) { // top1 < 0
			System.out.println("\t Stack-1 Underlow!!");
			return;
		}
		while(this.top1>=0) {
			System.out.println("Data-"+stack[this.top1]+" popped from stack-1.");		
			this.top1-=1;
		}
    	System.out.println("\tSuccessfully Deleted Stack-1!!");
	}
	
	void push2(int data) {
		if(this.top2+1>0 && this.top2-1>this.top1) {
			this.top2-=1;
			stack[this.top2] = data;
			System.out.println("\tData-"+data+" pushed to stack-2.");
		}
		else { // top2 < 0 || top+2 clashes with top1
			System.out.println("\t Stack-2 Overflow!!");
		}
	}
	
	void pop2() {
		if(this.top2<stack.length) {
			System.out.println("Data-"+stack[this.top2]+" popped from stack-2.");		
			this.top2+=1;
		}
		else { // top2 >= stack.length
			System.out.println("\t Stack-2 Underlow!!");
		}
	}
	
	void peek2() {
		if(this.top2>=0 && this.top2<stack.length) {
			System.out.println("Data-"+stack[this.top2]+" peeked from stack-2.");
		}
		else { // top2 < 0
			System.out.println("\t Stack-2 Underlow!!");
		}
	}
	
	void deleteStack2() {
		if(this.top2>=stack.length) { // top2 >= stack.length
			System.out.println("\t Stack-2 Underlow!!");
			return;
		}
		while(this.top2<stack.length) {
			System.out.println("Data-"+stack[this.top2]+" popped from stack-2.");		
			this.top2+=1;
		}
    	System.out.println("\tSuccessfully Deleted Stack-2!!");
	}
}

public class TwoStack {
    static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static final BufferedReader read = new BufferedReader(inputStreamReader);
    static MyStack stack;

    public static void main(String[] args) throws IOException  {
    	int option = -1;
    	do {
    		option = chooseMenu();
			performOperation(option);
    	} while(option != 0);
    }
    
    private static int chooseMenu() throws IOException {
    	System.out.println("\n\t***** Two Stack Implementation From Array *****");
    	System.out.println("* 0. Exit");
    	System.out.println("* 1. Create Two Stack");
    	System.out.println("* 2. Push Data to Stack-1");
		System.out.println("* 3. Pop Data to Stack-1");
		System.out.println("* 4. Peek Data to Stack-1");
		System.out.println("* 5. Delete Stack-1");
    	System.out.println("* 6. Push Data to Stack-2");
		System.out.println("* 7. Pop Data to Stack-2");
		System.out.println("* 8. Peek Data to Stack-2");
		System.out.println("* 9. Delete Stack-2");
		System.out.println("* 10. Delete Entire TwoStack");
    	System.out.print("Choose Option from above to perform that operation: ");
    	return Integer.parseInt(read.readLine());
    }
    
    private static void performOperation(int option) throws IOException {
    	switch(option) {
	    	case 0: 
	    		System.out.println("***** See You Again!! *****");
	    	break;
	    	case 1: 
	    		createStack();
	    	break;
	    	case 2: 
	    		push1();
	    	break;
	    	case 3: 
	    		pop1();
	    	break;
	    	case 4: 
	    		peek1();
	    	break;
	    	case 5: 
	    		deleteStack1();
	    	break;
	    	case 6: 
	    		push2();
	    	break;
	    	case 7: 
	    		pop2();
	    	break;
	    	case 8: 
	    		peek2();
	    	break;
	    	case 9: 
	    		deleteStack2();
	    	break;
	    	case 10:
	    		deleteTwoStack();
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
    	int length = getDataInput(true);
        stack = new MyStack(length);
    	System.out.println("\tSuccessfully Created TwoStack!!");
    }
    
    private static void push1() throws IOException {
        System.out.println("\t*** Push Data to Stack-1 ***");
        if(stack == null) {
        	System.out.println("Stack-1 doesn't Exists!!");
    		return;
        }
    	int data = getDataInput(false);
        stack.push1(data);
    }
    
    private static void pop1() throws IOException {
        System.out.println("\t*** Pop Data from Stack-1 ***");
        if(stack == null) {
        	System.out.println("Stack-1 doesn't Exists!!");
    		return;
        }
        stack.pop1();
    }
    
    private static void peek1() throws IOException {
        System.out.println("\t*** Peek Data from Stack-1 ***");
        if(stack == null) {
        	System.out.println("Stack-1 doesn't Exists!!");
    		return;
        }
        stack.peek1();
    }
    
    private static void deleteStack1() throws IOException {
        System.out.println("\t*** Delete the Stack-1 ***");
        if(stack == null) {
        	System.out.println("Stack-1 doesn't Exists!!");
    		return;
        }
        stack.deleteStack1();
    }
    
    private static void push2() throws IOException {
        System.out.println("\t*** Push Data to Stack-2 ***");
        if(stack == null) {
        	System.out.println("Stack-2 doesn't Exists!!");
    		return;
        }
    	int data = getDataInput(false);
        stack.push2(data);
    }
    
    private static void pop2() throws IOException {
        System.out.println("\t*** Pop Data from Stack-2 ***");
        if(stack == null) {
        	System.out.println("Stack-2 doesn't Exists!!");
    		return;
        }
        stack.pop2();
    }
    
    private static void peek2() throws IOException {
        System.out.println("\t*** Peek Data from Stack-2 ***");
        if(stack == null) {
        	System.out.println("Stack-2 doesn't Exists!!");
    		return;
        }
        stack.peek2();
    }
    
    private static void deleteStack2() throws IOException {
        System.out.println("\t*** Delete the Stack-2 ***");
        if(stack == null) {
        	System.out.println("Stack-2 doesn't Exists!!");
    		return;
        }
        stack.deleteStack2();
    }
    
    private static void deleteTwoStack() throws IOException {
        System.out.println("\t*** Delete the TwoStack ***");
        if(stack == null) {
        	System.out.println("TwoStack doesn't Exists!!");
    		return;
        }
        stack.deleteStack1();
        stack.deleteStack2();
        stack = null;
    	System.out.println("\tSuccessfully Deleted TwoStack!!");
    }

    private static int getDataInput(boolean isLength) throws IOException {
        System.out.print(isLength ? "Enter length of Stack: " : "Enter data: ");
        return Integer.parseInt(read.readLine());
    }
    
}
