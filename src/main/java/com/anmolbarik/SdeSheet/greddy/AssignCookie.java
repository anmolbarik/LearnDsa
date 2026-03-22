package com.anmolbarik.SdeSheet.greddy;

import java.util.Arrays;

public class AssignCookie {

    public static void main(String[] args) {
        int[] children = new int[]{1, 1, 2, 3, 4, 5};
        int[] cookies = {2,2,2,1};

        Arrays.sort(children);
        Arrays.sort(cookies);

        int i=0,j=0;
        int count =0;
        while(j<=cookies.length-1 && i<=children.length-1){
            if(children[i]<=cookies[j]){
                i++;
            }
            j++;
        }

        System.out.println(i);

    }


}
