package Queue;

import java.util.*;
import java.io.*;

/**
 * SumMinMax
 * Problem Statement: To get the sum of min. and max. elements of all window(contiguous subarray)
 * of size K.
 * 	Example:
 * 		Test Case 1: 
 * 			Input: 2 5 -1 7 -3 -1 -2
 *          Input K: 4
 * 			Output: 18
 * 		Test Case 2: 
 * 			Input: 12 -1 -7 8 -15 30 16 28
 *          Input K: 3
 * 			Output: -1 -1 -7 -15 -15 0
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

public class SumMinMax {

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
    	int sum = getSum(arr, k);
    	System.out.println("Sum is: " + sum);
    }
    
    private static void pushMax(Queue<Integer> queue, int[] arr, int index) {
    	if(queue.isEmpty())
			queue.add(index);
		while(!queue.isEmpty() && arr[index] > arr[queue.peek()]) {
			queue.poll();
			queue.add(index);
		}
    }
    
    private static void pushMin(Queue<Integer> queue, int[] arr, int index) {
    	if(queue.isEmpty())
			queue.add(index);
    	while(!queue.isEmpty() && arr[index] < arr[queue.peek()]) {
			queue.poll();
			queue.add(index);
		}
    }
    
    private static int getSum(int[] arr, int k) {
    	Queue<Integer> maxi = new LinkedList<Integer>();
    	Queue<Integer> mini = new LinkedList<Integer>();
    	int sum;
    	if(arr.length == 0) { // Base Case
    		return 0;
    	}
    	for(int i=0; i<k; i++) { // Adding min negative no. in first window of size k
    		pushMax(maxi, arr, i);
    		pushMin(mini, arr, i);
    	}
		// Adding 1st window's max and min
    	int max = (maxi.isEmpty() ? 0 : maxi.peek());
    	int min = (mini.isEmpty() ? 0 : mini.peek());
    	sum = arr[max] + arr[min];
    	// for elements k to n;
    	for(int i=k; i<arr.length; i++) {
    		// Pop from front to remove 1st added element in max and min
    		while(!maxi.isEmpty() && i-maxi.peek() >=k) {
    			maxi.poll();
    		}
    		while(!mini.isEmpty() && i-mini.peek() >=k) {
    			mini.poll();
    		}
    		pushMax(maxi, arr, i);
    		pushMin(mini, arr, i);
    		// Adding next window's max and min
        	max = (maxi.isEmpty() ? 0 : maxi.peek());
        	min = (mini.isEmpty() ? 0 : mini.peek());
        	sum += arr[max] + arr[min];
    	}
		return sum;
    }  
    
    private static void printArray(int[] arr) {
    	for(int i=0; i<arr.length; i++) {
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }
}

