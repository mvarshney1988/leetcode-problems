package com.sliding;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] n={-1,2,3,5,6,7,2,1};
        int k=3;
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(n,k)));
    }
    class Num {
        int data;
        int index;
        public Num(int data, int index){
            this.data = data;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Num> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.data, a.data));
        int left = 0;
        int right = 0;
        int[] ans = new int[nums.length - k + 1];
        while(right < nums.length){
            // Add elements in queue if window size is less than k
            if(right-left < k){
                queue.add(new Num(nums[right], right));
                right++;
            }
            // If reached at window size k, check the largest number
            if(right-left == k) {
                ans[left++] = queue.peek().data;
            }
            // Remove the highest number if goes out of window
            while(!queue.isEmpty() && queue.peek().index < left){
                queue.poll();
            }
        }
        return ans;
    }
}

