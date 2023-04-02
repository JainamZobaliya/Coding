package Recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * RatInMaze
 * Problem Statement: To return power set of the given array.
 * 	Example:
 * 		Test Case 1: 
 * 			Input Array: 1 2 3
 * 			Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *		Test Case 2: 
 * 			Input Array: 1 2
 * 			Output: [[],[1],[2],[1,2]]
 *		Test Case 3: 
 * 			Input Array: 1
 * 			Output: [[],[1]]
 */

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n*n)
 */

public class RatInMaze {
    static int testCaseSize, arr[][][], source[][], destination[][];

    public static void main(String[] args) throws IOException  {
        // Taking array Input from user
        takeTestCaseInput();
        for(int i=0; i<testCaseSize; ++i) {
            // run ith test Case
            runTestCase(arr[i], source[i], destination[i]);
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
        arr = new int[testCaseSize][][];
        source = new int[testCaseSize][2];
        destination = new int[testCaseSize][2];
        for(int i=0; i<testCaseSize; ++i) {
            int arrSizeLength = -1;
            int arrSizeBreadth = -1;
	        do{
	            try{
	                System.out.print("Enter Length of Maze: ");
	                arrSizeLength = Integer.parseInt(read.readLine());
	                System.out.print("Enter Breadth of Maze: ");
	                arrSizeBreadth = Integer.parseInt(read.readLine());
	            } catch (Exception err) {
	                System.out.println("Error: " + err);
	            }
	        } while(arrSizeLength<=0 && arrSizeBreadth<=0); 
	        // Instantiation array with the user input arrSize
	        arr[i] = new int[arrSizeLength][arrSizeBreadth];
	        for(int row=0; row<arrSizeLength; ++row) {
		        System.out.print("Enter the maze elements for (row-"+row+"): ");
		        String[] arrInput = read.readLine().split("\s");
		        // Initializing array with the user array input
		        for(int j=0; j<arrSizeBreadth; ++j)
		            arr[i][row][j] = Integer.parseInt(arrInput[j]);
	        }
            System.out.print("Enter coordinates of source (X and Y): ");
	        String[] arrInput = read.readLine().split("\s");
            source[i][0] = Integer.parseInt(arrInput[0]);
            source[i][1] = Integer.parseInt(arrInput[1]);
            System.out.print("Enter coordinates of destination (X and Y): ");
	        arrInput = read.readLine().split("\s");
            destination[i][0] = Integer.parseInt(arrInput[0]);
            destination[i][1] = Integer.parseInt(arrInput[1]);
	    }
    }

    private static void runTestCase(int[][] maze, int[] source, int[] destination) throws IOException  {
        // Printing the Maze
        System.out.println("Maze: ");  
        printArray(maze);
        System.out.println("Source: " + source[0] + " " + source[1]); 
        System.out.println("Destination: " + destination[0] + " " + destination[1]); 
        // Creating a maze to track cell visited or not
        int[][] visited = new int[maze.length][maze[0].length];
    	visited[0][0] = 1; // Source is Visited
        // Finding All Possible Routes
        ArrayList<String> result = getPossibleRoutes(source[0], source[1], new StringBuilder(""), visited, maze, destination, new ArrayList<String>());
        // Printing the result
        printArrayList(result);
        System.out.println("=================================="); 
    }
    
    private static ArrayList<String> getPossibleRoutes(int x, int y, StringBuilder route, int[][] visited, int[][] maze, int[] destination, ArrayList<String> result) {
    	visited[x][y] = 1; // Marking the current cell as visited
    	// Base Case
    	// If destination or source is marked as 0		
    	if ((maze[destination[0]][destination[1]] == 0) || (maze[x][y] == 0)) {
        	result.add("-1"); // Adding the Flag -> -1 
            return result;
        }
    	// If source is destination	
    	if (destination[0] == x && destination[1] == y && route.length() == 0) {
        	result.add("0"); // Adding the Flag -> 0 
            return result;
        }
    	// If we have reached destination		
    	if (x == destination[0] && y == destination[1] && !result.contains(route.toString())) {
        	result.add(route.toString()); // Adding the current route
            return result;
        }
    	// Recursive Relation
        if(x+1 < maze.length && maze[x+1][y] == 1 && visited[x+1][y] != 1) { // Move Down
        	result = getPossibleRoutes(x+1, y, route.append("D"), visited, maze, destination, result);
        	// BackTracking
        	visited[x+1][y] = 0; // Marking the previously visited cell as unvisited.
        	route.deleteCharAt(route.length()-1); // Removing the previous route.
        }
        if(y-1 >= 0 && maze[x][y-1] == 1 && visited[x][y-1] != 1) { // Move Left
        	result = getPossibleRoutes(x, y-1, route.append("L"), visited, maze, destination, result);
        	// BackTracking
        	visited[x][y-1] = 0; // Marking the previously visited cell as unvisited.
        	route.deleteCharAt(route.length()-1); // Removing the previous route.
        }
        if(y+1 < maze[0].length && maze[x][y+1] == 1 && visited[x][y+1] != 1) { // Move Right
        	result = getPossibleRoutes(x, y+1, route.append("R"), visited, maze, destination, result);
        	// BackTracking
        	visited[x][y+1] = 0; // Marking the previously visited cell as unvisited.
        	route.deleteCharAt(route.length()-1); // Removing the previous route.
        }
        if(x-1 >= 0 && maze[x-1][y] == 1 && visited[x-1][y] != 1) { // Move Up
        	result = getPossibleRoutes(x-1, y, route.append("U"), visited, maze, destination, result);
        	// BackTracking
        	visited[x-1][y] = 0; // Marking the previously visited cell as unvisited.
        	route.deleteCharAt(route.length()-1); // Removing the previous route.
        }
        return result;
    }

    private static void printArrayList(ArrayList<String> arr) {
    	if(arr.size()== 0) {
    		System.out.println("Destination cannot be reached from the given Source!");
    		return;
    	}
    	else if(arr.get(0) == "-1") {
    		System.out.println("Destination or Source is marked as 0!");
    		return;
    	}
    	else if(arr.get(0) == "0") {
    		System.out.println("Destination and Source are Same!");
    		return;
    	}
        // Traversing the ArrayList  
    	System.out.println("Total Available Routes: "+arr.size());
    	System.out.println("Rollowing are the routes: ");
        for(int i=0; i<arr.size(); ++i) {
    		System.out.println("\t"+arr.get(i));
        }
    }

    private static void printArray(int[][] arr) {
        // Traversing the array  
        for(int i=0; i<arr.length; ++i) {
            for(int j=0; j<arr[i].length; ++j) 
            	System.out.print(arr[i][j] + " ");  
        	System.out.println();   
    	}
    }
    
}
