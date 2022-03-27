package com.medium.array.maxsubarr;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(new Solution().maxSubArray());
    }
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum=nums[0];
        int sumsofar=0;
        for (int i=0;i<nums.length;i++){
            sumsofar+=nums[i];
            sumsofar=Math.max(nums[i],sumsofar);

            if(sumsofar>sum){
                sum=sumsofar;
            }



        }
        return sum;
    }

}
