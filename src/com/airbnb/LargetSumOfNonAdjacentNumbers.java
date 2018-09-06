package com.airbnb;

public class LargetSumOfNonAdjacentNumbers {

    /*
    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0
    or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we
    pick 5 and 5.

    Follow-up: Can you do this in O(N) time and constant space?

    [x]:
        -> evenSum+= arr[i]
    odd [x o x]:
        oddSum - arr[i-1] >= evenSum -> [x o o x] (oddSum += arr[i]- arr[i-1])
        else:
            else: -> [o x o x (evenSum += arr[i]]

    even [x o]:
        oddSum += arr[i]
         [x o o x]:
         oddSum > evenSum + arr[i-1]

    if the sum of x is greater than o then take the xes or the oes.
     */
    public int getLargestSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int evenSum = 0;
        int oddSum = arr[0];
        boolean oddMod = false;
        for (int i = 1; i < arr.length; i++) {
            if (i == 1)
                evenSum += arr[i];
            else if (i % 2 != 0) { // odd scenario
                if (arr[i] > arr[i - 1]) {
                    oddSum += arr[i] - arr[i - 1];
                    oddMod = true;
                }
                evenSum += arr[i];
            } else {
                if (arr[i] > arr[i - 1]) {
                    if (oddMod) {
                        oddSum = oddSum - arr[i - 1] + arr[i - 2];
                        oddMod = false;
                    }
                }
                oddSum += arr[i];
            }
        }

        return oddSum >= evenSum ? oddSum : evenSum;
    }

    public static void main(String[] args) {
        int maxSum = new LargetSumOfNonAdjacentNumbers().getLargestSum(new int[]{3, 1, 0, 0, -1, 0, 0, 1, 3});
        System.out.println(maxSum);
    }
}
