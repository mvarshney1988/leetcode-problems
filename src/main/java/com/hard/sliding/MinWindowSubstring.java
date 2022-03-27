package com.hard.sliding;

import java.util.HashMap;
//0-create map for patterns
//1-in a loop , add every element with frq in a map and break if matched count becomes pattern count // check if pattern freq >= string freq
//2-if that covers all patterns, then start nested loop for matched count == pat.length && i=0 for removing start element from left side , i and j becomes substring and temp = j-i+1
//3-calculate min and remove/decrease count from input and if that also found in pattern then decrease matched count
//4-in order to compensate it , we go to j loop and see next element is part of pattern then increase matched count
public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC"; // ODEBANC
        String t="ABC";
        System.out.println(minWindow(s,t)) ;
    }

    public static String minWindow(String s, String t) {

        if(s.length()<=0 || s.length()<t.length())
            return "";
        HashMap<Character, Integer> input = new HashMap<>();
        HashMap<Character, Integer> mh = new HashMap<>();

        for(int i=0; i<t.length(); i++)
            mh.put(t.charAt(i), mh.getOrDefault(t.charAt(i), 0)+1);

        int i=0,matchcount=0,min=Integer.MAX_VALUE,fromi=-1,fromj=-1;

        for(int j=0;j<s.length();j++)
        {
            char ch = s.charAt(j);
            input.put(ch, input.getOrDefault(ch, 0)+1);
            if(mh.containsKey(ch))
            {
                int freq=input.get(ch);
                if(freq<=mh.get(ch))  // mh=A->1,B->1,C->1, hm=A->1,B->2,C->1 then matchcount = 3
                    matchcount++;

            }

            while(matchcount == t.length() && i<s.length())
            {
                int temp = j-i+1;
                if(min>temp)
                {
                    fromi=i;
                    fromj=j;
                }
                min = Math.min(min,temp);

                char sch = s.charAt(i);
                int freq = input.get(sch);

                input.put(sch,freq-1);// hm=A->0,B->1,C->1,
                if(mh.containsKey(sch))
                {
                    if(freq<=mh.get(sch)) // 0<1
                        matchcount--;
                }

                i++;
            }
        }

        if(fromi==-1 || fromj==-1)
            return "";

        return s.substring(fromi,fromj+1);

    }
}