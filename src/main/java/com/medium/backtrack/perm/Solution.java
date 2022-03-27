package com.medium.backtrack.perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> perms = new HashSet<>();
        List<List<Integer>> pp = new ArrayList<>();
        perm(perms, nums,0);
        pp.addAll(perms);
        return pp;
    }

    Set<List<Integer>> perm(Set<List<Integer>> perms, int[] nums, int start ){

        perms.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);

            perm(perms,nums,start+1);
            swap(nums,start,i);

        }
        return perms;
    }

    void swap(int[] nums, int start, int i){
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;

    }
}