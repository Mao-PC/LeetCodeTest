from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()

        i, j = 0, 0

        arr = []

        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                arr.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                i += 1
        return arr


s = Solution()
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
print(s.intersect(nums1, nums2))
