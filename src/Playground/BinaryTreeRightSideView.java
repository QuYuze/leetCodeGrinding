package Playground;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            travel(root, result, 0);

            return result;

        }

        public void travel(TreeNode root, List result, int depth){
            if(root==null){
                return;
            }else if(result.size()==depth){
                result.add(root.val);
            }
            travel(root.right, result, depth+1);
            travel(root.left, result, depth+1);
        }

    }

}
