package com.leetcodetest.初级算法.数组.存在重复;

import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,255,257};
        System.out.println(new Solution().containsDuplicate(arr));
        arr = new int[]{1,2,3,4};
        System.out.println(new Solution().containsDuplicate(arr));
        arr = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(new Solution().containsDuplicate(arr));
    }
}