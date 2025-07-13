package Playground;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommanAncestorOfBinaryTree {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode result = null;
            Boolean found = false;

            while(!found){
                boolean leftHasPQ = hasPQ(root.left, p.val, q.val);
                boolean rightHasPQ = hasPQ(root.right, p.val, q.val);
                if(leftHasPQ && rightHasPQ){
                    result = root;
                    found = true;
                }else{
                    if(leftHasPQ){
                        if(root.val == p.val || root.val == q.val){
                            result = root;
                            found = true;
                        }

                        root = root.left;

                    }else{
                        if(root.val == p.val || root.val == q.val){
                            result = root;
                            found = true;
                        }

                        root = root.right;
                    }
                }

            }



            return result;
        }

        private boolean hasPQ(TreeNode root, int p, int q){
            //boolean result = false;
            if(root == null)
                return false;

            if(root.val == q || root.val == p){
                return true;
            }

            return false || hasPQ(root.left, p, q) || hasPQ(root.right, p, q);
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    //O(n) solution
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }

            if(root == p || root == q){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right != null){
                return root;
            }else if(left == null){
                return right;
            }else{
                return left;
            }

        }
    }
}
