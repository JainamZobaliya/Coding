
/*
 * LC-1470: Shuffle the Array
 * Problem Statement: Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn]. Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * URL: https://leetcode.com/problems/shuffle-the-array/
 * 
 * Hint: 
 * How to store 2 numbers in the same array cell?
 * If there are two numbers n1 and n2, one could come up with a larger number M (greater than both n1 and n2) and store a single number having value V = M*n1+n2.
 * Later on, if we want to extract the 2 numbers from V, we can do so like so, n1 = V/M, n2 = V%M
 */
import java.util.Arrays;

public class LC_1470_ShuffleTheArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(arr));
        shuffle(arr, arr.length / 2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] shuffle(int[] nums, int n) {
        // TC: O(n)
        // SC: O(1)
        int max = 1024; // M in the above explanation

        // Store number pairs in right half
        for (int i = n; i < nums.length; i++) {
            // System.out.println("i: "+i);
            // System.out.println("\t("+nums[i-n]+", "+nums[i]+")");
            nums[i] = max * nums[i] + nums[i - n];
            // System.out.println("\t"+nums[i]);
        }
        System.out.println("\n");

        // Put pairs in proper positions
        int ind = 0;
        for (int i = n; i < nums.length; i++) {
            // System.out.println("i: "+i);
            // System.out.print("\t"+nums[i]);
            nums[ind] = nums[i] % max;
            nums[ind + 1] = nums[i] / max;
            // System.out.println(" --> ("+nums[ind]+", "+nums[ind+1]+")");
            ind += 2;
        }

        return nums;
    }
    
}
