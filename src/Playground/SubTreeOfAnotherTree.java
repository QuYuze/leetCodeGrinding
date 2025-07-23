package Playground;

public class SubTreeOfAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null){
                return false;
            }else if(isSame(root, subRoot)){
                return true;
            }else{
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            }
        }

        private boolean isSame(TreeNode root, TreeNode subRoot){
            if(root == null && subRoot == null){
                return true;
            }else if(root == null || subRoot == null){
                return false;
            }else if(root.val == subRoot.val){
                return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
            }else{
                return false;
            }
        }
    }
}
