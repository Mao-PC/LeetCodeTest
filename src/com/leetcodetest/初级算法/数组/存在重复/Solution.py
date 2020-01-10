from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        return False


s = Solution()
nums = [1, 2, 3, 4, 5, 6, 7]
print(s.containsDuplicate(nums))
