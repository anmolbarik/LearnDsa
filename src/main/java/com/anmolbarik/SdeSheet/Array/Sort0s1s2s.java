package com.anmolbarik.SdeSheet.Array;

public class Sort0s1s2s {

    public static void main(String[] args) {
        int[] arr = {1,0,0,2,2,2,1,2,0,0,1,1};
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int j : arr) {
            switch (j) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
        System.out.println("0s : "+count0);
        System.out.println("1s : "+count1);
        System.out.println("2s : "+count2);

        for(int i =0; i<arr.length; i++){
            if(count0>0){
                arr[i]=0;
                count0--;
            }else if(count1>0){
                arr[i]=1;
                count1--;
            }else if(count2>0){
                arr[i]=2;
                count2--;
            }
        }

        for(int j:arr){
            System.out.print(j+" ");
        }
    }

}
