package com.google;

/*
Write a function in the language of your choice that accepts two parameters. The first parameter is a 2-dimensional
array of characters, and the second parameter a string which is the word we want to count.
An example would be the following inputs:
A B X D W H O W
W O R D S E U W
O R H W O R D S
R S E I J E E S
D E R G H I R K
S I E P R S E U
'WORDS'
This should return 3 (3 instances of WORDS)

 */
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
            for (int index = current; i < keyword.length && index < totalChars; i++, index++) {
                if (chars[index / horizonLength][index % horizonLength] != keyword[i]) {
                    break;
                }
            }
            if (i == keyword.length) {
                totalMatches++;
            }
            current++;
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
