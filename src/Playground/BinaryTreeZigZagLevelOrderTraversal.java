package Playground;

import java.util.*;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigZagLevelOrderTraversal {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();

            if(root == null){
                return result;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int level = 0;

            while(!q.isEmpty()){
                ArrayList<Integer> list = new ArrayList<>();
                int size = q.size();
                while(size>0){
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

                if(level%2==0){
                    result.add(list);
                }else{
                    Collections.reverse(list);
                    result.add(list);
                }

                level++;


            }

            return result;

        }
    }
}
