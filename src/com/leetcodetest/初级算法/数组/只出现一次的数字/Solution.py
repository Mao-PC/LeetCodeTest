from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        res = 0

        for i in range(len(nums)):
            res ^= nums[i]

        return res


s = Solution()
nums = [1, 0, 1]
print(s.singleNumber(nums))
