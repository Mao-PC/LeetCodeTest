package com.leetcodetest.初级算法.其他.帕斯卡三角形;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(new ArrayList<Integer>() {{
            add(1);
        }});
        int size = 2;
        for (int i = 1; i < numRows; i++) {
            List<Integer> cRow = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                List<Integer> preRow = res.get(i - 1);
                cRow.add(((j >= preRow.size()) ? 0 : preRow.get(j)) + ((j - 1 < 0) ? 0 : preRow.get(j - 1)));
            }
            res.add(cRow);
            size++;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }
}