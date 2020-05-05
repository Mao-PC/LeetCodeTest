package com.leetcodetest.初级算法.字符串.翻转字符串;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char c = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = c;
        }
        System.out.println(Arrays.toString(s));
    }
}
class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        s.reverseString(chars);
        chars = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        s.reverseString(chars);
    }
}