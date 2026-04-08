package com.anmolbarik.SdeSheet.tree;

import java.util.HashSet;
import java.util.Set;

class TreeNodeSum {
    int val;
    TreeNodeSum left, right;

    TreeNodeSum(int val) {
        this.val = val;
    }
}

class TwoSumBSTPrintPair {

    public boolean findTarget(TreeNodeSum root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNodeSum node, int k, Set<Integer> set) {
        if (node == null) return false;

        int complement = k - node.val;

        // If complement found → print pair
        if (set.contains(complement)) {
            System.out.println("Pair found: " + complement + " + " + node.val + " = " + k);
            return true;
        }

        set.add(node.val);

        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }

    // Driver code
    public static void main(String[] args) {
        /*
                5
               / \
              3   6
             / \   \
            2   4   7
        */

        TreeNodeSum root = new TreeNodeSum(5);
        root.left = new TreeNodeSum(3);
        root.right = new TreeNodeSum(6);
        root.left.left = new TreeNodeSum(2);
        root.left.right = new TreeNodeSum(4);
        root.right.right = new TreeNodeSum(7);

        TwoSumBSTPrintPair obj = new TwoSumBSTPrintPair();

        obj.findTarget(root, 9);   // Example: 2 + 7
    }
}