package com.google;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
 which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

 */
public class BinaryTreeSerialization {
    class Node {

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node left) {
            this(val, left, null);
        }

        String val;
        Node left;
        Node right;
    }

    public static Queue<String> serialize(Node node) {
        if (node == null)
            return new LinkedList<>();
        String leftString = "";
        String rightString = "";

        Queue<String> leftStrings = new LinkedList<>();
        Queue<String> rightStrings = new LinkedList<>();
        Queue<String> resultStrings = new LinkedList<>();

        leftStrings = serialize(node.left);
        rightStrings = serialize(node.right);
        resultStrings.addAll(leftStrings);
        resultStrings.addAll(rightStrings);
        resultStrings.add(node.val);
        return resultStrings;
    }

    public static void main(String[] args) {
        Node node = new BinaryTreeSerialization().buildNode();
        Queue<String> result = serialize(node);
        System.out.println(result);
    }

    public Node buildNode() {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        return node;
    }
}
