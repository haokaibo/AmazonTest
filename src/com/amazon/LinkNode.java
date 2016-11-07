package com.amazon;

import java.util.HashMap;

/**
 * Created by kaibohao on 2016-11-6.
 */
public class LinkNode {
    int data;
    LinkNode next;

    public static boolean hasCycle(LinkNode head) {
        if (head == null)
            return false;
        HashMap<LinkNode, Boolean> visitedNode = new HashMap<>();
        LinkNode current = head;
        visitedNode.put(current, true);
        while (current.next != null) {
            if (!visitedNode.containsKey(current.next)) {
                current = current.next;
                visitedNode.put(current, true);
            } else {
                return true;
            }
        }
        return false;
    }
}
