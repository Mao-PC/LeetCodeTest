package com.leetcodetest.初级算法.字符串.整数反转;

class Solution {
    public int reverse(int x) {
        long res = 0;
        int length = (x + "").length() - 1;
        length = x > 0 ? length : length - 1;
        for (int i = length; i >= 0; i--) {
            double divisor = Math.pow(10, i);
            double multiplier = Math.pow(10, length - i);
            double item = ((int) (x / divisor)) * multiplier;
            x -= (int) (x / divisor) * divisor;
            res += item;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;

        return (int)res;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Solution s = new Solution();
        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(1534236469));
    }
}