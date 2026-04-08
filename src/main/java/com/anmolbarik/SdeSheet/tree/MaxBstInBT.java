package com.anmolbarik.SdeSheet.tree;


class TreeNodeBST {
    int val;
    TreeNodeBST left, right;

    TreeNodeBST(int val) {
        this.val = val;
    }
}

class NodeInfo {
    int min, max, size;

    NodeInfo(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class LargestBSTInBT {

    public int largestBSTSubtree(TreeNodeBST root) {
        return dfs(root).size;
    }

    private NodeInfo dfs(TreeNodeBST node) {
        // Base case
        if (node == null) {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);

        // Check if current subtree is BST
        if (left.max < node.val && node.val < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new NodeInfo(min, max, size);
        }

        // Not a BST
        return new NodeInfo(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.size, right.size)
        );
    }

    // Driver code
    public static void main(String[] args) {
        /*
                10
               /  \
              5    15
             / \     \
            1   8     7
        */

        TreeNodeBST root = new TreeNodeBST(10);
        root.left = new TreeNodeBST(5);
        root.right = new TreeNodeBST(15);
        root.left.left = new TreeNodeBST(1);
        root.left.right = new TreeNodeBST(8);
        root.right.right = new TreeNodeBST(7);

        LargestBSTInBT obj = new LargestBSTInBT();
        System.out.println(obj.largestBSTSubtree(root)); // Output: 3
    }
}
