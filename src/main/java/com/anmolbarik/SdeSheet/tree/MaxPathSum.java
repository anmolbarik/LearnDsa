package com.anmolbarik.SdeSheet.tree;

public class MaxPathSum {
    //calculate maximum sum possible by visiting any path in tree. dont traverse node again.
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeFBTNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeFBTNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
