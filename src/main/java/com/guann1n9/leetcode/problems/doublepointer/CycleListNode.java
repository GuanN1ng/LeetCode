package com.guann1n9.leetcode.problems.doublepointer;

public class CycleListNode {


    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }



    public ListNode detectCycle(ListNode head) {
        ListNode quick = head,slow = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                break;
            }
        }
        if(quick == null || quick.next == null || quick != slow){
            return null;
        }
        slow = head;
        while(slow != quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;

    }
}
