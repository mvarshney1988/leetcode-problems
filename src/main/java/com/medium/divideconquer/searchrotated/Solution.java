package com.medium.divideconquer.searchrotated;

public class Solution {
    public int search(int[] nums, int target) {
        int num = bs(nums,0,nums.length-1,target);
        return num;

    }
    private int bs(int[] a, int start, int end, int target){
        if(start>end){
            return -1;
        }

        int mid = (start+end)/2;

        if(a[mid]==target){
            return mid;
        }
        if(a[start] <=a[mid]){
            if(target>=a[start] && target <= a[mid]){
                return bs(a,start,mid-1,target);
            }
            return bs(a,mid+1,end,target);

        }


        if(target>=a[mid+1] && target <= a[end]){
            return bs(a,mid+1,end,target);
        }
        return bs(a,start,mid-1,target);



    }
}
