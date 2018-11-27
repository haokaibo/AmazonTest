package com.coursera;

import java.util.HashMap;

public class WordInGrid {
    public static boolean exists(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0)
            return false;

        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char key = board[i][j];
                int value = 0;
                if (dic.containsKey(key)) {
                    value = dic.get(key);
                }
                dic.put(key, value + 1);
            }
        }

        for (char c : word.toCharArray()) {
            if (dic.containsKey(c)) {
                int value = dic.get(c);
                if (value == 0) // not enough characters
                    return false;
                else
                    dic.put(c, value - 1);
            } else { // not found character
                return false;
            }
        }

        return true;
    }
}
