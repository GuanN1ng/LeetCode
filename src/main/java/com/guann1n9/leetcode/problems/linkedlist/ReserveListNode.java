package com.guann1n9.leetcode.problems.linkedlist;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReserveListNode {


    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


    /**
     *
     * 假设后k个元素已反转
     *
     * 1->2->3->4->5
     *
     * 1->2->3<-4<-5
     *
     * 2.next.next = 2
     * 2.next = null;
     *
     * 1->2<-3<-4<-5
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }




}
