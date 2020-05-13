package com.leetcodetest.初级算法.动态规划.爬楼梯;

import java.util.Date;

class Solution {

    public int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;

        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(45));
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(4));
        System.out.println(s.climbStairs(5));
    }
}