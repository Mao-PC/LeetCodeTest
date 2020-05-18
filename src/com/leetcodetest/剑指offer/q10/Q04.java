package com.leetcodetest.剑指offer.q10;

public class Q04 {

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int x = 0;
            int y = 0;
            int lengthY = matrix.length;
            if (lengthY == 0) return false;
            int lengthX = matrix[0].length;
            if (lengthX == 0) return false;
            for (; x < lengthX; ) {
                int value = matrix[y][x];
                if (value > target || x == lengthX - 1) {
                    for (; y < lengthY; ) {
                        value = matrix[y][x];
                        if (value == target) {
                            return true;
                        } else if (value > target) {
                            x--;
                        } else {
                            y++;
                        }

                        if (x < 0 || y == lengthY) return false;
                    }
                } else if (value == target) {
                    return true;
                } else {
                    x++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumberIn2DArray(new int[][]{
                {1, 5, 10, 15, 20},
                {10, 15, 19, 22, 29},
                {21, 22, 27, 30, 36},
                {23, 25, 32, 35, 40},
                {28, 33, 37, 41, 50}
        }, 31));
    }
}
