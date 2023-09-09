/**
 * Selection Sort Algorithm
 * 
 * After an iteration, the smallest element of the unsorted array is placed at its correct sorted position.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 */

import java.util.Arrays;

public class SelectionSort {
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
     * Sorts the given array arr using Selection Sort algorithm.
     * @param arr
     */
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int indexMin = i;
            for (int j = i + 1; j < n; ++j) {
                int element1 = arr[indexMin];
                int element2 = arr[j];
                System.out.println("\t\t Comparring " + element1 + " and " + element2);
                if (arr[indexMin] > element2) {
                    indexMin = j;
                }
            }
            // After the iteration, we get the smallest element's index. from arr [j to n]
            swap(arr, i, indexMin);
            System.out.println("\t After Itr-" + (i+1) + ": " + Arrays.toString(arr));
            // After swapping, the smallest element of the arr[i to n] is at its correct sorted position.
        }
    }

}
