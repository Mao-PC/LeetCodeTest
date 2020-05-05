class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        flag = x >= 0
        x = x if flag else -x
        while x != 0:
            res = x % 10 + res * 10
            x = x // 10

        res = res if flag else -res

        res = res if res <= 2 ** 31 - 1 and res >= -2 ** 31 else 0

        return res


s = Solution()

print(s.reverse(123))
print(s.reverse(-123))
print(s.reverse(120))
print(s.reverse(1534236469))
