package com.google;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

//Java test
class IncrementArray {
    public IncrementArray(int[] arr) {
        this.arr_length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            this.stack.push(arr[i]);
        }
    }

    Stack<Integer> stack = new Stack<>();
    int arr_length = 0;

    public int[] increment() {
        int last_value = 1;
        int post_zeros = 0;
        while (!stack.empty()) {
            int temp = stack.pop() + 1;
            if (temp < 9) {
                stack.push(temp);
                last_value = temp;
                break;
            } else {
                post_zeros++;
                last_value = 0;
            }
        }
        if (last_value == 0) {
            stack.push(1);
            arr_length++;
        }

        while (post_zeros>0) {
            stack.push(0);
            post_zeros--;
        }

        // output the arr
        int[] arr = new int[arr_length];
        Iterator<Integer> iter = stack.iterator();
        int i = 0;
        while (iter.hasNext()) {
            arr[i] = iter.next();
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 2, 3};
        IncrementArray incrementArray = new IncrementArray(inputArr);
        System.out.printf("%s -> %s\n", Arrays.toString(inputArr), Arrays.toString(incrementArray.increment()));

        inputArr = new int[]{1, 2, 9};
        incrementArray = new IncrementArray(inputArr);
        System.out.printf("%s -> %s\n", Arrays.toString(inputArr) , Arrays.toString(incrementArray.increment()));

        inputArr = new int[]{9};
        incrementArray = new IncrementArray(inputArr);
        System.out.printf("%s -> %s\n", Arrays.toString(inputArr) , Arrays.toString(incrementArray.increment()));

        inputArr = new int[]{9,9};
        incrementArray = new IncrementArray(inputArr);
        System.out.printf("%s -> %s\n", Arrays.toString(inputArr) , Arrays.toString(incrementArray.increment()));
    }

}
