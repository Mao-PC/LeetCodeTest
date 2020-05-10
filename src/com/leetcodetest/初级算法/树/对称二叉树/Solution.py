class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        return self.isSymmetricInner(root.left, root.right)

    def isSymmetricInner(self, left: TreeNode, right: TreeNode) -> bool:

        if left == None and right == None:
            return True

        if left != None and right != None and left.val == right.val:
            return self.isSymmetricInner(left.left, right.right) and self.isSymmetricInner(left.right, right.left)
        else:
            return False


root = TreeNode(1)
node1 = TreeNode(2)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(4)
node6 = TreeNode(3)

root.left = node1
root.right = node2

node1.left = node3
node1.right = node4
node2.left = node6
node2.right = node5

s = Solution()
print(s.isSymmetric(root))
