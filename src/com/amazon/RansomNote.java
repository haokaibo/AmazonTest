package com.amazon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-2.
 */
public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        if (isFromMagazine(magazine, ransom)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static Boolean isFromMagazine(String[] magazine, String[] ransom) {
        if (magazine == null && ransom == null || magazine.length == 0 && ransom.length == 0)
            return true;
        if (magazine == null || magazine.length == 0 || magazine.length < ransom.length)
            return false;
        HashMap<String, Integer> dic = new HashMap<>();

        for (String w : magazine) {
            if (dic.containsKey(w)) {
                dic.put(w, dic.get(w) + 1);
            } else {
                dic.put(w, 1);
            }
        }

        for (String w : ransom) {
            if (dic.containsKey(w)) {
                int currentCount = dic.get(w) - 1;
                if (currentCount < 0)
                    return false;
                else
                    dic.put(w, currentCount);
            } else
                return false;
        }
        return true;
    }
}
