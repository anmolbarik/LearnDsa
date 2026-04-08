package com.anmolbarik.SdeSheet.tree;


class TreeFBTNode {
    int val;
    TreeFBTNode left, right;

    TreeFBTNode(int val) {
        this.val = val;
    }
}

public class FlattenBinaryTreeToLinkedList {

    private TreeFBTNode prev = null;

    // Main function
    public void flatten(TreeFBTNode root) {
        if (root == null) return;

        // Reverse preorder: Right → Left → Root
        flatten(root.right);
        flatten(root.left);

        // Rewire pointers
        root.right = prev;
        root.left = null;

        // Move prev
        prev = root;
    }

    // Helper to print flattened list
    public void printList(TreeFBTNode root) {
        TreeFBTNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    // Driver code
    public static void main(String[] args) {
        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        TreeFBTNode root = new TreeFBTNode(1);
        root.left = new TreeFBTNode(2);
        root.right = new TreeFBTNode(5);
        root.left.left = new TreeFBTNode(3);
        root.left.right = new TreeFBTNode(4);
        root.right.right = new TreeFBTNode(6);

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();

        obj.flatten(root);
        obj.printList(root);
    }
}