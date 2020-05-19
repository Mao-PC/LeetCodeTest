package com.leetcodetest.初级算法.其他.汉明距离;

class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1, 4));
        System.out.println(s.hammingDistance(3, 1));
        System.out.println(s.hammingDistance(533907392, 856466007));
    }
}