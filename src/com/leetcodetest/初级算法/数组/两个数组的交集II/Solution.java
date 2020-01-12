package com.leetcodetest.初级算法.数组.两个数组的交集II;

import java.util.Arrays;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 排序后使用两个指针来做
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        int resIndex = 0;

        int[] arr = new int[nums1.length > nums2.length ? nums2.length : nums1.length];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                arr[resIndex] = nums1[index1];
                resIndex++;
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }

        int[] resArr = new int[resIndex];

        System.arraycopy(arr, 0, resArr, 0, resIndex);

        return resArr;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));
    }
}