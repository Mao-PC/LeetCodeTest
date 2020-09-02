package com.leetcodetest.stackq.ten2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 */
public class Q739 {
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];

            for (int i = 0, j = i + 1; i < T.length && j < T.length; ) {
                int m = T[i];
                int n = T[j];
                if (m < n) {
                    res[i] = j - i;
                    i++;
                    j = i + 1;
                } else {
                    j++;
                }
                if (j == T.length) {
                    res[i] = 0;
                    i++;
                    j = i + 1;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
