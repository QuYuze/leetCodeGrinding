package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/rotate-list/

public class RotateList {
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
        public ListNode rotateRight(ListNode head, int k) {

            if(k==0){
                return head;
            }

            ListNode result = null;
            ListNode start = head;
            ListNode end = head;
            ListNode pre = null;

            HashMap<ListNode, ListNode> map = new HashMap<>();
            int size = 0;

            while(head!=null){
                size++;

                if(pre != null){
                    map.put(head, pre);
                }
                pre = head;
                end = head;
                head = head.next;
            }

            if(map.isEmpty()){
                return start;
            }

            k = k%size;

            while(k>0){
                ListNode tailPre = map.get(end);
                tailPre.next = null;
                end.next = start;
                map.put(start, end);
                start = end;
                end = tailPre;

                k--;
            }

            result = start;


            return result;
        }
    }
}
