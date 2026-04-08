package com.anmolbarik.SdeSheet.tree;

import java.util.*;

class TreeVNode {
    int val;
    TreeVNode left, right;

    TreeVNode(int val) {
        this.val = val;
    }
}

 class VerticalTraversal {

    static class Tuple {
        TreeVNode node;
        int x, y;

        Tuple(TreeVNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeVNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeVNode node = t.node;
            int x = t.x;
            int y = t.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }

            result.add(col);
        }

        return result;
    }

    // Driver
    public static void main(String[] args) {
        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeVNode root = new TreeVNode(3);
        root.left = new TreeVNode(9);
        root.right = new TreeVNode(20);
        root.right.left = new TreeVNode(15);
        root.right.right = new TreeVNode(7);

        VerticalTraversal obj = new VerticalTraversal();
        System.out.println(obj.verticalTraversal(root));
    }
}