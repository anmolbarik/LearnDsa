package com.anmolbarik.SdeSheet.String;

public class Zfunction {

    public static void find(String pattern, String text){
        int[] arr = new int[text.length()];
        int start = 0;
        int k=0;
        for(int i=0;i<text.length(); i++){
            System.out.println("charat : "+pattern.charAt(k) +" chart text: "+ text.charAt(i));
            while(k<pattern.length() && i<text.length() && pattern.charAt(k)==text.charAt(i)){
                System.out.println("match " + pattern.charAt(k) + " = " + text.charAt(i));
                k++;
                i++;
            }

            arr[start]=k;
            i=start+1;
            start++;
            k=0;
            System.out.println("Break Reset: k= "+k+" i= "+i);
        }
        k=0;
        for(int i : arr){
            System.out.println("loop i: "+i);
            if(i==pattern.length()){
                System.out.println("pattern found at position: "+i);
            k++;
            }
        }
        System.out.println("Pattern found "+k+" times");
    }

    public static void main(String[] args) {
        find("abc","bbbabc");
    }
}
