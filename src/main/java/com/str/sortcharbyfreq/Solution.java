package com.str.sortcharbyfreq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> count = new HashMap<>();
        //   TreeMap<Character,Integer> treecount = new TreeMap<>(new CountComparator(count));
        for(int i=0;i<s.length();i++){
            if(count.containsKey(s.charAt(i))){
                count.put(s.charAt(i),count.get(s.charAt(i))+1);
            }else{
                count.put(s.charAt(i),1);
            }

        }
        List<Map.Entry<Character,Integer>> ll = new ArrayList<>(count.entrySet());
        Collections.sort(ll,new CountComparator());
        StringBuilder ch = new StringBuilder();
        int j=0;
        Iterator it = ll.iterator();
        while(it.hasNext()){
            Map.Entry<Character,Integer> entry= (Map.Entry<Character,Integer>)it.next();
            System.out.println(entry);
            for(int i=j;i<entry.getValue();i++){
                ch.append(entry.getKey());
            }
            j=0;
        }
        return ch.toString();
    }


}
class CountComparator implements Comparator<Map.Entry<Character,Integer>> {


    @Override
    public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2){
        return o2.getValue().compareTo(o1.getValue());
    }

}