package com.arr.arrtobst;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }


    public TreeNode getTree(int[] nums,int start, int last){
        if(start>last){

            return null;
        }
        int mid=(start+last)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=getTree(nums,start,mid-1);
        root.right=getTree(nums,mid+1,last);
        return root;
    }
}



