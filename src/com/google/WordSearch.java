package com.google;

public class WordSearch {
    public static int findWords(char[][] chars, char[] keyword) {
        if (chars == null || keyword == null || chars.length == 0 || keyword.length == 0) {
            return 0;
        }
        int verticalLength = chars.length;
        int horizonLength = chars[0].length;
        int totalChars = horizonLength * verticalLength;

        if (totalChars < keyword.length) {
            return 0;
        }

        int totalMatches = 0;
        int current = 0;

        while (current < totalChars) {
            int i = 0;
            for (; i < keyword.length; i++) {
                if (chars[current / horizonLength][current % horizonLength] != keyword[i]) {
                    if (i == 0)
                        current++;
                    break;
                }
                current++;
            }
            if (i == keyword.length) {
                totalMatches++;
            }
        }

        return totalMatches;
    }

    public static void main(String[] args) {
        int result = findWords(new char[][]{
                        {'A', 'B', 'X', 'D', 'W', 'O', 'R', 'W'},
                        {'W', 'O', 'R', 'D', 'S', 'E', 'U', 'W'},
                        {'O', 'R', 'H', 'W', 'O', 'R', 'D', 'S'},
                        {'R', 'S', 'E', 'I', 'J', 'E', 'E', 'S'},
                        {'D', 'E', 'R', 'G', 'H', 'I', 'R', 'K'},
                        "SIEPRSEU".toCharArray()},
                "WORD".toCharArray());
        System.out.println(result);
    }
}
