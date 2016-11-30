package com.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class ComparatorSorting {
    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    class Checker implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if (o1 == o2)
                return 0;
            if (o1.score > o2.score)
                return -1;
            else if (o1.score < o2.score)
                return 1;
            else {
                int shortNameLength = Math.min(o1.name.length(), o2.name.length());
                for (int i = 0; i < shortNameLength; i++) {
                    if (o1.name.toCharArray()[i] > o2.name.toCharArray()[i])
                        return 1;
                    else if (o1.name.toCharArray()[i] < o2.name.toCharArray()[i])
                        return -1;
                }
                if (o1.name.length() < o2.name.length())
                    return -1;
                else if (o1.name.length() > o2.name.length())
                    return 1;
                else
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        ComparatorSorting comparatorSorting = new ComparatorSorting();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = comparatorSorting.new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = comparatorSorting.new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
