package com.google;

import java.util.Arrays;

public class RandomlyReorder {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 9, 7, 5, 0};
        System.out.println(Arrays.toString(arr));
        randomlyReorder(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void randomlyReorder(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int randomIndex = (int) Math.floor(i * Math.random());
            swap(arr, randomIndex, i);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
