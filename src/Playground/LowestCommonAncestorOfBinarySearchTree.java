package Playground;

public class LowestCommonAncestorOfBinarySearchTree {

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

            int big = 1;
            int small = 0;

            if(q.val<p.val){
                small = q.val;
                big = p.val;
            }else{
                small = p.val;
                big = q.val;
            }

            while(true){
                if(root.val < big && root.val > small){
                    return root;
                }else if(root.val <= small){
                    if(root.val == small){
                        return root;
                    }
                    root = root.right;

                }else{
                    if(root.val == big){
                        return root;
                    }
                    root = root.left;
                }
            }

        }


    }
}
