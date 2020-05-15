package com.leetcodetest.初级算法.数学.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            String str = "";

            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) str += "Fizz";
                if (i % 5 == 0) str += "Buzz";
            } else {
                str += i;
            }

            res.add(str);
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
}