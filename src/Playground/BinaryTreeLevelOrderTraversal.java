package Playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/

public class BinaryTreeLevelOrderTraversal {

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
        public List<List<Integer>> levelOrder(TreeNode root) {


            List<List<Integer>> result = new ArrayList<>();

            if(root==null){
                return result;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();

                ArrayList<Integer> level = new ArrayList<>();

                while(size>0){
                    root = q.remove();
                    if(root.left!=null){
                        q.add(root.left);
                    }
                    if(root.right!=null){
                        q.add(root.right);
                    }
                    level.add(root.val);
                    size--;
                }

                result.add(level);

            }
            return result;

        }
    }
}
