package com.anmolbarik.SdeSheet.DP;

public class Knapsack {
    public static int doWork(int weight,int[] value, int[] wt){
        int size = value.length+1;

        int[][] dp = new int[size][weight+1];

        for(int i = 0; i<=weight; i++)
            dp[0][i] = 0;

        for(int item=1; item<size; item++){
            for(int w=1; w<=weight; w++){
                //if we dont take same value as before
                int oldvalue = dp[item-1][w];

                //if we take item
                //currentValue = value of item + Value(weightOfItem - currentWeight)
                int newValue= Integer.MIN_VALUE;
                if(w>=wt[item-1]){
                newValue=  value[item-1] + dp[item-1][w-wt[item-1]];
                }
                dp[item][w] = Math.max(oldvalue,newValue);
            }
        }
        return dp[size-1][weight];


    }

    public static void main(String[] args) {
        int[] value = {10,20,20};
        int[] weight = {2,3,5};
        int maxWeight = 5;

        System.out.println(doWork(maxWeight,value,weight));
    }
}
