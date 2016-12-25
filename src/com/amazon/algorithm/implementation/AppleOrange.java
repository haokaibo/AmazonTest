package com.amazon.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-25.
 */
public class AppleOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }

        // get apples
        int apples = countFruits(s,t, apple, a);
        System.out.println(apples);
        int oranges = countFruits(s,t, orange, b);
        System.out.println(oranges);
    }

    public static int countFruits(int houseBegin, int houseEnd, int[] fruits, int treePosition) {
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (treePosition + fruits[i] >= houseBegin && treePosition + fruits[i] <= houseEnd) {
                count++;
            }
        }
        return count;
    }
}
