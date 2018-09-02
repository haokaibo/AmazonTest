package com.google;

import java.util.HashSet;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

public class SumToK {
    public static boolean hasSumToK(int[] arr, int sum){
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            if (hs.contains(arr[i]))
                return true;
            else
                hs.add(sum - arr[i]);
        }

        return false;
    }

    public static void main(String[] args){
        boolean result = hasSumToK(new int[]{10, 15, 3, 7}, 17);
        System.out.println(result);
    }
}
