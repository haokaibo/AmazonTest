package com.amazon.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by kaibohao on 2016-12-25.
 */
public class DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for (int h_i = 0; h_i < n; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int maxHeight = 0;
        int wordWidth = 1;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            int height = h[index];
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        int area = word.length() * wordWidth * maxHeight;
        System.out.println(area);
    }
}
