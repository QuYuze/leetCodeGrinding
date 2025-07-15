package Playground;

public class ReorderList {
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
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            } else if (head.next == null) {
                return;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            //System.out.println(slow.val);
            ListNode second = slow.next;
            slow.next = null;
            ListNode pre = null;

            while(second != null){
                ListNode temp = second.next;
                second.next = pre;
                pre = second;
                second = temp;
            }

            //System.out.println(slow.val);

            ListNode first = head;
            second = pre;

            while(second != null){
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;

                first.next = second;
                second.next = temp1;

                first = temp1;
                second = temp2;
            }




        }
    }
}
