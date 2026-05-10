package com.anmolbarik.SdeSheet.BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int size = 3;
        int[][] board = new int[size][size];
        List<int[][]> result = new ArrayList<>();
        calculate(size,board,0,result);

        for(int[][] i: result){
            for(int j=0; j<size; j++){
                for(int x=0; x<size; x++){
                    System.out.print(i[j][x]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------");
        }
    }

    private static void calculate(int n, int[][] board, int current, List<int[][]> result){
        if(current==n){
            for(int j=0; j<n; j++){
                for(int x=0; x<n; x++){
                    System.out.print(board[j][x]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------");
            return;
        }

        for(int i = 0; i<n; i++){
           if(isSafe(board,current,i,n)){
               board[i][current] = 1;
               calculate(n,board,current+1,result);
               board[i][current] = 0;
           }
        }
    }

    private static boolean isSafe(int[][]board, int current, int row,int n){
        for(int i = current; i>=0; i--){
            if(board[row][i]==1){
                return false;
            }
        }
        for(int i = row,  j= current; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        for(int i = row,  j= current; i<n && j>=0; i++, j--){
            if(board[i][j]==1) {
                return false;
            }
        }
        return true;
    }
}
