package com.amazon;

import java.util.HashMap;

/**
 * Created by kaibohao on 2016-12-2.
 */

/**
 * We implement this by Min Heap data structure which enables to remove the least frequent used item
 * when adding a new one.
 */
public class LFUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    public String set(int key, int value) {
        String result = null;
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                result = String.format("invalidate key %d", end.key);
                map.remove(end.key);
                remove(end);
                setHead(created);

            } else {
                setHead(created);
            }

            map.put(key, created);
        }
        return result;
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);
        print(cache.set(1, 1));
        print(cache.set(2, 2));
        print(cache.get(1));       // returns 1
        print(cache.set(3, 3));    // invalidate key 2
        print(cache.get(2));       // returns -1 (not found)
        print(cache.get(3));       // returns 3.
        print(cache.set(4, 4));    // invalidate key 1.
        print(cache.get(1));       // returns -1 (not found)
        print(cache.get(3));       // returns 3
        print(cache.get(4));       // returns 4
    }
}
