package com.google;

/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function
that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive
integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class ClimbStairs {

    public static int findWays(int N, int[] steps) {
        int totalWays = 0;
        if (N < 0 || steps == null || steps.length == 0)
            return 0;
        else if (N == 0)
            return 1;
        for (int s : steps) {
            totalWays += findWays(N - s, steps);
        }

        return totalWays;
    }

    public static int findWaysWithoutDuplicates(int N, int[] steps, int index) {
        int totalWays = 0;
        if (N < 0 || steps == null || steps.length == 0 || index >= steps.length)
            return 0;
        else if (N == 0)
            return 1;
        for(int i = index; i< steps.length; i++) {
            totalWays += findWaysWithoutDuplicates(N - steps[i], steps, i);
        }

        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(findWays(4, new int[]{1, 2}));
        System.out.println(findWaysWithoutDuplicates(4, new int[]{1, 2}, 0));
    }
}
