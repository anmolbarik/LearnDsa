package com.anmolbarik.SdeSheet.tree;

public class Diameter {
}
class TreeDNode {
    int val;
    TreeDNode left, right;

    TreeDNode(int val) {
        this.val = val;
    }
}

 class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeDNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeDNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // update diameter
        diameter = Math.max(diameter, left + right);

        // return height
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeDNode root = new TreeDNode(1);
        root.left = new TreeDNode(2);
        root.right = new TreeDNode(3);
        root.left.left = new TreeDNode(4);
        root.left.right = new TreeDNode(5);

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}