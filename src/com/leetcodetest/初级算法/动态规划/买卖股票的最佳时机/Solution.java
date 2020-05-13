package com.leetcodetest.初级算法.动态规划.买卖股票的最佳时机;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int[] index = new int[prices.length];

        for (int i = 0; i < index.length; i++)
            index[i] = i;


        // 排序
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    int item = prices[j];
                    prices[j] = prices[i];
                    prices[i] = item;

                    item = index[j];
                    index[j] = index[i];
                    index[i] = item;
                }
            }
        }

        int minIndex = 0;
        int maxIndex = prices.length-1;

        int diff = 0;

        while (maxIndex >= minIndex) {
            if (index[maxIndex] > index[minIndex]) {
                return index[maxIndex];
            } else {
                
            }
        }
    }
}