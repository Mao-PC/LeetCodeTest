from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        arr = nums[len(nums)-k:]
        for i in range(len(nums)-1, k-1, -1):
            nums[i] = nums[i-k]

        for i in range(k):
            nums[i] = arr[i]


s = Solution()
nums = [1, 2, 3, 4, 5, 6, 7]
s.rotate(nums, 3)
print(nums)
