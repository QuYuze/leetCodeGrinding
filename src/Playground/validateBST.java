package Playground;

//https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution

import java.util.Stack;

public class validateBST {
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }else{
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(root!=null || !stack.isEmpty()){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre!=null && root.val<=pre.val){
                    return false;
                }
                pre = root;
                root = root.right;
            }

        }
        return true;

    }
}
