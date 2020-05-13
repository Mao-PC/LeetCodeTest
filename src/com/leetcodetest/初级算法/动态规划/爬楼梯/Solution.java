package com.leetcodetest.初级算法.动态规划.爬楼梯;

import java.util.Date;

class Solution {

    int[] cache = new int[]{1, 2};

    public int climbStairs(int n) {
        if (n < 1) return 0;

        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        long cTime = new Date().getTime();
        System.out.println(s.climbStairs(45));
        System.out.println(new Date().getTime() - cTime);
    }
}