package Playground;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/same-tree/description/

public class SameTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if(q==null && p==null){
                return true;
            }else if(q == null || p == null){
                return false;
            }

            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();

            q1.add(p);
            q2.add(q);

            if(q==null && q==null){
                return true;
            }

            while(!q1.isEmpty() && !q2.isEmpty()){

                if(q1.size() != q2.size()){
                    return false;
                }

                int size= q1.size();
                while(size > 0){
                    TreeNode n1 = q1.remove();
                    TreeNode n2 = q2.remove();
                    if(n1.val != n2.val){
                        return false;
                    }

                    if(n1.left!=null){
                        q1.add(n1.left);
                    }else if(n2.left!=null){
                        return false;
                    }

                    if(n1.right!=null){
                        q1.add(n1.right);
                    }else if(n2.right!=null){
                        return false;
                    }

                    if(n2.left!=null){
                        q2.add(n2.left);
                    }else if(n1.left!=null){
                        return false;
                    }

                    if(n2.right!=null){
                        q2.add(n2.right);
                    }else if(n1.right!=null){
                        return false;
                    }

                    size--;
                }

            }

            if(q1.isEmpty() && q2.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    }
}
