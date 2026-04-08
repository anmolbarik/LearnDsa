package com.anmolbarik.SdeSheet.tree;

import java.util.Stack;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreesNode left;
    TreesNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// BST Iterator class
class BSTIterator {
    private Stack<TreesNode> stack = new Stack<>();

    public BSTIterator(TreesNode root) {
        pushAllLeft(root);
    }

    private void pushAllLeft(TreesNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreesNode node = stack.pop();

        if (node.right != null) {
            pushAllLeft(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// Driver class to test
 class Main {
    public static void main(String[] args) {
        /*
                7
               / \
              3   15
                 /  \
                9   20
        */

        TreesNode root = new TreesNode(7);
        root.left = new TreesNode(3);
        root.right = new TreesNode(15);
        root.right.left = new TreesNode(9);
        root.right.right = new TreesNode(20);

        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}