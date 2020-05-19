package com.leetcodetest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static void test (StringBuffer m, StringBuffer n) {
        m.append(" world");
        n = m;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 2);
        System.out.println(list);
    }
}

