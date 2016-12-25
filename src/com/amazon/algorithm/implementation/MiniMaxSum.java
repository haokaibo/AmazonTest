package com.amazon.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-25.
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 5;
        long[] array = new long[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextLong();
        }
        long sum = 0;
        long min = 0;
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0)
                max = min = array[i];
            else {
                if (array[i] < min) {
                    min = array[i];
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }
            sum += array[i];
        }
        long minSum = sum - max;
        long maxSum = sum - min;
        System.out.format("%d %d", minSum, maxSum);
    }
}
