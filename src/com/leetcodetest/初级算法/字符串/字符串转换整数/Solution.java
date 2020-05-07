package com.leetcodetest.初级算法.字符串.字符串转换整数;

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        long res = 0L;
        // 1 正数 -1 负数
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            long cIndex = c;
            if (cIndex >= 48 && cIndex <= 57) {
                if (flag == 0) flag = 1;
                if (res > 0) res = res * flag;
                if (flag == 1) {
                    res = (long)res * 10 + cIndex-48;
                } else {
                    res = (long)res * 10 - cIndex+48;
                }
                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else if (c == ' ' && res == 0 && flag == 0) {
                continue;
            } else if (c == '-' && flag == 0) {
                flag = -1;
            } else if (c == '+' && flag == 0){
                flag = 1;
            } else {
                if (res != 0) {
                    break;
                } else {
                    return 0;
                }
            }
        }
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("  +42"));
        System.out.println(solution.myAtoi("-1"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("   +0 123"));
    }
}