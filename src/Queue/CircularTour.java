package Queue;

import java.util.*;
import java.io.*;

/**
 * CircularTour
 * Problem Statement: To find a starting point where the truck can start to get through the complete circle
 * without exhausting its petrol in between.
 * 	Example:
 * 		Test Case 1: 
 * 			Input N: 4 
 * 			Input Petrol: 4 6 7 4 
 * 			Input Distance: 6 5 3 5
 * 			Output: 1
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CircularTour {

    public static void main(String[] args) throws IOException  {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader read = new BufferedReader(inputStreamReader);
        System.out.print("Enter the no. of petrol pumps: ");
        int n = Integer.parseInt(read.readLine());
        System.out.print("Enter the array of petrol: ");
    	String[] petrolStr = read.readLine().split("\\s");
        System.out.print("Enter the array of distance: ");
    	String[] distanceStr = read.readLine().split("\\s");
    	int[] petrol = new int[n];
    	int[] distance = new int[n];
    	for(int i=0; i<n; i++) {
    		petrol[i] = Integer.parseInt(petrolStr[i]);
    		distance[i] = Integer.parseInt(distanceStr[i]);
    	}
    	System.out.print("Petrol: ");
    	printArray(petrol);
    	System.out.print("Distance: ");
    	printArray(distance);
    	int startingPoint = getStartingPoint(petrol, distance, n);
    	System.out.println("Starting Point: " + startingPoint);
    }
    
    private static int getStartingPoint(int[] petrol, int[] distance, int n) {
    	int startingPoint = 0;
    	int deficit = 0;
    	int balance = 0;
    	for(int i=0; i<n; i++) {
    		balance += petrol[i] - distance[i];
    		System.out.print(i+"--> "+balance+" ");
    		if(balance<0) {
    			deficit += balance;
    			balance = 0;
    			startingPoint = i+1;
    		}
    		System.out.println(deficit+" "+startingPoint);
    	}
    	if(deficit + balance >=0)
    		return startingPoint;
    	return -1;
    }    
    
    private static void printArray(int[] arr) {
    	for(int i=0; i<arr.length; i++) {
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }
}

