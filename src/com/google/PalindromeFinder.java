package com.google;

import java.util.*;

/**
 * This problem was asked by Google.
 * 12/04/2018
 * Kaibo
 */
public class PalindromeFinder {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean findPalindrome(Node root) {
        if (root == null) {
            return false;
        }
        Node current = root;

        List<Node> dic = new ArrayList<>();

        // push all the node into the list.
        while (current!= null) {
            dic.add(current);
            current = current.next;
        }

        // check the matching from the front and end of the list.
        int size = dic.size();
        if (size == 1)
            return true;
        else {
            for (int i = 0; i < size / 2; i++) {
                if (dic.get(i).value != dic.get(size - i - 1).value)
                    return false;
            }
        }
        return true;
    }
}
