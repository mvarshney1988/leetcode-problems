package com.hard.divideconquer.mediantwosorted;

import java.util.Arrays;

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums2 == null || nums1 == null) || (nums1.length ==0 && nums2.length==0)){
            return 0.0;
        } else
        if(nums1.length==1 && nums2.length==0){
            return nums1[0];
        } else if(nums2.length==1 && nums1.length==0){
            return nums2[0];
        } else if(nums2.length==1 && nums1.length==1){
            double o=(nums2[0]+nums1[0]);
            return o/2;
        }
        int[] arr = new int[nums1.length+nums2.length]; //3
        System.out.println(arr.length);
        //2>1

        int j=0,i=0,k=0;
        while(k<(arr.length)){//i==3

            if(nums1.length>nums2.length){
                if(nums2.length > 0 && nums1.length >0 && nums1[nums1.length-1] < nums2[0]){
                    if(i<nums1.length){
                        arr[k]=nums1[i];
                        i++;
                    }
                    else{
                        if(j<nums2.length){
                            arr[k]=nums2[j];
                            j++;
                        }
                    }
                } else
                if(j<nums2.length){
                    if(nums1[i]<nums2[j]){ // 1<2
                        arr[k]=nums1[i]; //1
                        arr[++k]=nums2[j];//2
                    }else{
                        arr[k]=nums2[i];
                        arr[++k]=nums1[j];
                    }
                    j++;//1
                    i++;
                    k++;
                }else{
                    break;
                }
            } else{
                if(nums2.length > 0 && nums1.length >0 && nums2[nums2.length-1] < nums1[0]){
                    if(j<nums2.length){
                        arr[k]=nums2[j];
                        j++;
                    } else{
                        if(i<nums1.length){
                            arr[k]=nums1[i];
                            i++;
                        }
                    }

                    k++;

                } else if(i<nums1.length){
                    if(nums1[i]<nums2[j]){ // 1<2
                        arr[k]=nums1[i]; //1
                        arr[++k]=nums2[j];//2
                    }else{
                        arr[k]=nums2[i];
                        arr[++k]=nums1[i];
                    }
                    j++;//1
                    i++;
                    k++;
                }else{
                    break;
                }
            }

        }


        if(nums2.length>nums1.length){
            while(k<arr.length && j<nums2.length){
                arr[k]=nums2[j];
                System.out.println(Arrays.toString(arr));
                j++;
                k++;
                if(k>arr.length/2){
                    if(arr.length%2==0){

                        double o= ((arr[((arr.length/2))]) + (arr[((arr.length/2)-1)]));
                        return o/2;
                    }
                    return arr[arr.length/2];
                }
            }
        }else if(nums2.length<nums1.length){
            while(k<arr.length && i<nums1.length){
                arr[k]=nums1[i];

                i++;
                k++;
                if(k>arr.length/2){
                    if(arr.length%2==0){
                        double o= ((arr[((arr.length/2))]) + (arr[((arr.length/2)-1)]));
                        return o/2;
                    }
                    return arr[arr.length/2];
                }
            }
        }


        if((arr.length)%2==0){
            System.out.println("length"+arr.length);
            double o= ((arr[((arr.length/2))]) + (arr[((arr.length/2)-1)]));
            return o/2;
        }
        return arr[arr.length/2];
    }
}