package Recursion;

/**
 * HeadTailRecursion
 * Problem Statement: To understand Head and Tail Recursion.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class HeadTailRecursion {
	static int testCaseSize, arr[];

	public static void main(String[] args)  {
		System.out.println("*** Head Recursion ***");
    	headRecursion(10);
		System.out.println("\n*** Tail Recursion ***");
    	tailRecursion(10);
	}
	
	private static void headRecursion(int n)  {
		// Base Case
		if(n == 0)
			return;
		// Recursive Relation
		headRecursion(n-1);
		// Processing Part
		System.out.print(n+" ");
	}
	
	private static void tailRecursion(int n)  {
		// Base Case
		if(n == 0)
			return;
		// Processing Part
		System.out.print(n+" ");
		// Recursive Relation
		tailRecursion(n-1);
	}

}




