package com.amazon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class Primality {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            if (checkPrimality(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    private static boolean checkPrimality(int n) {
        if (n == 0 || n == 1)
            return false;
        boolean[] numbers = new boolean[n + 1];
        Arrays.fill(numbers, true);
        for (int i = 2; i < Math.sqrt(numbers.length); i++) {
            if (!numbers[i])
                continue;
            else {
                for (int j = 2; i * j < numbers.length; j++) {
                    numbers[i * j] = false;
                    if (i * j == n)
                        return false;
                }
            }
        }
        boolean result = numbers[n];
        return result;
    }
}
