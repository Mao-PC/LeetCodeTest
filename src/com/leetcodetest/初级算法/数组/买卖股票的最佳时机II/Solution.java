package com.leetcodetest.初级算法.数组.买卖股票的最佳时机II;

class Solution {
    /**
     * 用 n + 1个数 减 n, 如果是正数 就说明有收益, 负数就没有, 然后相加
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;

        for (int i = 0; i < prices.length-1; i++) {
            int profit = prices[i+1] - prices[i];
            if (profit > 0) total += profit;
        }
        return total;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
        prices = new int[] {1,2,3,4,5};
        System.out.println(s.maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(s.maxProfit(prices));
    }
}