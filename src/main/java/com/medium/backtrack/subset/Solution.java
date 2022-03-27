package com.medium.backtrack.subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> op = new Solution().subsets(new int[]{0, 1, 2});
        System.out.println(op);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        return calculateSubsets(subs,new ArrayList<>(),nums,0);
    }

    public List<List<Integer>> calculateSubsets(List<List<Integer>> subs,List<Integer> ints,int[] nums,int start){
        subs.add(new ArrayList<>(ints)); // add blank subset
        // add another subset with value 0
        // add another subset with value 0,1
        // add another subset with value 0,1,2
        // need to goback to calculateSubsets method for line 23 so require return statement , line 25.
        for(int i=start;i<nums.length;i++){ //0-2 for 3 length as , 0,1,2
            System.out.println(i);
            ints.add(nums[i]);  // start populating into blank subset (added 0) ,
            // start populating into last subset (0,1),
            // start populating into last subset (0,1,2)
            calculateSubsets(subs, ints, nums,i+1);
            ints.remove(ints.size()-1); // remove 0-1-2, then remove 0-1, then remove 0
        }
        return subs; // total size 0,0-1,0-1-2


    }
}
