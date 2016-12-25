package com.amazon.algorithm.warmup;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-25.
 */
public class SimpleArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        long sum = sumArray(array);
        System.out.println(sum);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

    private static long sumArray(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
