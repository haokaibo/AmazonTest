package com.amazon;

import java.util.HashMap;

/**
 * Created by kaibohao on 2016-11-10.
 */
public class Tries {
    HashMap<Character, Tries> children;
    boolean isCompleteWord;
}
