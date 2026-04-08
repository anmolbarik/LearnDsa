package com.anmolbarik.SdeSheet.tree;


class TreeLCA {
    int val;
    TreeLCA left, right;

    TreeLCA(int val) {
        this.val = val;
    }
}

public class LCA {

    public TreeLCA lowestCommonAncestor(TreeLCA root, TreeLCA p, TreeLCA q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeLCA left = lowestCommonAncestor(root.left, p, q);
        TreeLCA right = lowestCommonAncestor(root.right, p, q);

        // If both sides returned non-null → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return non-null side
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */

        TreeLCA root = new TreeLCA(3);
        root.left = new TreeLCA(5);
        root.right = new TreeLCA(1);
        root.left.left = new TreeLCA(6);
        root.left.right = new TreeLCA(2);
        root.right.left = new TreeLCA(0);
        root.right.right = new TreeLCA(8);
        root.left.right.left = new TreeLCA(7);
        root.left.right.right = new TreeLCA(4);

        LCA obj = new LCA();
        TreeLCA ans = obj.lowestCommonAncestor(root, root.left, root.right);

        System.out.println(ans.val); // Output: 3
    }
}