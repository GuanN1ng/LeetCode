package com.guann1n9.leetcode.problems.linkedlist;

public class reverseKGroup {


    class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode right = dummy;
        ListNode left = dummy;
        while(right.next != null){
            for(int i=0;i<k && right != null;i++){
                right = right.next;
            }
            if(right == null){
                break;
            }
            ListNode nextStart =  right.next;
            ListNode temp = left.next;

            right.next = null;
            reverse(left.next);
            left.next = right;
            temp.next = nextStart;
            left = right = temp;

        }
        return dummy.next;
    }





    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
