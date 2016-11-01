package com.amazon;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kaibohao on 2016-10-15.
 */
public class RepetitiveKSum {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            // the first number
            a[0] = in.nextInt() / k;
            for (int j = 1; j < n; j++) {
                a[j] = in.nextInt() - a[0] * (k - 1);
            }
            result.add(a);
            in.nextLine();
        }
        // output the result
        for (int[] a : result) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(String.format("%d ", a[i]));
            }
            System.out.println();
        }
    }
}
