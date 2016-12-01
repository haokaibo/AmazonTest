package com.amazon;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class MergeSort2 {
    public static int sort(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static int sort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) / 2;
        int leftTimes = sort(arr, temp, low, mid);
        int rightTimes = sort(arr, temp, mid + 1, high);
        int mergedTimes = merge(arr, temp, low, mid, high);
        return leftTimes + rightTimes + mergedTimes;
    }

    private static int merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int current = low;
        int left = low;
        int right = mid + 1;
        int swapTimes = 0;
        while (left <= mid && right <= high) {
            if (temp[left] <= temp[right]) {
                arr[current] = temp[left];
                left++;
            } else {
                arr[current] = temp[right];
                swapTimes += right - current;
                right++;
            }
            current++;
        }
        for (int i = left; i <= mid; i++) {
            arr[current] = temp[i];
            current++;
        }
        return swapTimes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int swaps = MergeSort2.sort(arr);
            System.out.println(swaps);
        }
    }
}
