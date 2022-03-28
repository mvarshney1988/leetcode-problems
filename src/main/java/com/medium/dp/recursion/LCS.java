package com.medium.dp.recursion;

public class LCS {
    static int[][] arr = new int[1000][1000];
    public static void main(String[] args) {
        String s1="abcd";
        String s2= "bcdf";
        System.out.println(getlcs(s1,s2,s1.length()-1,s2.length()-1));
    }

    static int getlcs(String s1, String s2, int len1, int len2){

        if(len1 <=0 || len2 <=0)
            return 0;
        if(arr[len1][len2] != 0)
            return arr[len1][len2];
        if(s1.charAt(len1) == s2.charAt(len2)) {
            arr[len1][len2] = 1 + getlcs(s1, s2, len1 - 1, len2 - 1);
            return arr[len1][len2];
        }
        arr[len1][len2] = Math.max(getlcs(s1,s2,len1-1,len2),getlcs(s1,s2,len1,len2-1));
                return arr[len1][len2];

    }
}
