package Playground;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree(){
        this.root = null;
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        List<Integer> traverseList = bst.InOrderTreeTraverse();
        System.out.println(traverseList);

    }

    public void insert(int val){
        TreeNode newNode = new TreeNode(val);
        if(this.root == null){
            this.root = newNode;
        }
        TreeNode curr = this.root;
        while (curr!=null){
            if(val == curr.val){
                break;
            }else if(val > curr.val){
                if(curr.right == null){
                    curr.right = newNode;
                    break;
                }else{
                    curr = curr.right;
                }
            }else{
                if(curr.left == null){
                    curr.left= newNode;
                    break;
                }else{
                    curr = curr.left;
                }
            }
        }
    }

    public List<Integer> InOrderTreeTraverse(){
        TreeNode curr = this.root;
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    //TODO this need BFS to complete
    public List<Integer> PreOrderTreeTraverse(){
        List<Integer> result = new ArrayList<Integer>();
        return result;
    }


}
