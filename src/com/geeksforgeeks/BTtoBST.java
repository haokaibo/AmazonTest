package com.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class BTtoBST {
    public static TreeNode convert(TreeNode bt) {
        TreeNode bst_root = null;

        return bst_root;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int value) {
            this(value, null, null);
        }

        public String print() {
            String left_output = "";
            String right_output = "";
            StringBuffer branch = new StringBuffer();
            if (this.left != null) {
                branch.append("\n/ ");
                left_output = this.left.print();
            }

            if (this.right != null) {
                branch.append(" \\\n");
                right_output = this.right.print();
            }

            String output = String.format("%d %s %s %s", this.value, branch.toString(), left_output, right_output);
            return output;
        }
    }

    public static void main(String[] args) {
        TreeNode bt1 = new TreeNode(10,
                new TreeNode(2,
                        new TreeNode(8),
                        new TreeNode(4)),
                new TreeNode(7));
        System.out.println(bt1.print());

        int a= 214967295;
    }
}
