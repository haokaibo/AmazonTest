package com.amazon;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class QueueBasedOnStack<T> {
    Stack<T> entryStack = new Stack<>();
    Stack<T> exitStack = new Stack<>();

    public void enqueue(T item) {
        entryStack.push(item);
    }

    public T dequeue() {
        if (!exitStack.isEmpty())
            return exitStack.pop();
        while (!entryStack.isEmpty()) {
            T temp = entryStack.pop();
            if (entryStack.isEmpty()) {
                return temp;
            }
            exitStack.push(temp);
        }
        return null;
    }

    public T peek() {
        T temp = null;
        if (!exitStack.isEmpty())
            return exitStack.peek();
        while (!entryStack.isEmpty()) {
            temp = entryStack.pop();
            exitStack.push(temp);
        }
        return temp;
    }

    public static void main(String[] args) {
        QueueBasedOnStack<Integer> queue = new QueueBasedOnStack<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
