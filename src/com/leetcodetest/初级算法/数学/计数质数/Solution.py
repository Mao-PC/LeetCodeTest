class Solution:
    """
    从3开始，每次加2，因为2的倍数肯定都不是质数，所以将奇数进行判断
    count = n/2  假定所有的奇数都为质数,每次修改奇数的状态时count--，最后奇数的1替换成质数2
    就拿到所有的质数
    """

    def countPrimes(self, n: int) -> int:
        if n == 2:
            return 1

        flags = [True]*n

        count = n//2

        for i in range(3, n, 2):
            if i*i < n:
                if flags[i] is False:
                    continue

                for j in range(i*i, n, 2*i):
                    count = count-1
                    flags[j] = False

        return count


s = Solution()
print(s.countPrimes(10))
print(s.countPrimes(5))
