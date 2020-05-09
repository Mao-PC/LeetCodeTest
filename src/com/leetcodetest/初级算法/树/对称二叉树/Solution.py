class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None: return True;
        return self.isSymmetric(root.left, root.right)

    def isSymmetric(self, left: TreeNode, right: TreeNode) -> bool:
        if left == null && right == null : return True
        
        if left.val != right.val : return False

        if left != null && right != null && left.val == right.val: 

        
        return False