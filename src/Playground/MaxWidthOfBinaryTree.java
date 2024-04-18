package Playground;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    class Solution {


        public int widthOfBinaryTree(TreeNode root) {

            int result = 0;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair<Integer, TreeNode>(0, root));

            while(!q.isEmpty()){

                int size = q.size();
                int start = 0;
                int end = 0;

                for(int i = 0; i<size; i++){

                    Pair<Integer, TreeNode> curr = q.remove();
                    root = curr.getValue();
                    int position = curr.getKey();

                    if(i==0){
                        start = position;
                    }
                    if(i==size-1){
                        end = position;
                    }

                    if(root.left!=null){
                        q.add(new Pair<Integer, TreeNode>(2*position, root.left));
                    }

                    if(root.right!=null){
                        q.add(new Pair<Integer, TreeNode>(2*position+1, root.right));

                    }



                }

                result = Math.max(result, end-start+1);
            }

            return result;

        }



    }
}
