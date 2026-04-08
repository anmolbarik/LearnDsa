package com.anmolbarik.SdeSheet.tree;

import java.util.*;

class TreesNode {
    int val;
    TreesNode left, right;

    TreesNode(int val) {
        this.val = val;
    }
}

public class MorrisTraverse {

    // Morris Inorder Traversal (O(1) space)
    public List<Integer> morrisInorder(TreesNode root) {
        List<Integer> result = new ArrayList<>();
        TreesNode curr = root;

        while (curr != null) {

            // Case 1: No left child
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            }
            else {
                // Find inorder predecessor (rightmost of left subtree)
                TreesNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // Case 2a: Create thread
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }
                // Case 2b: Thread exists → remove it
                else {
                    pred.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }

    // Driver method for testing
    public static void main(String[] args) {

        /*
                4
               / \
              2   5
             / \
            1   3
        */

        TreesNode root = new TreesNode(4);
        root.left = new TreesNode(2);
        root.right = new TreesNode(5);
        root.left.left = new TreesNode(1);
        root.left.right = new TreesNode(3);

        MorrisTraverse obj = new MorrisTraverse();
        List<Integer> result = obj.morrisInorder(root);

        System.out.println(result);
    }
}