package com.google;

public class UnivalTree {
    public class Node {
        public Node(int value) {
            this.value = value;
        }

        Node left;
        Node right;
        int value;
    }

    public int countUnivalTrees(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int leftCount = countUnivalTrees(node.left);
        int rightCount = countUnivalTrees(node.right);
        if (node.left == null || node.right == null)
            return leftCount + rightCount;
        if (node.value == node.left.value && node.left.value == node.right.value)
            return leftCount + rightCount + 1;
        else return leftCount + rightCount;
    }

    public static void main(String[] args) {
        UnivalTree ut = new UnivalTree();
        Node root = ut.buildTree();
        int result = ut.countUnivalTrees(root);
        System.out.println(result);
    }

    public Node buildTree() {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(1);
        return root;
    }
}
