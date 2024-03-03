package Playground;

import java.util.Stack;

public class removeNnodeOfLinkedList {

      public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            if(head == null){
                return head;
            }else if(head.next==null && n == 1){
                return null;
            }else{
                Stack<ListNode> stack = new Stack<ListNode>();
                ListNode curr = head;
                while(curr!=null){
                    stack.push(curr);
                    curr = curr.next;
                }
                int i = n;
                ListNode next = null;
                ListNode pre = null;
                while(i!=-1){
                    curr = stack.pop();
                    if(i==2){
                        next = curr;
                    }else if(i==0){
                        pre = curr;
                        break;
                    }else if(i==1 && stack.isEmpty()){
                        head = next;
                        break;
                    }
                    i--;
                }
                if(pre!=null){
                    pre.next = next;
                }

            }
            return head;

        }
    }
}
