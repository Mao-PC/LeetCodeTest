package com.leetcodetest.初级算法;

public class Test {
    static void test (StringBuffer m, StringBuffer n) {
        m.append(" world");
        n = m;
    }

    public static void main(String[] args) {
        final StringBuffer m = new StringBuffer("hello ");
        StringBuffer n = new StringBuffer("hello ");
        Test.test(m, n);
        System.out.println(m);
        System.out.println(n);
    }
}

