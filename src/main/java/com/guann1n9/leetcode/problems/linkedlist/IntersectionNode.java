package com.guann1n9.leetcode.problems.linkedlist;

import java.util.HashSet;

/**
 * 找出两个链表的相交节点
 */
public class IntersectionNode {


    class ListNode{
        ListNode pre;
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode pre, ListNode next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    /**
     * 特殊情形，两个链表相交后不分离，合并为一个链表
     *
     * 1->2->3——|                1->2->3
     *           8->9
     *    6->7——|                4->5
     *
     *
     *    head1  head2          head1    head2
     *    1       6             1        4
     *    2       7             2        5
     *    3       8             3        null
     *    8       9             null     1
     *    9       null          4        2
     *    null    1             5        3
     *    6       2             null     null
     *    7       3
     *    8       8
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        while(head1 != head2){
            head1 = head1==null ? headB : head1.next;
            head2 = head2==null ? headA : head2.next;
        }
        return head1;

    }

}
