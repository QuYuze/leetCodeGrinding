package Playground;

import java.util.LinkedList;
import java.util.Queue;

public class PathSumIII {

    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            int[] result = new int[1];
            Queue<TreeNode> q = new LinkedList<>();

            while(root!=null || !q.isEmpty()){

                if(root!=null){
                    q.add(root);
                    root = root.left;
                }else{
                    root = q.remove();
                    dfs(root, targetSum, result, 0L);
                    root = root.right;
                }
            }



            return result[0];
        }

        public void dfs(TreeNode root, int targetSum, int[] result, long sum){

            if((root.val + sum) == targetSum){
                result[0]++;
            }

            if(root.left!=null){
                dfs(root.left, targetSum, result, sum+root.val);
            }

            if(root.right!=null){
                dfs(root.right, targetSum, result, sum+root.val);
            }
        }
    }
}
