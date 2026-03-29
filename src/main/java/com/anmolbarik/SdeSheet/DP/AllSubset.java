package com.anmolbarik.SdeSheet.DP;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {

    public static  void helper(int index, List<Integer> current, int[] arr, List<List<Integer>> result){
        if(index == arr.length){
            result.add(new ArrayList<>(current));
            //System.out.println(result);
            return;
        }
        current.add(arr[index]);

        helper(index+1, current, arr,result);

        current.remove(current.size()-1);

        helper(index+1, current, arr,result);

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
         helper(0,new ArrayList<>(), arr, result);
        System.out.println(result);

    }
}
