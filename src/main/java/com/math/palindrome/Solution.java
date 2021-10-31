package com.math.palindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x<10 )
            return true;



        int length=0;
        int y=x;
        while(y>0){
            //int y=x%10;
            y=y/10;
            //  a[i]=y;
            length++;
        }
        System.out.println(length);
        int[] a =new int[length];
        for(int i=0;i<a.length;i++){
            a[i]=x%10;
            x=x/10;
        }
        int l = a.length-1;
        for(int k=0; k<a.length/2;k++){

            if(a[k]!=a[l--])
                return false;

        }

        return true;
    }
}
