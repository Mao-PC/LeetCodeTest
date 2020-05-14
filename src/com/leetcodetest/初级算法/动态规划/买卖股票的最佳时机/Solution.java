package com.leetcodetest.初级算法.动态规划.买卖股票的最佳时机;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        return profit;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}