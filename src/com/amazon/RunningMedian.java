package com.amazon;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by kaibohao on 2016-11-12.
 */
public class RunningMedian {
    double median = 0.0;
    MaxIntHeap maxIntHeap = new MaxIntHeap();
    MinIntHeap minIntHeap = new MinIntHeap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        double median;
        RunningMedian runningMedian = new RunningMedian();
        for (int i = 0; i < n; i++) {
            median = runningMedian.getMedian(a[i]);
            DecimalFormat numberFormat = new DecimalFormat("#.0");
            System.out.println(numberFormat.format(median));
        }
    }

    public double getMedian(int value) {
        int temp = 0;
        if (maxIntHeap.getSize() == 0 && minIntHeap.getSize() == 0) {
            minIntHeap.add(value);
            return value / 1.0;
        } else {
            int middleLeft = maxIntHeap.items[0];
            int middleRight = minIntHeap.items[0];
            if (value < middleRight) {
                maxIntHeap.add(value);
            } else {
                minIntHeap.add(value);
            }
            // rebalance the left and right heap
            if (maxIntHeap.getSize() - minIntHeap.getSize() > 1) {
                temp = maxIntHeap.peek();
                minIntHeap.add(temp);
            } else if (minIntHeap.getSize() - maxIntHeap.getSize() > 1) {
                temp = minIntHeap.peek();
                maxIntHeap.add(temp);
            }
        }

        double median = 0.0;
        if (maxIntHeap.getSize() == minIntHeap.getSize())
            median = ((maxIntHeap.items[0] + minIntHeap.items[0]) / 2.0);
        else if (maxIntHeap.getSize() > minIntHeap.getSize())
            median = maxIntHeap.items[0] / 1.0;
        else median = minIntHeap.items[0] / 1.0;
        return median;
    }
}
