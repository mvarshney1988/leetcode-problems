package com.easy.divideconquer;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8,13,17,19};
        int search = 2;
        int found = binarySearch(arr,0,arr.length, search);
        System.out.println("found at index " +found);
    }

    private static int binarySearch(int[] arr, int start, int end, int element) {
        if(start<end){


int mid = (start+end)/2;

if(arr[mid] == element)
    return mid;
if(arr[mid] > element)
    return binarySearch(arr,start,mid ,element);

return binarySearch(arr,mid+1, end, element);
        }
        return -1;
    }
}
