class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sArr = [0]*26

        for i in range(len(s)):
            sArr[ord(s[i]) - 97] += 1
            sArr[ord(t[i]) - 97] -= 1

        for i in sArr:
            if i != 0:
                return False

        return True


s = Solution()
print(s.isAnagram("anagram", "anagram"))
print(s.isAnagram("nl", "cx"))
