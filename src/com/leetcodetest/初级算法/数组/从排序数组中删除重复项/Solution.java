package com.leetcodetest.初级算法.数组.从排序数组中删除重复项;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {

        int lastindex = nums.length;

        for (int i = 0; i < lastindex - 1; i++) {
            for (int j = i+1; j < lastindex;) {
                int item = nums[j];
                if (nums[i] == item) {
                    // 移动 -> 重复的数字移动到最后
                    for (int k = j; k < lastindex-1; k++) {
                        nums[k] = nums[k+1];
                    }
                    nums[lastindex - 1] = item;
                    lastindex --;
                } else {
                    j ++;
                }
            }
        }

        return lastindex;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}