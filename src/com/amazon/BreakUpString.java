package com.amazon;

import java.util.ArrayList;
import java.util.List;

public class BreakUpString {
    public static String[] breakUp(String str, int k) {
        if (str != null && str.length() > 0) {
            List<String> breakUpWords = new ArrayList<>();
            String[] words = str.split(" ");
            for (int i = 0; i < words.length; ) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[i]);
                int joinedWordLength = words[i].length();

                if (sb.length() < k) {
                    int j = i + 1;
                    for (; j < words.length; j++) {
                        joinedWordLength += words[j].length() + 1;
                        if (joinedWordLength > k) {
                            break;
                        } else {
                            sb.append(" ").append(words[j]);
                        }
                    }
                    i = j;
                } else {
                    i++;
                }
                breakUpWords.add(sb.toString());
            }
            return breakUpWords.toArray(new String[0]);
        }
        return null;
    }
}
