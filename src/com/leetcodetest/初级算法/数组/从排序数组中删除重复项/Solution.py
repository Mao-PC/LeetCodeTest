from typing import List


class Solution:
    '''
    如果还是按照 java 的是后面的元素前移修改整个数组效率很低, 会超时

    所以这里需要使用双指针来解决
    '''

    def removeDuplicates(self, nums: List[int]) -> int:
        first = 0
        second = 1

        while(first < second and second < len(nums)):
            if (nums[first] != nums[second]):
                nums[first+1], nums[second] = nums[second], nums[first+1]
                first += 1
            second += 1

        return first + 1


s = Solution()
nums = [1, 1, 2]
print(nums)
print(s.removeDuplicates(nums))
print(nums)
nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
print(s.removeDuplicates(nums))
print(nums)
