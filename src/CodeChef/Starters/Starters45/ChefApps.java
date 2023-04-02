package CodeChef.Starters.Starters45;

import java.io.*;
/**
 * ChefApps
 * Problem Statement: To return no. of apps to be uninstalled.
 * URL: https://www.codechef.com/START45D/problems/CHEFAPPS
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 10 1 2 3
 * 			Output: 0
 *		Test Case 2: 
 * 			Input Array: 9 4 5 1
 * 			Output Array: 1
 *		Test Case 2: 
 * 			Input Array: 15 5 10 15
 * 			Output: 2
 */

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class ChefApps {
	static int testCaseSize, data[][], countOfAppsToUnInstall[];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        runTestCase();
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
        data = new int[testCaseSize][4];
        countOfAppsToUnInstall = new int[testCaseSize];
        // Take input for all test cases
        for(int i=0; i<testCaseSize; ++i) {
            String[] arrInput = read.readLine().split("\\s");
            // Initializing array with the user array input
            data[i][0] = Integer.parseInt(arrInput[0]); // S
            data[i][1] = Integer.parseInt(arrInput[1]); // X
            data[i][2] = Integer.parseInt(arrInput[2]); // Y
            data[i][3] = Integer.parseInt(arrInput[3]); // Z
        }
    }

    public static void runTestCase() throws IOException  {
        // Get No. of Apps To be unInstalled
        getCountOfApps();
        // Printing Best Of Two Scores
        printArray(countOfAppsToUnInstall);
    }

    private static void getCountOfApps() {
        for(int i=0; i<testCaseSize; ++i) {
            int s = data[i][0]; // S
            int x = data[i][1]; // X
            int y = data[i][2]; // Y
            int z = data[i][3]; // Z
        	int totalInstalledAppsSize = x+y; // X+Y => Total Size of Two Installed Apps
//            System.out.println("totalInstalledAppsSize: " + totalInstalledAppsSize);
//            System.out.println("s-totalInstalledAppsSize: " + (s-totalInstalledAppsSize));
            if((s-totalInstalledAppsSize)>=z)
            	countOfAppsToUnInstall[i]=0;
            else if( (z<=(s-x)) || (z<=(s-y)) )
            	countOfAppsToUnInstall[i]=1;
            else
            	countOfAppsToUnInstall[i]=2;         	
        }
	}

    public static void printArray(int arr[]) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) 
            System.out.println(arr[i]);  
        System.out.println();   
    }

}
