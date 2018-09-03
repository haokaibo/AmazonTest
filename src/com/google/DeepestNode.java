package com.google;

/*
Given the root to a binary tree, count the total number of nodes there are.

Before we move on further, feel free to take a moment to think about the answer!

Solving any binary tree question involves just two steps.

First is solving the base case. This usually means solving the leaf node case (a leaf node has no left or right children) or the null case. For the above problem, we can see that a null should represent 0 nodes while a leaf node should represent 1 node.

Second is the recursive step. Assuming you knew the solution to the left subtree and the right subtree, how could you combine the two results to give you the final solution? It’s important to not get caught up on how this works and just have faith that it works. If you start tracing the recursion, you’re going to needlessly use up time and energy during the interview. Intuitively though, it works for similar reasons as why regular induction works. P(0) or the base case works which causes P(1) or the leaf node to work which causes P(2) to work and so on. For this problem, it’s easy to combine the results of the left and right subtrees. Just add the two numbers and then another 1 for the root. Here’s the code:

def count(node):
  return count(node.left) + count(node.right) + 1 if node else 0
You certainly won’t get a question this easy but the process is the same for trickier problems. Here’s another problem:

Given the root to a binary tree, return the deepest node.

Base case for this question actually can’t be null, because it’s not a real result that can be combined (null is not a node). Here we should use the leaf node as the base case and return itself.

The recursive step for this problem is a little bit different because we can’t actually use the results of the left and right subtrees directly. So we need to ask, what other information do we need to solve this question? It turns out if we tagged with each subresult node their depths, we could get the final solution by picking the higher depth leaf and then incrementing it:

def deepest(node):
    if node and not node.left and not node.right:
        return (node, 1) # Leaf and its depth

    if not node.left: # Then the deepest node is on the right subtree
        return increment_depth(deepest(node.right))
    elif not node.right: # Then the deepest node is on the left subtree
        return increment_depth(deepest(node.left))

    return increment_depth(
            max(deepest(node.left), deepest(node.right),
                    key=lambda x: x[1])) # Pick higher depth tuple and then increment its depth

def increment_depth(node_depth_tuple):
    node, depth = node_depth_tuple
    return (node, depth + 1)


 */
public class DeepestNode {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(int value) {
            this(value, null, null);
        }

        Node(int value, Node left) {
            this(value, left, null);
        }
    }

    class NodeInfo {
        Node node;
        int depth;

        public NodeInfo(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public NodeInfo findDeepestNode(Node node, int depth) {
        if (node == null)
            return null;

        NodeInfo left = null;
        NodeInfo right = null;

        if (node.left != null)
            left = findDeepestNode(node.left, depth + 1);
        if (node.right != null)
            right = findDeepestNode(node.right, depth + 1);

        if (left == null && right == null) {
            return new NodeInfo(node, depth);
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            if (left.depth >= right.depth) {
                return left;
            } else {
                return right;
            }
        }
    }

    public static void main(String[] args) {
        DeepestNode dn = new DeepestNode();
        Node root = dn.buildTree();
        NodeInfo ni = dn.findDeepestNode(root, 1);
        System.out.println(String.format("value=%d, depth=%d", ni.node.value, ni.depth));

    }

    public Node buildTree() {
        Node root = new Node(1,
                new Node(2,
                        new Node(3),
                        new Node(4)),
                new Node(5,
                        new Node(6,
                                new Node(7))));
        return root;
    }
}
