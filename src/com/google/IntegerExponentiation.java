package com.google;

import java.util.HashMap;
import java.util.Map;
public class IntegerExponentiation {

    Map<Integer, Integer> cache = new HashMap<>();

    public Integer pow(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        } else if (y == 2) {
            return x * x;
        } else if (y > 2) {
            if (y % 2 == 0)
                return pow(pow(x, y / 2), 2);
            else {
                int mod = y % 2;
                int result1 = pow(pow(x, y / 2), 2);
                int result2 = pow(x, mod);
                return  result1 * result2;
            }
        }
        return null;
    }
}
