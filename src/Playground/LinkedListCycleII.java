package Playground;

//https://leetcode.com/problems/linked-list-cycle-ii/solutions/3274329/clean-codes-full-explanation-floyd-s-cycle-finding-algorithm-c-java-python3/

public class LinkedListCycleII {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while(fast!= null && fast.next!= null){

                slow = slow.next;
                fast = fast.next.next;
                if(fast==slow){
                    slow = head;
                    while(fast!= slow){
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }

            return null;
        }
    }
}
