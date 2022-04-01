package com.hard.divideconquer.mediantwosorted;
// cheatsheet
// take min length array and loop through end and reset x pointer for start and end.
// formula for x partition-low+high/2, part y = x+y+1/2-partx
// find max min of both array and check cross value comparison, if matches
// if comibined array is even, take avg of both max and both min else take max of both max

public class SolutionBS {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,8,12,14};
        int[] arr2 = {2,4,7,9,13,16,17}; // 1,2,3,4,5,7,8,9,12,13,14,16,17

        System.out.println(new SolutionBS().findMedianSortedArrays(arr1,arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSorted(nums2, nums1);
        }
        return findMedianSorted(nums1, nums2);
    }

    private double findMedianSorted(int[] nums1, int[] nums2){
        int start = 0;
        int end = nums1.length;
        int x = nums1.length;
        int y = nums2.length;
        while(start<=end){
            int partx = (start+end)/2;
            int party = ((x+y+1)/2)-partx;

            int maxX = partx == 0? Integer.MIN_VALUE:nums1[partx-1];
            int maxY = party == 0 ? Integer.MIN_VALUE:nums2[party-1];
            int minX = (partx == x)? Integer.MAX_VALUE:nums1[partx];

            int minY = (party == y) ? Integer.MAX_VALUE:nums2[party];
            if(maxX<=minY && maxY<=minX){
                if((x+y)%2==0){
                    return (double)(Math.max(maxX,maxY)+Math.min(minX,minY))/2 ;
                }
                return (double)Math.max(maxX,maxY);

            }else if(maxX>minY){
                end = partx-1;
            }else{
                start = partx+1;
            }


        }
        return 0.0;
    }
}
