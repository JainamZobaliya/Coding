package CodeChef.Starters.Starters46;

import java.io.*;
import java.util.Arrays;
/**
 * GroupAssignment
 * Problem Statement: To find if Chef can assign every person to a group such that everyone remains happy.
 * URL: https://www.codechef.com/START46D/problems/GRPASSN
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 2 3 2 3 3
 * 			Output: YES
 *		Test Case 2: 
 * 			Input Array: 5 5 5 5 5
 * 			Output: YES
 *		Test Case 3: 
 * 			Input Array: 3 2 2 3 2
 * 			Output: NO
 *		Test Case 4: 
 * 			Input Array: 4 4 4 3
 * 			Output: NO
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class GroupAssignment {
	static int testCaseSize, arrSize[], arr[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) 
        	runTestCase(arr[i]);
    }

    private static void takeTestCaseInput() throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        // Taking a valid test Case Size - input
        do{
            try{
            	// System.out.print("Enter no. Of test Cases: ");
                testCaseSize = Integer.parseInt(read.readLine());
            } catch (Exception err) {
                System.out.println("Error: " + err);
            }
        } while(testCaseSize<=0);
        arrSize = new int[testCaseSize]; 
        arr = new int[testCaseSize][];
        // taking array input for each testCase
        for(int i=0; i<testCaseSize; ++i) {
            arrSize[i] = Integer.parseInt(read.readLine()); 
            arr[i] = new int[arrSize[i]];
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            for(int j=0; j<arrSize[i]; ++j) {
            	arr[i][j] = Integer.parseInt(arrInput[j]); // Pj
            }
        }
    }

    public static void runTestCase(int[] arr) throws IOException  {
        // Chef assigns everyone to grp
    	boolean result = chefAssign(arr);
        // Printing the result
        System.out.println(result ? "YES" : "NO");
    }
    
    public static boolean chefAssign(int[] arr) {
    	boolean result = false;
    	Arrays.sort(arr);
    	int count = 1;
    	for(int i=1; i<arr.length; ++i) {
    		if(arr[i] == arr[i-1])
    			++count;
    		else {
    			result = inspect(arr[i-1], count);
    			if(result)
    				count = 1;
    			else
    				return result;
    		}
    	}
		result = inspect(arr[arr.length-1], count);
    	return result;    	
    }
    
    public static boolean inspect(int num, int count) {
    	boolean result = false;
    	double personPerGrp = (double) num / count;
		if(Math.ceil(personPerGrp) == 1.0 && Math.floor(personPerGrp) == 1.0) {
			result = true;
			count = 1;
		}
		else {
			result = false;
		}
		return result;
    }

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");  
        System.out.println();   
    }

}

