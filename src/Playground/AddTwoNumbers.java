package Playground;

//https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = null;
            ListNode pre = null;
            int carry = 0;

            while(l1!=null && l2!=null){
                int currAmount = l1.val + l2.val + carry;
                int currVal = 0;

                if(currAmount >= 10){
                    currVal = currAmount%10;
                    carry = (currAmount - currVal)/10;
                    //System.out.println(carry);
                }else{
                    currVal = currAmount;
                    carry = 0;
                }




                ListNode currNode = new ListNode(currVal);

                if(pre == null){
                    result = currNode;
                }else{
                    pre.next = currNode;
                }

                pre = currNode;
                l1 = l1.next;
                l2 = l2.next;

            }

            while(l1!=null){
                int currAmount = l1.val + carry;
                int currVal = 0;

                if(currAmount >= 10){
                    currVal = currAmount%10;
                    carry = (currAmount - currVal)/10;
                    //System.out.println(carry);
                }else{
                    currVal = currAmount;
                    carry = 0;
                }
                ListNode currNode = new ListNode(currVal);
                pre.next = currNode;
                pre = currNode;
                l1 = l1.next;
            }

            while(l2!=null){
                int currAmount = l2.val + carry;
                int currVal = 0;

                if(currAmount >= 10){
                    currVal = currAmount%10;
                    carry = (currAmount - currVal)/10;
                    //System.out.println(carry);
                }else{
                    currVal = currAmount;
                    carry = 0;
                }
                ListNode currNode = new ListNode(currVal);
                pre.next = currNode;
                pre = currNode;
                l2 = l2.next;
            }

            if(carry>0){
                ListNode currNode = new ListNode(carry);
                pre.next = currNode;
            }

            return result;
        }
    }
}
