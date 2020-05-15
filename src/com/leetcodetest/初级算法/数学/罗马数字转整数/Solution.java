package com.leetcodetest.初级算法.数学.罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cNum = getNum(s.charAt(i));
            if (i == s.length() - 1) {
                res = cNum;
                continue;
            }
            int preNum = getNum(s.charAt(i + 1));
            if (cNum < preNum) {
                res -= cNum;
            } else {
                res += cNum;
            }
        }
        return res;
    }

    private int getNum(char k) {
        switch (k) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("III"));    //3
        System.out.println(s.romanToInt("IV"));     //4
        System.out.println(s.romanToInt("IX"));     //9
        System.out.println(s.romanToInt("LVIII"));  //58
        System.out.println(s.romanToInt("MCMXCIV"));//1994
    }
}