from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = {}
        for i in range(len(nums)):
            cNum = nums[i]
            if res.get(target-cNum) == None:
                res[cNum] = i
            else:
                sb = [res[target-cNum], i]
                return sb


s = Solution()
nums = [2, 7, 11, 15]
print(s.twoSum(nums, 9))
