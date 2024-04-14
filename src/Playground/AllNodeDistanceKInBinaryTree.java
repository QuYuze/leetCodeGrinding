package Playground;

import java.util.*;

public class AllNodeDistanceKInBinaryTree {

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
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            HashMap<TreeNode, TreeNode> parent = new HashMap<>();
            HashSet<TreeNode> visited = new HashSet<>();
            List<Integer> result = new ArrayList<>();

            q.add(root);
            while(!q.isEmpty()){

                TreeNode curr = q.remove();
                if(curr.right!=null){
                    parent.put(curr.right, curr);
                    q.add(curr.right);
                }
                if(curr.left!=null){
                    parent.put(curr.left, curr);
                    q.add(curr.left);
                }
            }

            q = new LinkedList<TreeNode>();
            q.add(target);

            while(k>0){
                int size = q.size();

                while(size>0){
                    TreeNode curr = q.remove();
                    visited.add(curr);

                    if(parent.containsKey(curr)){
                        if(!visited.contains(parent.get(curr))){
                            q.add(parent.get(curr));
                        }
                    }

                    if(curr.left!=null){
                        if(!visited.contains(curr.left)){
                            visited.add(curr.left);
                            q.add(curr.left);
                        }
                    }
                    if(curr.right!=null){
                        if(!visited.contains(curr.right)){
                            visited.add(curr.right);
                            q.add(curr.right);
                        }
                    }

                    size--;
                }
                k--;

            }

            while(!q.isEmpty()){
                result.add(q.remove().val);
            }

            return result;

        }
    }
}
