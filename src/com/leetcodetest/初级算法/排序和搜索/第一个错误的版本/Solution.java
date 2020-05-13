package com.leetcodetest.初级算法.排序和搜索.第一个错误的版本;

/**
 * 递归效率太低, 请看python版
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return isFirstBad(0, n);
    }

    private int isFirstBad(int start, int end) {

        int mid = (int) (((long)end + (long)start) / 2);

        boolean badVersion = isBadVersion(mid);

        if (!badVersion && isBadVersion(mid + 1)) {
            return mid + 1;
        } else {
            if (badVersion) {
                return isFirstBad(start, mid - 1);
            } else {
                return isFirstBad(mid + 1, end);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2126753390));
    }
}