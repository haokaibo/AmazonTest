package com.google;

import java.util.ArrayList;
import java.util.List;

public class SumSubsetToK {

    public List<Integer> getSubsetSumToK(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            if (k < arr[i])
                continue;
            else if (k == arr[i]) {
                subset.add(arr[i]);
                return subset;
            } else if (k > arr[i]) {
                subset.add(arr[i]);
                List<Integer> laterSubset = getSubsetSumToK(arr, k - arr[i]);
                if (laterSubset == null)
                    continue;
                else
                    subset.addAll(laterSubset);
                return subset;
            }
        }
        return null;
    }
}
