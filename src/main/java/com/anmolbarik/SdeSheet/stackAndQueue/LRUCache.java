package com.anmolbarik.SdeSheet.stackAndQueue;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    class NodeLRU{
        int key, value;
        NodeLRU left, right;

        NodeLRU(int k, int v){
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer,NodeLRU> map;
    private NodeLRU head, tail;

    LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new NodeLRU(0,0);
        tail = new NodeLRU(0,0);
        head.right = tail;
        tail.left = head;
    }
    // remove any node
    private void remove(NodeLRU node){
        node.left.right = node.right;
        node.right.left = node.left;
    }
    // inset node to front always to maintain LRU.
    private void insert(NodeLRU node){
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }
    //WHEN WE INSERT ANY ELEMENT. WE REMOVE FROM
    //LINKED LIST AND INSERT TO THAT NODE TO HEAD.NEXT.
    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        NodeLRU node = new NodeLRU(key, value);
        insert(node);
        map.put(key,node);
        if(map.size()>capacity){
            NodeLRU lru = tail.left;
            remove(lru);
            map.remove(lru.key);
        }
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return  -1;
        }
        NodeLRU node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

}
