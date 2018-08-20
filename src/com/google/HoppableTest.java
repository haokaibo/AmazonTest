package com.google;

import java.util.HashSet;

public class HoppableTest {
    public static void main(String[] args) {
        int[] towers = new int[]{4, 2, 0, 0, 2, 0};
        System.out.println(isHoppable(towers));
    }

    public static boolean isHoppable(int[] towers) {
        HashSet<Integer> unhoppable = new HashSet<>();
        for (int i = 0; i < towers.length; i++) {
            if (isHoppable(i, towers, unhoppable)) {
                return true;
            }
        }
        return false;
    }

    // towers = [4, 2, 0, 0, 2, 0]
    private static boolean isHoppable(int current, int[] towers, HashSet<Integer> unhoppable) {
        if(unhoppable.contains(current)){
            return false;
        }
        for (int i = 1; i <= towers[current]; i++) {
            int nextStep = current + i;
            if (nextStep >= towers.length)
                return true;
            if (towers[nextStep] > 0) {
                return isHoppable(nextStep, towers, unhoppable);
            }
        }
        unhoppable.add(current);
        return false;
    }

}
