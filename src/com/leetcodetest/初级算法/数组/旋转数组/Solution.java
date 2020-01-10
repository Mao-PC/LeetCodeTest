package com.leetcodetest.初级算法.数组.旋转数组;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[k];
        System.arraycopy(nums, nums.length - k, arr, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(arr, 0, nums, 0, k);
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}