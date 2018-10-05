package com.twosigma;

public class RandomInteger {
    private static int rand(int N) {
        return (int) (Math.ceil(Math.random() * N));
    }

    public static int rand5() {
        return rand(5);
    }


    public static int rand7() {
        return rand(7);
    }
}
