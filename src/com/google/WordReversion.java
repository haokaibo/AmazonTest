package com.google;

/*
Date: 12/13/2018
author: Kaibo
Daily Coding Problem: Problem #113

Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?
 */
public class WordReversion {
    public final static String SPLITTER = " ";

    public static String simpleReverse(String origin) {
        if (origin == null || origin.isEmpty()) {
            return origin;
        }
        String[] words = origin.split(SPLITTER);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            if (i > 0) {
                stringBuilder.append(SPLITTER);
            }
        }
        return stringBuilder.toString();
    }
}
