package com.medium.dp.recursion;

import java.util.Map;

public class Fib {
    static int[] arr = new int[1000];
    public static void main(String[] args) {
        //5
        //011235813

        int n=6;
        for(int i=1;i<=n;i++) {
            System.out.println(fib(i));
        }
    }

   static int fib(int n){
        if(n <2)
            return n;
        if(arr[n] !=0){
            return arr[n];
        }
        arr[n]= fib(n-1) + fib(n-2);
        return arr[n];
    }
//fib(2)=1 + fib(1)=1
// fib(1)


}
