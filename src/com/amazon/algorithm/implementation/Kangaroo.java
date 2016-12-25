package com.amazon.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-25.
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        boolean result = canCacthUp(x1, v1, x2, v2);
        System.out.println(result ? "YES" : "NO");
    }

    public static boolean canCacthUp(int x1, int v1, int x2, int v2) {
        // formula: if x1 + v1 * t == x2 + v2 * t they can meet.
        if (x2 == x1) {
            return true;
        }
        if (v1 == v2)
            return false;
        if ((x2 - x1) / (v1 - v2) >= 0 && (x2 - x1) % (v1 - v2) == 0) {
            return true;
        }
        return false;
    }
}
