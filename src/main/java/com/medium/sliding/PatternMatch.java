package com.medium.sliding;

import java.util.Arrays;

public class PatternMatch {
    public static void main(String[] args) {
        //“ZZVZ” “ZZVZZXZZYZZVZZVZ”

       String pattern = "ZZVZ";
       String input = "ZZVZZXZZYZZVZZVZ";
       int[] prefix = new int[pattern.length()];
       int i=0;
       for(int j=1;j<pattern.length();j++){
           if(pattern.charAt(i) == pattern.charAt(j)){
                if(i==0) {
                    prefix[j] = 1;
                } else{
                    prefix[j] = prefix[j-1]+1;
                }
               i++;
           }

           else {
               prefix[j]=0;
           }
       }
System.out.println(Arrays.toString(prefix));

       int l=0;
       for(int k=0;k<input.length();){
            if(pattern.charAt(l) == input.charAt(k)){
               l++;
               k++;
            }
            if(l==pattern.length()){
                System.out.println("index found :" + (k-l));
                l=prefix[l-1];
            }else if(k<input.length() && pattern.charAt(l) != input.charAt(k)){
                    if(l==0){
                        k++;
                    }else {
                        l=prefix[l-1];
                    }
            }
       }

    }
}
