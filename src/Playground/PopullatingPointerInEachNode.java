package Playground;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopullatingPointerInEachNode {

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

    class Solution {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                while(size>0){
                    Node curr = q.remove();
                    if(size == 1){
                        curr.next = null;
                    }else{
                        curr.next = q.peek();
                    }

                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                    size--;
                }
            }



            return root;

        }
    }
}
