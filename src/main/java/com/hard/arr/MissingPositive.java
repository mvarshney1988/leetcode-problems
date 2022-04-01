package com.hard.arr;

import java.util.Arrays;
// cheatsheet
// length of new array , should be length of orig array if max value exceeds the length
// store only those values as index which are less than length =1
// iterate and find element with zero value
public class MissingPositive {
    public static void main(String[] args) {
System.out.println(new MissingPositive().firstMissingPositive(new int[]{1}));
    }
    public int firstMissingPositive(int[] nums) {
        int max = 0;
        int min=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i] > max && nums[i] < Integer.MAX_VALUE && nums[i] >=0){
                max=nums[i];
            }
            if(nums[i] < max && nums[i] < Integer.MAX_VALUE && nums[i] >=0){
                min=nums[i];
            }
        }

        if(min == 0 || max<nums.length){
            max=nums.length;
        }


        int[] nn = new int[max+1];

        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0 && nums[i] <Integer.MAX_VALUE && nums[i] >Integer.MIN_VALUE && nums[i]<=nums.length){
                nn[nums[i]] = 1;
            }
        }
        System.out.println(Arrays.toString(nn));
        for(int j=0;j<nn.length;j++){
            if(nn[j]!=j && nn[j] == 0){
                return j;
            }
        }
        return nn.length;
    }
}
