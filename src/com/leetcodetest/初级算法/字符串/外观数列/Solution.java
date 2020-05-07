package com.leetcodetest.初级算法.字符串.外观数列;

class Solution {
    public String countAndSay(int n) {
        if (n < 1 || n > 30) return "";

        if (n == 1) return "1";
        if (n == 2) return "11";
        String res = "1";
        int i = 1;
        while (i != n) {
            res = getStr(res);
            i ++;
        }
        return res;

    }

    private String getStr(String str) {
        if (str.equals("1")) return "11";

        String res = "";
        int i = 0;
        char c = str.charAt(i);
        int count = 1;
        i++;
        while (i< str.length()) {
            if (c == str.charAt(i)) {
                count++;
            } else {
                res += count;
                res += c;

                count = 1;
                c = str.charAt(i);
            }
            i++;
        }
        res += count;
        res += c;
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));
        System.out.println(solution.countAndSay(7));
    }
}