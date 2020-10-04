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
public class WordSearch2 {

    public static void main(String[] args) {
        char[][] text = {"ABXDWHOW".toCharArray(),
                "WORDSEUW".toCharArray(),
                "ORDWORDS".toCharArray(),
                "RSEIJEES".toCharArray(),
                "DERGHIRK".toCharArray(),
                "SIEPRSEU".toCharArray()};
        String keyword = "WORD";
        int result = findWord(text, keyword.toCharArray());
        System.out.println(result);

    }

    public static int findWord(char[][] text, char[] keyword) {
        int totalMatch = 0;

        if (text == null || text.length == 0)
            return 0;
        int textVerticalLen = text.length;
        int textHorizonLen = text[0].length;
        int totalChars = textVerticalLen * textHorizonLen;
        int keywordLen = keyword.length;

        if (keywordLen == 0 || keywordLen > totalChars)
            return 0;

        for (int i = 0; i < totalChars; i++) {
            int current = i;
            int j = 0;
            for (; j < keywordLen; j++, current++) {
                if (text[current / textHorizonLen][current % textHorizonLen] != keyword[j])
                    break;
            }
            if (j == keywordLen)
                totalMatch++;
        }
        return totalMatch;
    }

}
