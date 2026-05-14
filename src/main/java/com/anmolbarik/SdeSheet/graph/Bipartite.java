package com.anmolbarik.SdeSheet.graph;

import java.util.*;
//Can we apply Alternate color on each node? //we call this Bipartite graph

public class Bipartite {

    static class Node {

        Integer data;
        List<Node> neighbors;

        Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }
    }

    public static boolean isBipartite(Node start) {


        Map<Node, Integer> colorMap = new HashMap<>();

        // Start coloring with 0
        return dfs(start, 0, colorMap);
    }

    private static boolean dfs(Node current,
                               int color,
                               Map<Node, Integer> colorMap) {

        // Assign color
        colorMap.put(current, color);

        for (Node neighbor : current.neighbors) {

            // If neighbor not colored
            if (!colorMap.containsKey(neighbor)) {

                // Assign opposite color
                if (!dfs(neighbor, 1 - color, colorMap)) {
                    return false;
                }

            }
            // If same color found
            else if (colorMap.get(neighbor) == color) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        // Square graph (Bipartite)

        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        n2.neighbors.add(n3);
        n3.neighbors.add(n2);

        n3.neighbors.add(n4);
        n4.neighbors.add(n3);

        n4.neighbors.add(n1);
        n1.neighbors.add(n4);

        boolean result = isBipartite(n1);

        System.out.println("Is Bipartite: " + result);
    }
}