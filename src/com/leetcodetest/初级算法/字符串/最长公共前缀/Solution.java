package com.leetcodetest.初级算法.字符串.最长公共前缀;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i == str.length()) {
                    return res;
                } else {
                    if (str.charAt(i) != strs[0].charAt(i)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag){
                return res;
            }
            res += strs[0].charAt(i);
        }
        return res;
    }
}

class  Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}