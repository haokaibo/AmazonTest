package com.amazon;

import java.util.Stack;

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
        this.setData(data);
        this.left = left;
        this.right = right;
    }

    public void insert(int value) {
        if (value < getData()) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (getData() == value)
            return true;
        else if (value < getData()) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public boolean contains(Node root, int value) {
        if (root.getData() == value)
            return true;
        else if (value < root.getData()) {
            if (root.left == null) {
                return false;
            } else {
                return contains(root.left, value);
            }
        } else {
            if (root.right == null) {
                return false;
            } else {
                return contains(root.right, value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(getData());
        if (right != null) {
            right.printInOrder();
        }
    }

    public boolean checkBST(Node root, Stack<Node> nodeQueue) {
        if (root.left != null) {
            if (!checkBST(root.left, nodeQueue))
                return false;
        }
        if (!nodeQueue.isEmpty()) {
            if (root.getData() <= nodeQueue.peek().getData()) {
                return false;
            }
        }
        nodeQueue.push(root);
        if (root.right != null) {
            if (!checkBST(root.right, nodeQueue))
                return false;
        }
        return true;
    }

    public boolean checkBST(Node root) {
        if (root == null)
            return true;
        Stack<Node> nodeQueue = new Stack<>();
        return checkBST(root, nodeQueue);
//        boolean result = checkBSTFromRoot(root, root);
//        return result;
        // check if the left sub tree is a BST
//        if (root == null)
//            return true;
//        if (root.left != null)
//            if (root.left.getData() > root.getData() || !checkBST(root.left) ||
//                    root != getParent(root, root.left))
//                return false;
//        if (root.right != null)
//            if (root.right.getData() <= root.getData() || !checkBST(root.right) ||
//                    root != getParent(root, root.right))
//                return false;
//        return true;
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


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
