package com.leetcodetest.初级算法.数组.加一;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (digits[i] + 1 == 10) {
            digits[i] = 0;
            i--;
            if (i == -1) {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                return arr;
            }
        }
        digits[i] += 1;
        return digits;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(s.plusOne(nums1)));
        nums1 = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(s.plusOne(nums1)));
        nums1 = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(s.plusOne(nums1)));
    }
}