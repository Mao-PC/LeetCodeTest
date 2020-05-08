class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root == None:
            return 0

        return max(self.maxDepth(root.left), self.maxDepth(root.right))+1


node = TreeNode(3)
node1 = TreeNode(9)
node2 = TreeNode(20)
node3 = TreeNode(15)
node4 = TreeNode(7)
node.left = node1
node.right = node2
node2.left = node3
node2.right = node4
s = Solution()
print(s.maxDepth(node))
