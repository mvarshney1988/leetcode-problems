package com.medium.dp.recursion;
// cheatsheet
// recursion
// default count for both ways = Int.Max-1
//counnt = include current coin , not increment index, 1+recursive remaining balance
// other count = exclude current coin=>increment index
// min of both
// for memo, pass 2d metrics [index][amount]
public class MinCoin {

    public static void main(String[] args) {
    int[] coins = {1,2,5};
    int amount = 11;
int res= coinChange(coins,0,amount);
    System.out.println(res==Integer.MAX_VALUE-1?-1:res);
    }

    private static int coinChange(int[] coins, int i, int amount) {
        if(amount == 0)
            return 0;
        if(i>= coins.length){
            return Integer.MAX_VALUE-1;
        }
        int coins1 = Integer.MAX_VALUE-1;
        int coins2= Integer.MAX_VALUE-1;
        if(coins[i]<= amount){
            coins1=1+coinChange(coins,i,amount-coins[i]);

        }
        coins2= coinChange(coins,i+1,amount);
        return Math.min(coins1,coins2);
    }

}
