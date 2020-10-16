package com.google;

import java.util.ArrayList;
import java.util.Arrays;

public class IncrementArray2 {

    ArrayList<Integer> arr = new ArrayList<>(); //arrayList<Int> 

    public IncrementArray2(int[] arr) {
        for (int i = 0; i <arr.length; i++) {
            this.arr.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        IncrementArray2 incrementArray2 = new IncrementArray2(arr);
        System.out.printf("%s -> %s\n", Arrays.toString(arr), Arrays.toString(incrementArray2.increment()));

        arr = new int[]{1, 2, 9};
        incrementArray2 = new IncrementArray2(arr);
        System.out.printf("%s -> %s\n", Arrays.toString(arr), Arrays.toString(incrementArray2.increment()));

        arr = new int[]{9};
        incrementArray2 = new IncrementArray2(arr);
        System.out.printf("%s -> %s\n", Arrays.toString(arr), Arrays.toString(incrementArray2.increment()));

        arr = new int[]{9, 9};
        incrementArray2 = new IncrementArray2(arr);
        System.out.printf("%s -> %s\n", Arrays.toString(arr), Arrays.toString(incrementArray2.increment()));
    }

    public int[] increment() {
        return this.increment(this.arr.size() - 1);
    }

    int[] reverseArray(ArrayList<Integer> arr) {
        ArrayList<Integer> reverseArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            reverseArr.add(this.arr.get(i));
        }
        return reverseArr.stream().mapToInt(i -> i).toArray();
    }

    int[] increment(int index) {
        if (index < 0) {
            this.arr.add(0, 1);
            return reverseArray(this.arr);
        } else {
            int temp = this.arr.get(index) + 1;
            if (temp < 10) {
                this.arr.set(index, temp);
                return reverseArray(this.arr);
            } else {
                this.arr.set(index, 0);
                return this.increment(index - 1);
            }
        }
    }

}
