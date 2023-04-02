package Queue;

import java.util.*;
import java.io.*;

/**
 * FirstNegative
 * Problem Statement: To find the first negative integer for each and every window(contiguous subarray)
 * of size K.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: -8 2 3 -6 10
 *          Input K: 2
 * 			Output: -8 0 -6 -6
 * 		Test Case 2: 
 * 			Input: 12 -1 -7 8 -15 30 16 28
 *          Input K: 3
 * 			Output: -1 -1 -7 -15 -15 0
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

public class FirstNegative {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the array size: ");
    	int size = Integer.parseInt(read.readLine());
        System.out.print("Enter the array elements (Space Separated): ");
    	String[] str = read.readLine().split("\\s");
    	int[] arr = new int[str.length];
    	int i=0;
    	while(i<size) {
    		arr[i] = Integer.parseInt(str[i]);
    		i++;
    	}
    	System.out.print("Enter value of k(window size): ");
    	int k = Integer.parseInt(read.readLine());
    	System.out.print("Array is: ");
    	printArray(arr);
    	ArrayList<Integer> result = getFirstNegativeInK(arr, k);
    	System.out.print("Resultant Array is: ");
    	printArrayList(result);
    }
    
    private static void push(ArrayDeque<Integer> queue, int[] arr, int index) {
    	if(queue.isEmpty() && arr[index]<0)
			queue.add(index);
		else if(!queue.isEmpty() && arr[index] < 0) {
			queue.add(index);
		}
    }
    
    private static ArrayList<Integer> getFirstNegativeInK(int[] arr, int k) {
    	ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(arr.length == 0) { // Base Case
    		return result;
    	}
    	for(int i=0; i<k; i++) { // Adding min negative no. in first window of size k
    		push(queue, arr, i);
    	}
		// Adding first negative no. of 1st window to result
    	if(queue.isEmpty()) {
    		result.add(0);
    	}
    	else {
    		result.add(arr[queue.peek()]);
    	}
    	// for elements k to n;
    	for(int i=k; i<arr.length; i++) {
    		// Pop from front to remove 1st added element
    		if(!queue.isEmpty() && i-queue.peek() >=k) {
    			queue.poll();
    		}
    		// Push to rear to add nest element
    		push(queue, arr, i);    
    		// Adding first negative no. of next window to result
        	if(queue.isEmpty()) {
        		result.add(0);
        	}
        	else {
        		result.add(arr[queue.peek()]);
        	}		
    	}
		return result;
    }  
    
    private static void printArray(int[] arr) {
    	for(int i=0; i<arr.length; i++) {
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }
    
    private static void printArrayList(ArrayList<Integer> arr) {
    	for(int num: arr) {
    		System.out.print(num+" ");
    	}
    	System.out.println();
    }
}

