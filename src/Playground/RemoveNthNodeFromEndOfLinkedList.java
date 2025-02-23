package Playground;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode result = head;
            ListNode fast = head;
            ListNode slow = head;
            ListNode pre = null;
            int size = 1;
            int step = n;

            while(fast.next!=null){

                if(step==1){
                    fast = fast.next;
                    pre = slow;
                    slow = slow.next;


                }else{
                    fast = fast.next;
                    step--;

                }
                size++;
            }

            if(size==n){
                result = head.next;
            }else if(fast==slow){
                pre.next = fast.next;
            }else{
                pre.next = slow.next;
            }

            return result;
        }
    }

}
