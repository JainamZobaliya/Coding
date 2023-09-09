
/**
 * Merge Sort Algorithm
 * 
 * It works by dividing an array into smaller subarrays, sorting each subarray, and then merging the sorted subarrays back together to form the final sorted array.
 * 
 * Time Complexity of this approach is O(n^2 * log(n)) because merge is O(n^2) & Space Complexity is O(1).
 * 
 * Time complexity of standard merge sort is less, O(n Log n) with space complexity O(n).
 * 
 */

import java.util.Arrays;

public class MergeSort {
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
     * Sorts the given array arr using Merge Sort algorithm.
     * @param arr
     */
    public static void sort(int arr[]) {
        int n = arr.length-1;
        mergeSort(arr, 0, n, 0);
    }

    public static void mergeSort(int[] arr, int startPointer, int endPointer, int spaceBar) {
        if (startPointer >= endPointer) {
            // System.out.println("Returning since "+startPointer+" >= "+endPointer);
            return;
        }
        String space = "\t";
        for (int i = 0; i < spaceBar; ++i) {
            space += "\t";
        }
        int midPointer = (startPointer + ((endPointer - startPointer) / 2));
        // System.out.println(space+"Dividing arr from ["+startPointer+", "+endPointer+"] to ["+startPointer+", "+midPointer+"] and ["+(midPointer+1)+", "+endPointer+"]");
        // System.out.println(space+spaceBar+".1. mergeSort(arr, "+startPointer+", "+midPointer+")");
        mergeSort(arr, startPointer, midPointer, spaceBar+1);
        // System.out.println(space+spaceBar+".2. mergeSort(arr, "+(midPointer+1)+", "+endPointer+")");
        mergeSort(arr, midPointer+1, endPointer, spaceBar+1);
        // System.out.println(space+spaceBar+". merge(arr, "+(startPointer)+", "+(endPointer)+")");
        merge(arr, startPointer, endPointer, space);
    }

    public static void merge(int[] arr, int startPointer, int endPointer, String space) {
        int midPointer = (startPointer + ((endPointer - startPointer) / 2));
        // System.out.println(space + "Merging arr from [" + startPointer + ", " + midPointer + "] and [" + (midPointer+1) + ", " + endPointer + "]");
        // System.out.println(space + space + "(" + startPointer + ", " + endPointer + ") --> "+ Arrays.toString(arr));
        if ((midPointer + 1) > endPointer || arr[midPointer] <= arr[midPointer + 1]) { // Already sorted
            return;
        }
        int startPointer1 = startPointer;
        int startPointer2 = midPointer + 1;
        while (startPointer1 <= midPointer && startPointer2 <= endPointer) {
            if (arr[startPointer1] <= arr[startPointer2]) {
                startPointer1++;
            } else {
                int value = arr[startPointer2];
                int index = startPointer2;
                // Shifting all the elements between element 1 and element 2, right by 1.
                while (index != startPointer1) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[startPointer1] = value;
                // Update all the pointers
                startPointer1++;
                startPointer2++;
                midPointer++;
            }
        }
        // System.out.println(space + "Merged arr from [" + startPointer + ", " + endPointer + "]");
    }
}
