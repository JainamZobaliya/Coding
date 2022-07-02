package Array;

import java.io.*;
import java.util.ArrayList;

/**
 * FindIntersection
 * Problem Statement: To find intersection of two non-decreasing arrays.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array-1: 1 2 2 3 4
 * 			Input Array-2: 3 4 5 7
 * 			Output : 3 4
 *		Test Case 2: 
 * 			Input Array-1: 1 2 3 4
 * 			Input Array-2: 5 6 7 8 9
 * 			Output: -1
 */

/**
 * Time Complexity: O(Max(arr1.length, arr2.length))
 * Space Complexity: O(N)
 */

public class FindIntersection {
    static int testCaseSize, arr1Size[], arr2Size[], arr1[][], arr2[][];
    static ArrayList<Integer> intersection[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(i);
        }
    }

    public static void takeTestCaseInput() throws IOException  {
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
        // Instantiation array with the user input testCaseSize
        arr1Size = new int[testCaseSize];
        arr2Size = new int[testCaseSize];
        intersection = new ArrayList[testCaseSize];
        arr1 = new int[testCaseSize][];
        arr2 = new int[testCaseSize][];
        for(int i=0; i<testCaseSize; ++i) {
            // take ith test Case Input
        	takeInput(i);
        }
    }

    public static void takeInput(int testCaseNum) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid array arrSize - input
        do{
            try{
                System.out.print("Enter size of array-1: ");
                arr1Size[testCaseNum] = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arr1Size[testCaseNum]<=0); 
        do{
            try{
                System.out.print("Enter size of array-2: ");
                arr2Size[testCaseNum] = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(arr2Size[testCaseNum]<=0);
        System.out.print("Enter array-1 elements(space separated): ");
        String[] arrInput = read.readLine().split("\s");
        // Initializing array-1 with the user array input
        arr1[testCaseNum] = new int[arr1Size[testCaseNum]];
        for(int i=0; i<arrInput.length; ++i)
            arr1[testCaseNum][i] = Integer.parseInt(arrInput[i]);
        System.out.print("Enter array-2 elements(space separated): ");
        arrInput = read.readLine().split("\s");
        // Initializing array-2 with the user array input
        arr2[testCaseNum] = new int[arr2Size[testCaseNum]];
        for(int i=0; i<arrInput.length; ++i)
            arr2[testCaseNum][i] = Integer.parseInt(arrInput[i]);
    }

    public static void runTestCase(int caseNum) throws IOException  {
        System.out.println("\n*** caseNum."+(caseNum+1)+" ***");
        // Printing the array before performing operations
        System.out.print("Array-1: ");  
        printArray(arr1[caseNum]);
        System.out.print("Array-2: ");  
        printArray(arr2[caseNum]);
        // Find Intersection of 2 arrays
        intersection[caseNum] = getIntersection(arr1[caseNum], arr2[caseNum]);
        // Printing the result
        System.out.print("Intersection: ");  
        if(intersection[caseNum].size()>0)
			printArray(intersection[caseNum].toArray());
        else
        	System.out.println("-1");;
        System.out.println("=================================="); 
    }

    public static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int i=0, j=0;
    	for(; i<arr1.length && j<arr2.length; ) {
    		if(arr1[i]==arr2[j]){
    			result.add(arr1[i]);
    			++i;
    			++j;
    		}
    		else if(arr1[i]<arr2[j])
    			++i;
    		else
    			++j;
    	}
    	return result;
    }

    public static void printArray(Object[] objects) {
        // Traversing the Object array  
        for(int i=0; i<objects.length; ++i) 
            System.out.print(objects[i] + " ");  
        System.out.println();   
    }

    public static void printArray(int[] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i] + " ");  
        System.out.println();   
    }
    
}
