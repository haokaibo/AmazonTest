package com.amazon;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaibohao on 2016-10-18.
 */
public class Anagrams {
    public static int numberNeeded(String first, String second) {
        HashMap<String, Integer> reviewedCharMap = new HashMap<>();
        // 1. Iterate the character of the first one to construct the dictionary.
        String currentChar = null;
        int totalGapCount = 0;
        for (int i = 0; i < first.length(); i++) {
            currentChar = first.substring(i, i + 1);
            if (reviewedCharMap.containsKey(currentChar))
                reviewedCharMap.put(currentChar, reviewedCharMap.get(currentChar) + 1);
            else
                reviewedCharMap.put(currentChar, 1);
        }
        // 3. Iterate the other one with the dictionary to add the new character and decrease the count which in dictionary before.
        for (int i = 0; i < second.length(); i++) {
            currentChar = second.substring(i, i + 1);
            if(reviewedCharMap.containsKey(currentChar))
                reviewedCharMap.put(currentChar, reviewedCharMap.get(currentChar) - 1);
            else
                reviewedCharMap.put(currentChar, -1);
        }

        // 4. Iterate the dictionary to count
        for (int v : reviewedCharMap.values()){
            totalGapCount += Math.abs(v);
        }
        return totalGapCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
