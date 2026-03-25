package com.anmolbarik.SdeSheet.DP;

public class coinChange2 {

    public static int getMaximumways(int amount, int[] coins){

        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int coin: coins){
            for(int i=coin; i<=amount; i++){
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println("Answer: "+getMaximumways(amount,coins));
    }
}
