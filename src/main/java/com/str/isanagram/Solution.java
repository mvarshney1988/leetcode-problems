package com.str.isanagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(count.containsKey(s.charAt(i))){
                count.put(s.charAt(i), count.get(s.charAt(i))+1);
            }else{
                count.put(s.charAt(i),1);
            }
        }
        System.out.println(count);
        if(count != null){
            for(int i=0;i<t.length();i++){

                if(!count.containsKey(t.charAt(i))){
                    return false;
                }else{

                    if(count.get(t.charAt(i)) == 1){
                        count.remove(t.charAt(i));
                    }else{
                        count.put(t.charAt(i), count.get(t.charAt(i))-1);
                    }
                }
            }
        }
        if(count.size() == 0){
            return true;
        }
        return false;
    }
}
