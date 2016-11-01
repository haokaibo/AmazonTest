package com.amazon;

import java.util.*;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        a = leftRotate(a, k);
        String format = "%d ";
        for (int i = 0; i < a.length; i++) {
            if (i + 1 == a.length) {
                format = "%d";
            }
            System.out.print(String.format(format, a[i]));
        }
    }

    public static int[] leftRotate(int[] a, int k) {
        int[] result = new int[a.length];
        int i = 0;
        for (; i < a.length; i++) {
            if (k == i) {
                int j = 0;
                for (; j < a.length - i; j++) {
                    result[j] = a[i + j];
                }
                for (int n = 0; n < i; n++) {
                    result[n + j] = a[n];
                }
                // 1, 2, 3, 4, 5
                // 2, 3, 4, 5, 1
                // 3, 4, 5, 1, 2
                break;
            }
        }
        return result;
    }
}

