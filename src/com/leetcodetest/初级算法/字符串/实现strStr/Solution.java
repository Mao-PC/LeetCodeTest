package com.leetcodetest.初级算法.字符串.实现strStr;

class Solution {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null || "".equals(needle)) return 0;
        if (haystack.length() < needle.length()) return -1;

        int index = 0;
        while (index + needle.length() <= haystack.length()) {
            boolean flag = true;
            for (int i = 0; i < needle.length(); i++) {
                if (needle.charAt(i) != haystack.charAt(index+i)){
                    flag = false;
                    break;
                }
            }
            if (flag) return index;
            index++;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("mississippi", "mississippi"));
    }
}