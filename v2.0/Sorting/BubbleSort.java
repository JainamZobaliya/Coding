/**
 * Bubble Sort Algorithm
 * 
 * After an iteration, the largest element of the unsorted array is placed at its correct sorted position.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 */

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 80, 17, 20, 6, 45};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

    /**
     * Swaps element present at index i with element present at index j in array arr.
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int arr[], int i, int j) {
        if (i == j) {
            return;
        }
        System.out.println("\t\t\t Swapping " + arr[i] + " and " + arr[j]);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println("\t\t\t After Swapping " + Arrays.toString(arr));
    }

    /**
     * Sorts the given array arr using Bubble Sort algorithm.
     * @param arr
     */
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (n-1-i); ++j) {
                int element1 = arr[j];
                int element2 = arr[j+1];
                System.out.println("\t\t Comparring " + element1 + " and " + element2);
                if (element1 > element2) {
                    swap(arr, j, j+1);
                }
            }
            // After the iteration, we get the largest element's index. from arr [0 to n-i]
            System.out.println("\t After Itr-" + (i+1) + ": " + Arrays.toString(arr));
            // After swapping, the largest element of the arr[0 to n-i] is at its correct sorted position.
        }
    }

}
