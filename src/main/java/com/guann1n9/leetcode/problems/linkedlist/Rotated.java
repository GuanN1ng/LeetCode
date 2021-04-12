package com.guann1n9.leetcode.problems.linkedlist;

/**
 *
 * 旋转链表
 *
 *
 * https://leetcode-cn.com/problems/rotate-list/
 *
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class Rotated {

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

    public ListNode rotateRight(ListNode head, int k) {
        //无需移动
        if(head == null || head.next == null || k == 0){
            return head;
        }
        //获取当前链表长度
        ListNode iter = head;
        int i = 1;
        while(iter.next != null){
            iter = iter.next;
            i++;
        }

        //每旋转i次，链表恢复，则新的头节点 为
        int rotate = i - k % i;
        if(rotate == i){
            return head;
        }
        //头尾相连
        iter.next = head;
        while(rotate-- > 0){
            iter = iter.next;
        }
        head = iter.next;
        //首尾断开
        iter.next = null;
        return head;
    }
}
