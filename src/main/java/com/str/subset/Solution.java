package com.str.subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        return calculateSubsets(subs,new ArrayList<>(),nums,0);
    }

    public List<List<Integer>> calculateSubsets(List<List<Integer>> subs,List<Integer> ints,int[] nums,int start){
        subs.add(new ArrayList<>(ints));
        for(int i=start;i<nums.length;i++){
            ints.add(nums[i]);
            calculateSubsets(subs, ints, nums,i+1);
            ints.remove(ints.size()-1);
        }
        return subs;

    }
}
