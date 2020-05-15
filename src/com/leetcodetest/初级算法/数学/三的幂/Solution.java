package com.leetcodetest.初级算法.数学.三的幂;

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n != 0) {
            if (n == 1) break;
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(0));
        System.out.println(s.isPowerOfThree(3));
        System.out.println(s.isPowerOfThree(6));
        System.out.println(s.isPowerOfThree(45));
        System.out.println(s.isPowerOfThree(27));
    }
}