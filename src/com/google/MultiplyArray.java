package com.google;

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all
 the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */

import java.util.Arrays;

public class MultiplyArray {

    public static int[] calculate(int[] arr) {
        int product = 1;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                result[i] = 0;
            else
                result[i] = product / arr[i];
        }
        return result;
    }

    public static int[] calculate2(int[] arr) {
        int product = 1;
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (j != i)
                    result[j] *= arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = calculate(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));

        result = calculate2(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }
}
