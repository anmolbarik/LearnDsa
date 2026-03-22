package com.anmolbarik.SdeSheet.graph;

import java.util.*;

class Node {
    Integer data;
    List<Node> neighbors;




    Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }
}

public class MyGraph {
    public static void bfs(Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            for (Node neighbor : curr.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // create nodes
        Node n10 = new Node(10);
        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);
        Node n60 = new Node(60);

        // connect nodes (undirected graph)
        n10.neighbors.add(n20);
        n10.neighbors.add(n30);

        n20.neighbors.add(n10);
        n20.neighbors.add(n40);
        n20.neighbors.add(n50);

        n30.neighbors.add(n10);
        n30.neighbors.add(n60);

        n40.neighbors.add(n20);
        n50.neighbors.add(n20);
        n60.neighbors.add(n30);

        /*
            Graph:
                10
              /    \
            20      30
           /  \       \
         40   50      60
        */

        bfs(n10);
    }
}
