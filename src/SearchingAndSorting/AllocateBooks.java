package SearchingAndSorting;

import java.io.*;
import java.util.Arrays;

/**
 * AllocateBooks
 * Problem Statement: To allocate the book to ‘m’ students such that the maximum number of pages
 * assigned to a student is minimum, and give that min. number else return -1. 
 * URL: https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 10 20 30 40
 * 			Input m: 2
 * 			Output: 60
 *		Test Case 2: 
 * 			Input Array: 12 34 67 90
 * 			Input m: 2
 * 			Output: 113
 *		Test Case 3: 
 * 			Input Array: 5 17 100 11
 * 			Input m: 4
 * 			Output: 100
 */

/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

public class AllocateBooks {
    static int testCaseSize, books[][], m[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(books[i], m[i]);
        }
    }

    private static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
                System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        // Take input for current test case
        books = new int[testCaseSize][];
        m = new int[testCaseSize];
        for(int i=0; i<testCaseSize; ++i) {
        	int noOfBooks = -1;
            System.out.print("Enter no. of books: ");
            noOfBooks = Integer.parseInt(read.readLine());
            System.out.print("Enter no. of students: ");
            m[i] = Integer.parseInt(read.readLine());
	        // Instantiation array with the user input arrSize
	        books[i] = new int[noOfBooks];
	        System.out.print("Enter the pages in books (space separated): ");
	        String[] pages = read.readLine().split("\s");
	        // Initializing array with the user array input
	        for(int j=0; j<noOfBooks; ++j)
	            books[i][j] = Integer.parseInt(pages[j]);
	    }
    }

    private static void runTestCase(int[] pages, int m) throws IOException  {
        // Printing the array
        System.out.println("Array: "+ Arrays.toString(pages));  
        // Binary Search
        int min = allocateBooks(pages, m);
        // Printing the output
        System.out.println("Output: " + min);
        System.out.println("=================================="); 
    }

    private static int allocateBooks(int[] pages, int m) {
		int start = 0, end = calculateSum(pages, 0, pages.length-1);
    	int minPage = -1;
    	while(start<=end) {
        	int mid = getMidIndex(start, end);
        	if(isMidPossible(pages, m, mid)) {
        		minPage = mid;
        		end = mid - 1; // as right of mid are all answers but not min. value
        	} 
        	else { // as current mid is not possible so all values left to it would also be not possible
        		start = mid +1; 
        	}
    	}
		return minPage;
    }

    private static boolean isMidPossible(int[] pages, int m, int mid) {
    	int pageCount = 0;
    	int studentCount = 0;
    	for(int i = 0; i < pages.length; i++) {
    		if(pageCount + pages[i] <= mid) {
    			pageCount += pages[i];
    		}
    		else {
    			++studentCount;
    			if(studentCount == m || pages[i] > mid) {
    				return false;
    			}
    			pageCount = pages[i];
    		}
    	}
    	return true;
    }
    
    private static int calculateSum(int[] arr, int start, int end) {
    	int sum = 0;
    	for(int i= start; i<=end; ++i)
    		sum+=arr[i];
    	return sum;
    }
    
    private static int getMidIndex(int start, int end) {
    	return start + (end-start)/2; // To avoid error due to range
    }
    
}
