package Playground;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {


    //priority Queue
    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result = null;
            ListNode pre = null;
            ListNode curr = null;

            if(lists.length == 0 || (lists.length == 1 && lists[0] == null)){
                return result;
            }

            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

            for(ListNode listNode : lists){
                if(listNode != null){
                    pq.add(listNode);
                }
            }

            while(!pq.isEmpty()){
                curr = pq.remove();

                if(curr.next !=null){
                    pq.add(curr.next);
                }

                curr.next = null;

                if(pre != null){
                    pre.next = curr;
                }else{
                    result = curr;
                }

                pre = curr;

            }

            return result;
        }
    }

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

    // merge by pairs -> divide and conquer
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }

            while(lists.length > 1){
                List<ListNode> temp = new ArrayList<>();

                for(int i=0; i<lists.length; i+=2){
                    ListNode l1 = lists[i];
                    ListNode l2 = i + 1 < lists.length ? lists[i+1] : null;
                    temp.add(mergeLists(l1, l2));
                }
                lists = temp.toArray(new ListNode[0]);
            }


            return lists[0];
        }


        private ListNode mergeLists(ListNode l1, ListNode l2){
            if(l2 == null){
                return l1;
            }

            ListNode result = null;
            ListNode pre = null;
            ListNode curr = null;

            while(l1 != null || l2 != null){

                if(l1 == null){
                    curr = l2;
                    l2= l2.next;
                }else if(l2 == null){
                    curr = l1;
                    l1 = l1.next;
                }else{
                    if(l1.val < l2.val){
                        curr = l1;
                        l1 = l1.next;
                    }else{
                        curr = l2;
                        l2 = l2.next;
                    }
                }

                curr.next = null;

                if(pre == null){
                    result = curr;
                }else{
                    pre.next = curr;
                }

                pre = curr;
            }

            return result;


        }
    }
}
