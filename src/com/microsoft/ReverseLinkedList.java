package com.microsoft;


import java.util.Stack;


public class ReverseLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node reverseByK(Node root, int k) {
        if (root == null)
            return null;

        Stack<Node> s = new Stack<>();
        Node head = null;
        Node tail = null;
        Node current = root;

        while (current != null) {
            int i = 0;
            Node subHead = current;
            for (; current != null && i < k; i++) {
                s.push(current);
                current = current.next;
            }
            if (i == k) {
                while (!s.empty()) {
                    if (head == null) {
                        head = tail = s.pop();
                    } else {
                        tail.next = s.pop();
                        tail = tail.next;
                    }
                }
            } else{
                while(subHead.next!=null) {
                    if (head == null) {
                        head = tail = subHead;
                    }else {
                        tail.next = subHead;
                        tail = tail.next;
                    }
                    subHead = subHead.next;
                }
            }
        }

        return head;
    }
}
