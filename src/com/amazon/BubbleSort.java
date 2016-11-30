package com.amazon;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(String.format("Array is sorted in %d swaps.", bubbleSort.sort(arr)));
        System.out.println(String.format("First Element: %d", arr[0]));
        System.out.println(String.format("Last Element: %d", arr[arr.length - 1]));
    }

    public static int sort(int[] a) {
        int n = a.length;
        int totalNumberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                    totalNumberOfSwaps++;
                }
            }
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        return totalNumberOfSwaps;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
