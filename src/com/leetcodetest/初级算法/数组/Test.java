package com.leetcodetest.初级算法.数组;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "111!!11!1";

        char[] chars = s.replace("!", "").toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}
