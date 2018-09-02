package com.google;

import java.util.HashSet;

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
