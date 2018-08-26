package com.google;

import java.util.HashMap;
import java.util.HashSet;

public class TotalCombination {


    public static void main(String[] args) {
        System.out.println(find(new int[]{2, 4, 6, 12}, 12));
    }

    // [2, 4, 6, 12] => 12

    public static int find(int[] arr, int total) {
        if (arr == null || arr.length == 0)
            return 0;

        HashMap<String, Integer> mem = new HashMap<>();
        int result = helper(arr, total, arr.length - 1, mem);
        return result;
    }

    private static int helper(int[] arr, int total, int index, HashMap<String, Integer> mem) {
        String key = String.format("%d:%d", total, index);
        int result = 0;

        if (mem.containsKey(key))
            return mem.get(key);
        if (total == 0)
            return 1;
        else if (total < 0)
            return 0;
        else if (index < 0)
            return 0;
        else if (total < arr[index])
            result = helper(arr, total, index - 1, mem);
        else
            result = helper(arr, total, index - 1, mem) + helper(arr, total - arr[index], index - 1, mem);
        mem.put(key, result);
        return result;
    }
}
