package com.amazon;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class IceCreamParlor {
    public static int[] getIceCreamFlavors(int dollar, int[] costs) {
        int[] flavors = null;
        for (int i = 0; i < costs.length; i++) {
            int left = dollar - costs[i];
            int otherFlavor = findAvailableFlavor(left, costs, i + 1);
            if (otherFlavor != -1) {
                flavors = new int[2];
                flavors[0] = i + 1;
                flavors[1] = otherFlavor + 1;
                return flavors;
            }
        }
        return null;
    }

    private static int findAvailableFlavor(int dollar, int[] costs, int begin) {
        int left = begin;
        int right = costs.length - 1;
        while (left <= right) {
            if (costs[left] == dollar)
                return left;
            left++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int[] flavors = getIceCreamFlavors(m, a);
            if (flavors == null) {
                System.out.println("The money cannot buy enough flavors.");
            }
            for (int f : flavors) {
                System.out.print(String.format("%d ", f));
            }
            System.out.println();
        }
    }
}
