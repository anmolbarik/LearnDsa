package com.anmolbarik.SdeSheet.tree;

import java.util.Map;
import java.util.TreeMap;

class Node{
    Node left, right;
    int data;

    Node(int i){
        data=i;
    }
}

public class LeftView {

    public static void printLeftView(Node root, int level, Map<Integer,Integer> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, root.data);
        }

        printLeftView(root.left,level-1, map);
        printLeftView(root.right,level+1, map);
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new TreeMap<>();
         /*Populating demo BST
                1
              /   \
             2     3
             \    / \
              8  5   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(8);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        printLeftView(root,1,map);

        for(int i:map.values()){
            System.out.println(i);
        }
    }
}
