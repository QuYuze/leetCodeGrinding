package Playground;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

public class BinaryTreeLevelOrderTraversalII {


    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }

            Stack<ArrayList> stack = new Stack<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                ArrayList<Integer> list = new ArrayList<>();
                while(size > 0){
                    TreeNode curr = q.remove();
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }

                    list.add(curr.val);
                    size--;
                }
                stack.push(list);
            }

            while(!stack.isEmpty()){
                result.add(stack.pop());
            }


            return result;
        }
    }
}
