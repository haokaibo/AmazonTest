package com.amazon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class Fibonacci {

    public static int a(int n){
        int[] a = new int[n];
        a[0] =1;
        return a[0];
    }


    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        return fibonacci(n, cache);
    }

    private static int fibonacci(int n, int[] cache) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (cache[n] != 0)
            return cache[n];
        cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return cache[n];
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.close();
//        System.out.println(fibonacci(n));
        int[] a = new int[]{0, 1};
        System.out.println(Arrays.toString(a));
    }
}
