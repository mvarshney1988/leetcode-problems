package com.sliding.length;

import java.util.HashMap;

public class MaxSubstringLength {
    public static void main(String[] args) {
        String s = "pwwkew";
        var map = new HashMap<Character, Integer>();
        int len=0;
        int max=0;
        int lastindex=0;
        int i=0;
        while(i<s.length() && lastindex<s.length()){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                len= map.size();
                if (len > max) {
                    max = len;
                }
                i++;
            }else{
                map.remove(s.charAt(lastindex));
              //  len=i-lastindex;
                lastindex++;

            }
        }

        System.out.println(max);
    }
}
