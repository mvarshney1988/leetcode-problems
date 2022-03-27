package com.medium.array.mostwatercontainer;

public class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int sum=0;
        while(left<right){
            if(height[left]<height[right]){
                sum=Math.max(sum,height[left]*(right-left));
                left++;
            }else{
                sum=Math.max(sum,height[right]*(right-left));
                right--;
            }


        }
        return sum;
    }
}