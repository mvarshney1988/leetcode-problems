package com.medium.heap.topkfreq;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1){
            return nums;
        }
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue pq = new PriorityQueue(count.size(), new Comparator<Map.Entry<Integer,Integer>>(){

            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
                if(o2.getValue()==o1.getValue()){
                    return Integer.compare(o2.getKey(),o1.getKey());
                }
                return Integer.compare(o2.getValue(),o1.getValue());
            }
        });
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            pq.offer(entry);
        }
        System.out.println(pq.size());
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> ee = (Map.Entry<Integer,Integer>)pq.poll();
            res[i]=(ee.getKey());
        }
        return res;
    }
}