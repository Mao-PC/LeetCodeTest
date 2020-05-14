from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 0: return 0
        min = prices[0]
        maxprofit = 0

        for i in range(len(prices)):
            if i > 0 :
                
                diff = prices[i] - min

                if diff > 0 and diff > maxprofit :
                    maxprofit = diff
                
                if min > prices[i] : min = prices[i]

        
        return maxprofit

s = Solution()
print(s.maxProfit([2, 6, 1, 3]))
print(s.maxProfit([7,1,5,3,6,4]))
print(s.maxProfit([]))