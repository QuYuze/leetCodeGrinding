package Playground;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();

            if(root==null){
                return result;
            }else{
                dfs(root, targetSum, new ArrayList<Integer>(), 0, result);
                return result;
            }

        }

        public void dfs(TreeNode root, int targetSum, ArrayList<Integer> temp, int currSum, List<List<Integer>> result){

            if(root.left == null && root.right == null && currSum+root.val == targetSum){
                temp.add(root.val);
                result.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
            }else{

                temp.add(root.val);
                if(root.left!=null){
                    dfs(root.left, targetSum, temp, currSum+root.val, result);
                }
                if(root.right!=null){
                    dfs(root.right, targetSum, temp, currSum+root.val, result);
                }

                temp.remove(temp.size()-1);
            }

        }


    }
}
