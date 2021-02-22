package com.guann1n9.leetcode.algorithm;

/**
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TwoAdd {

    /**
     * 逆序存储 同位置直接相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        //进位标志
        int carry = 0;
        while (l1!=null || l2!=null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int i = v1 + v2 + carry;
            if(head == null){
                head = tail = new ListNode(i%10);
            }else {
                tail.next = new ListNode(i%10);
                tail = tail.next;
            }
            carry = i/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

}


/**
 * 链表结构
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}