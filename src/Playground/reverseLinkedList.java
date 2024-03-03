package Playground;
//https://leetcode.com/problems/reverse-linked-list/description/
public class reverseLinkedList {


      public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseList(ListNode head) {

            if(head==null){
                return head;
            }else if(head.next==null){
                return head;
            }

            ListNode pre = null;
            ListNode curr = head;
            ListNode temp = null;

            while(curr!=null){
                if(pre == null){
                    pre = curr;
                    temp = curr.next;
                    curr.next = null;
                    curr = temp;
                }else{
                    temp = curr.next;
                    curr.next = pre;
                    //System.out.println(curr.val);
                    if(temp!=null){
                        pre = curr;
                        curr = temp;

                    }else{
                        break;
                    }


                }
            }
            head = curr;

            return head;

        }
    }
}
