package com.arr.kthlargest;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Set<Integer> vals = new TreeSet<>(Collections.reverseOrder());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        Iterator it= queue.iterator();
        int count=0;
        Integer e=0;
        while(it.hasNext()){
            e=queue.poll();
            System.out.println(e);
            count++;
            if(count==k){
                break;
            }
        }
        return count==k?e:queue.peek();
    }
}
