package com.medium.dp.recursion;

public class LCSubstring {
    public static void main(String[] args) {
        String s1= "abbbbbcdef";
        String s2="cbbbbbghi";
        System.out.println(getLCsubstring(s1,s2,s1.length()-1,s2.length()-1,0));
    }

    private static int getLCsubstring(String s1, String s2, int length, int length1, int count) {
        if(length<=0 || length1 <=0)
            return 0;
        if(s1.charAt(length) == s2.charAt(length1)){
            return 1+getLCsubstring(s1,s2,length-1,length1-1,count+1);
        }

        return Math.max(getLCsubstring(s1,s2,length-1,length1,count),getLCsubstring(s1,s2,length,length1-1,count));
    }
}
