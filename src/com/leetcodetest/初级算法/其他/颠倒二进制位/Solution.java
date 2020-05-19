package com.leetcodetest.初级算法.其他.颠倒二进制位;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num = 0;
        boolean flag = true;
        int i = 0;
        while (n != 0) {
//            System.out.println(i + "\t" + Integer.toBinaryString(n));
            if ((n & 1) == (flag ? 1 : 0)) {
                if (i == 0) {
                    // 负数
                    flag = false;
                } else {
                    num += Math.pow(2, 31 - i);
                }
            }
//            System.out.println("=\t" + Integer.toBinaryString(num));
            n = n >>> 1;
            i++;
        }
        return flag ? num : -num-1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 3;
        int i = s.reverseBits(num);
        System.out.println(i);
        System.out.println(getBinaryString(num));
        System.out.println(getBinaryString(i));
    }

    private static String getBinaryString(int i) {
        String str = Integer.toBinaryString(i);
        String zores = "";
        if (str.length() < 32) {
            for (int j = 0; j < (32 - str.length()); j++) {
                if (j == 0 && i < 0) {
                    zores += "1";
                } else {
                    zores += "0";
                }
            }
        }
        return zores + str;
    }
}