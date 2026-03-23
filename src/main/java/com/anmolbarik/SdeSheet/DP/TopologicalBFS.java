package com.anmolbarik.SdeSheet.DP;

import java.util.*;
        import java.io.*;
        import java.lang.*;

class Solution {
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        //finding indegree
        for(List<Integer> li: adj) {
            for(Integer it: li) {
                indegree[it]++;
            }
        }
        System.out.println("Indegree Array ");
        for(int i: indegree)
            System.out.print(i+" ");
        System.out.println(" ");


        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<N;i++) {
            //adding nodes to queue with indegree = 0
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int ind=0;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;
            cnt++;
            //getting neighbour nodes of popped node and decreasing  their indegree by1
            for(Integer it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        //printing topological ordering of nodes
        System.out.println("Topo: ");
        for (int i=0;i< topo.length;i++){
            System.out.print(topo[i]+" ");
        }
        if(cnt == N) return false;
        return true;
    }
}
public class TopologicalBFS {
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);


        new Solution().isCyclic(6,adj);

    }
}
