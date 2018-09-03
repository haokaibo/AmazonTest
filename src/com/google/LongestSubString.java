package com.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class LongestSubString {


    public String findLongestSubString(String origin, int k) {
        char[] chars = origin.toCharArray();
        int startPos = 0;
        int maxLen = 0;
        int len = 0;
        int firstLastLen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] keys = new char[k];
        int firstkeyIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (!hm.containsKey(chars[i])) {
                hm.put(chars[i], i);
                if (hm.size() > k) {
                    if (len > maxLen) {
                        maxLen = len;
                        startPos = hm.get(keys[firstkeyIndex]);
                    }
                    hm.remove(keys[firstkeyIndex]);
                    firstkeyIndex = (firstkeyIndex + 1) % k;
                    len = len - firstLastLen;
                    firstLastLen = 0;
                }
                keys[i % k] = chars[i];
            }
            len++;
            if (hm.size() == 1) {
                firstLastLen++;
            }
        }

        return origin.substring(startPos, startPos + maxLen);
    }

    public static void main(String[] args) {
        String substring = new LongestSubString().findLongestSubString("abcbccccba", 2);
        System.out.println(substring);
    }

}
