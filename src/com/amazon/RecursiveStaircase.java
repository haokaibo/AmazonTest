package com.amazon;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class RecursiveStaircase {
    public static int checkClimbWay(int stairs) {
        int[][] ways = new int[stairs + 1][stairs + 1];
        for (int row = 0; row < stairs + 1; row++) {
            ways[row][0] = 1;
        }
        for (int row = 1; row < stairs + 1; row++) {
            System.out.format("%d: ", row);
            for (int col = 1; col < stairs + 1; col++) {
                int left = col - row;
                ways[row][col] = ways[row - 1][col];
                if (left >= 0) {
                    ways[row][col] += ways[row][left];
                    if (row > 1 && left > 0)
                        ways[row][col] += 1;
                }
                System.out.format("%d ", ways[row][col]);
            }
            System.out.println();
        }

        return ways[stairs][stairs];
    }

    public static int checkClimbWay2(int stairs, int step, int[][] memo) {
        if (stairs >= 0 && step >= 0 && memo[stairs][step] >= 0)
            return memo[stairs][step];
        if (stairs == 0) {
            memo[stairs][step] = 1;
            return 1;
        } else {
            if (step <= 0) {
                memo[stairs][step] = 0;
                return 0;
            }
            int ways = checkClimbWay2(stairs, step - 1, memo);
            if (stairs == step) {
                ways += 1;
            } else if (stairs > step) {
                ways += checkClimbWay2(stairs - step, step, memo);
                if (step > 1) {
                    ways += 1;
                }
            }
            memo[stairs][step] = ways;
            return ways;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(checkClimbWay(n));
        }
    }
}
