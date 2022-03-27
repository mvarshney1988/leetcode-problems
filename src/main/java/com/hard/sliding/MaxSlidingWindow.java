package com.hard.sliding;

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
        int i = 0;
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        while(i < nums.length){
            // Add elements in queue if window size is less than k
            if(i-j < k){
                queue.add(new Num(nums[i], i));
                i++;
            }
            // If reached at window size k, check the largest number
            if(i-j == k) {
                ans[j++] = queue.peek().data;
            }
            // Remove the highest number if goes out of window
            while(!queue.isEmpty() && queue.peek().index < j){
                queue.poll();
            }
        }
        return ans;
    }
}

