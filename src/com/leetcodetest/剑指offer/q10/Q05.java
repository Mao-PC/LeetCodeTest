package com.leetcodetest.剑指offer.q10;

public class Q05 {
    static class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) return "";
            StringBuilder builder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    builder.append("%20");
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.replaceSpace("We are happy."));
    }
}
