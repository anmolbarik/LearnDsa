package com.anmolbarik.SdeSheet.graph;

import java.util.*;

public class CycleDetect {

    static class Node {
        Integer data;
        List<Node> neighbors;

        Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }
    }

    public static boolean hasCycle(Node start) {

        Set<Node> visited = new HashSet<>();

        return dfs(start, null, visited);
    }

    private static boolean dfs(Node current,
                               Node parent,
                               Set<Node> visited) {

        // Mark current node visited
        visited.add(current);

        // Traverse all neighbors
        for (Node neighbor : current.neighbors) {

            // If neighbor not visited -> continue DFS
            if (!visited.contains(neighbor)) {

                if (dfs(neighbor, current, visited)) {
                    return true;
                }

            }
            // If already visited and not parent -> cycle
            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        // Undirected graph connections

        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        n2.neighbors.add(n3);
        n3.neighbors.add(n2);

        n3.neighbors.add(n4);
        n4.neighbors.add(n3);

        n4.neighbors.add(n1);
        n1.neighbors.add(n4);
        // Cycle: 1 -> 2 -> 3 -> 4 -> 1
        boolean hasCycle = hasCycle(n1);

        System.out.println("Cycle Exists: " + hasCycle);
    }
}