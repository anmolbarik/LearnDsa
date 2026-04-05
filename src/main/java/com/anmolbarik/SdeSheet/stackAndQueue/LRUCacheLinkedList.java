package com.anmolbarik.SdeSheet.stackAndQueue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedList extends LinkedHashMap<Integer,Integer> {

    int capacity;
    LRUCacheLinkedList(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

    public static void main(String[] args){
        Map<Integer, Integer> map =  lmap(3);
        map.put(1,20);
        map.put(2,30);
        map.put(3,40);
        map.get(1);
        map.put(5,60);
        for(int i: map.values())
            System.out.println(i);
    }

    public static Map<Integer, Integer> lmap(int capacity){
        Map<Integer, Integer> map = new LinkedHashMap<>(capacity,0.75f,true);
        return map;
    }

}
