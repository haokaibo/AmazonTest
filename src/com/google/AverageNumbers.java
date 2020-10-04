package com.google;

public class AverageNumbers {
    int N = 0;
    int sum = 0;

    public void add(int value) {
        sum += value;
        N++;
    }

    public int getAvg() {
        if (N > 0)
            return sum / N;
        else
            return 0;
    }

    public static void main(String[] args) {
        AverageNumbers averageNumbers = new AverageNumbers();
        for (int i = 0; i < 5; i++)
            averageNumbers.add(i + 1);
        System.out.println(averageNumbers.getAvg());
    }
}
