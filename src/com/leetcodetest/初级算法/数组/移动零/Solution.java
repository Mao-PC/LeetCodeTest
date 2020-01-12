package com.leetcodetest.初级算法.数组.移动零;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ) {
            if (nums[i] == 0) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - (i + 1));
                nums[nums.length - 1] = 0;
                size--;
            } else {
                i++;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{0, 0, 1};
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}