package com.leetcodetest.初级算法.排序和搜索.合并两个有序数组;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                System.arraycopy(nums1, index1, nums1, index1 + 1, m - index1);
                nums1[index1] = nums2[index2];
                index2++;
                m++;
            }
            index1++;
        }
        if (index2 < n) {
            System.arraycopy(nums2, index2, nums1, index1, n - index2);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {-2, -1, 0};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}