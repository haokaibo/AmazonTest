package com.amazon;

/**
 * Created by kaibohao on 2016-11-1.
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this(data, null, null);
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static boolean checkBST(Node root) {
        // check if the left sub tree is a BST
        if (root == null)
            return true;
        if (!checkBST(root.left))
            return false;
        if (!checkBST(root.right))
            return false;
        if (root.left != null && root.left.data > root.data)
            return false;
        if (root.right != null && root.right.data < root.data)
            return false;
        return true;
    }

    public int getData() {
        return data;
    }

    public Node setData(int data) {
        this.data = data;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }
}
