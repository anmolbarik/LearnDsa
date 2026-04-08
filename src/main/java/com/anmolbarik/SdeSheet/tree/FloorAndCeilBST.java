package com.anmolbarik.SdeSheet.tree;

class TreeNodeFC {
    int val;
    TreeNodeFC left, right;

    TreeNodeFC(int val) {
        this.val = val;
    }
}

public class FloorAndCeilBST {

    // Find Floor (greatest <= key)
    public int floor(TreeNodeFC root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.val == key) {
                return root.val;
            }

            if (root.val < key) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return floor;
    }

    // Find Ceil (smallest >= key)
    public int ceil(TreeNodeFC root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                return root.val;
            }

            if (root.val > key) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }

    // Driver code
    public static void main(String[] args) {
        /*
                8
               / \
              4   12
             / \   / \
            2   6 10 14
        */

        TreeNodeFC root = new TreeNodeFC(8);
        root.left = new TreeNodeFC(4);
        root.right = new TreeNodeFC(12);
        root.left.left = new TreeNodeFC(2);
        root.left.right = new TreeNodeFC(6);
        root.right.left = new TreeNodeFC(10);
        root.right.right = new TreeNodeFC(14);

        FloorAndCeilBST obj = new FloorAndCeilBST();

        int key = 5;

        System.out.println("Floor: " + obj.floor(root, key));
        System.out.println("Ceil: " + obj.ceil(root, key));
    }
}