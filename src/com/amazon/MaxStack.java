package com.amazon;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> max = new Stack<>();

    public void push(int v) {
        main.push(v);
        if (max.empty()) {
            max.push(v);
        } else if (max.peek() < v) {
            max.push(v);
        } else {
            max.push(max.peek());
        }
    }

    public Integer pop() {
        if (main == null || main.empty()) {
            return null;
        } else {
            max.pop();
            return main.pop();
        }
    }

    public Integer max() {
        if (max == null || max.empty())
            return null;
        else {
            return max.peek();
        }
    }
}
