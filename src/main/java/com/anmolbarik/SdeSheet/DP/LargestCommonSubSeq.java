package com.anmolbarik.SdeSheet.DP;

//
public class LargestCommonSubSeq {
    public static void main(String[] args) {
        String s1 = "aabcde";
        String s2 = "abedfe";
        int row = s1.length();
        int column = s2.length();
        int[][] dp = new int[row+1][column + 1];

        for(int i = 0; i< row; i++){
            dp[i][0] = 0;}

        for(int j = 0; j<column; j++){
            dp[0][j] = 0;}


        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        for(int i =0; i<=row; i++){
            for(int j=0; j<=column; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Answer = "+dp[row][column]);


    }
}
