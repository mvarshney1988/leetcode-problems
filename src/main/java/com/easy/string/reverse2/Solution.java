package com.easy.string.reverse2;

public class Solution {
    public String reverseStr(String s, int k) {
        if(k==1)
            return s;
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            int start=i;
            int end=Math.min(i+k-1,s.length()-1);
            while(start<end){
                char temp=ch[start];
                ch[start]=ch[end];
                ch[end]=temp;
                start++;
                end--;

            }
        }
        return String.valueOf(ch);
    }


}
