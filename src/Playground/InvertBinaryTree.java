package Playground;

public class InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode newLeft = invertTree(root.left);
            TreeNode newRight = invertTree(root.right);
            root.left = newRight;
            root.right = newLeft;

            return root;
        }

    }
}
