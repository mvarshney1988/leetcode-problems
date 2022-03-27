package com.easy.string.palindromewithspecial;

public class Solution {
    public boolean isPalindrome(String s) {

        if(s==null)
            return false;
        //s=s.toUpperCase();
        s= s.replaceAll("[^a-zA-Z0-9]", "");


        s=s.toUpperCase();
        System.out.println(s.toUpperCase());
        int j=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != s.charAt(j--)){
                return false;
            }
        }


        return true;
    }
}