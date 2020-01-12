from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        index = -1
        for i in range(len(digits)-1, -1, -1):
            if digits[i] == 9:
                index = i
            else:
                break

        if index == 0:
            return [1] + [0]*len(digits)
        elif index == -1:
            return digits[:-1]+[digits[len(digits)-1]+1]
        else:
            return digits[:index-1] + [digits[index-1] + 1] + [0]*(len(digits)-index)


s = Solution()
nums = [1, 2, 2, 9]
print(s.plusOne(nums))
nums = [1, 2, 2, 1]
print(s.plusOne(nums))
nums = [9, 9]
print(s.plusOne(nums))
