from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        for i in range(len(prices)-1):
            profit = prices[i+1] - prices[i]
            if profit > 0:
                maxProfit += profit

        return maxProfit


s = Solution()
prices = [7, 1, 5, 3, 6, 4]
print(s.maxProfit(prices))
prices = [1, 2, 3, 4, 5]
print(s.maxProfit(prices))
prices = [7, 6, 4, 3, 1]
print(s.maxProfit(prices))
