package com.amazon;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kaibohao on 2016-11-6.
 */
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        char[] leftBrackets = new char[]{'(', '{', '['};
        char[] rightBrackets = new char[]{')', '}', ']'};
        Stack<Character> leftBracketsStack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            for (char leftBracket : leftBrackets) {
                if (c == leftBracket) {
                    leftBracketsStack.push(c);
                    continue;
                }
            }
            for (char rightBracket : rightBrackets) {
                if (c == rightBracket) {
                    if(leftBracketsStack.empty())
                        return false;
                    char leftBracket = leftBracketsStack.pop();
                    if (leftBracket == '(' && rightBracket == ')')
                        continue;
                    else if (leftBracket == '{' && rightBracket == '}')
                        continue;
                    else if (leftBracket == '[' && rightBracket == ']')
                        continue;
                    else
                        return false;
                }
            }
        }
        return leftBracketsStack.empty();
    }
}
