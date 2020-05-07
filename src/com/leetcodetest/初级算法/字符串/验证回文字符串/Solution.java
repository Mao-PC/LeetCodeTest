package com.leetcodetest.初级算法.字符串.验证回文字符串;

class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = check(s.charAt(left));

            if (leftChar == '-') {
                left++;
                continue;
            }

            char rightChar = check(s.charAt(right));

            if (rightChar == '-') {
                right--;
                continue;
            }

            if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 全部转为小写
     *
     * @param c
     * @return
     */
    private char check(char c) {
        int cIndex = c;
        if (cIndex >= 65 && cIndex <= 90) {
            return (char) (cIndex + 32);
        } else if (cIndex >= 97 && cIndex <= 122 || cIndex >= 48 && cIndex <= 57) {
            return c;
        } else {
            return '-';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("0p"));
    }
}