package com.google;

import java.util.*;

/*
This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class IntersectingNode {

    public static void main(String[] args) {
        LinkedList<Integer> linkedListA = new LinkedList<>();
        LinkedList<Integer> linkedListB = new LinkedList<>();
        int[] a = new int[]{3, 7, 8, 10};
        int[] b = new int[]{99, 1, 8, 10};

        for (int i = 0; i < a.length; i++)
            linkedListA.add(a[i]);

        for (int i = 0; i < b.length; i++)
            linkedListB.add(b[i]);

        Integer result = getIntersectionNode(linkedListA, linkedListB);
        if (result != null)
            System.out.printf("%d\n", result);
        else
            System.out.println("There is none intersecting node.");
    }

    public static Integer getIntersectionNode(LinkedList<Integer> a, LinkedList<Integer> b) {

        if (a == null || b == null || a.size() == 0 || b.size() == 0) {
            return null;
        }
        Iterator<Integer> iteratorA = a.listIterator();
        Iterator<Integer> iteratorB = b.listIterator();
        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            Integer itemA = iteratorA.next();
            Integer itemB = iteratorB.next();
            if (itemA.equals(itemB))
                return itemA;
        }
        return null;
    }
}
