package com.twitter;

/* Daily Coding Problem: Problem #16
This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish
 this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

 */
public class LastNOrderId {

    int N = 6;
    int[] indexes = new int[N];

    int current = 0;

    void addLog(int logId) {
        indexes[current % N] = logId;
        current++;
    }

    int get_last(int i) {
        if (i > N || current < i) {
            return -1;
        }

        return indexes[(current - i) % N];
    }

    public static void main(String[] args) {
        LastNOrderId lastNOrderId = new LastNOrderId();

        for (int i = 0; i < 5; i++)
            lastNOrderId.addLog(i);

        for (int i = 1; i <= lastNOrderId.N; i++) {
            System.out.println(lastNOrderId.get_last(i));
        }
    }

}
