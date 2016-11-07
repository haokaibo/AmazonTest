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

    public boolean checkBST(Node root) {
        // check if the left sub tree is a BST
        if (root == null)
            return true;
        if (root.left != null)
            if (root.left.data >= root.data || !checkBST(root.left))
                return false;
        if (root.right != null)
            if (root.right.data < root.data || !checkBST(root.right))
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

    public static Node buildTreeByLevelAndValues(int begin, int end, int[] values) {
        if (begin > end)
            return null;
        if (begin == end)
            return new Node(values[begin]);
        int mid = (begin + end + 1) / 2;
        Node root = new Node(values[mid]);
        Node left = buildTreeByLevelAndValues(begin, mid - 1, values);
        Node right = buildTreeByLevelAndValues(mid + 1, end, values);
        root.left = left;
        root.right = right;
        return root;
    }
}
