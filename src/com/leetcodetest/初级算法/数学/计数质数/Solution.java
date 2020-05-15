package com.leetcodetest.初级算法.数学.计数质数;

/**
 * 网上百度了半天优化的 isPrime 方法, 只是勉强通过, 性能太差, 请看python版
 */
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {

        if (n == 2 || n == 3) return true;

        if (n % 6 != 1 && n % 6 != 5) return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(10));
        System.out.println(s.countPrimes(20));
    }
}