package com.leetcodetest.初级算法.字符串.有效的字母异位词;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        // 小写字母范围是 97 - 122
        int[] sChars = new int[26];
        int[] tChars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 97] ++;
            tChars[t.charAt(i) - 97] ++;
        }

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) return false;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("nl", "cx"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}