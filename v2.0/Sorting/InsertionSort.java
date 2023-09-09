
/**
 * Insertion Sort Algorithm
 * 
 * To sort an array of size N in ascending order iterate over the array and compare the current element (key) to its predecessor, if the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 */

import java.util.Arrays;

public class InsertionSort {
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
     * Sorts the given array arr using Insertion Sort algorithm.
     * @param arr
     */
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i-1;
            System.out.println("\t\t Comparring " + key + " and " + arr[j]);
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                System.out.println("\t\t\t arr[" + (j+1) + "] = " + arr[j]);
                j--;
                if (j < 0) {
                    break;
                }
                System.out.println("\t\t Comparring " + key + " and " + arr[j]);
            }
            arr[j+1] = key;
            System.out.println("\t After Itr-" + (i+1) + ": " + Arrays.toString(arr));
        }
    }

}
