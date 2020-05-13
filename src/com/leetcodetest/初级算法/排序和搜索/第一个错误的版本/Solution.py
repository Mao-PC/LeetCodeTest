import sys
class Solution:
    def isBadVersion(self, version):
        return version > 1702766719


    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = 0
        right = n
        while left < right:
            mid = (left+right)//2
            if self.isBadVersion(mid):
                right = mid 
            else:
                left = mid + 1
            
        return left

        