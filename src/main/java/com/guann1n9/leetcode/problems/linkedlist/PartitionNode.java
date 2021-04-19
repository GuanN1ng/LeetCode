package com.guann1n9.leetcode.problems.linkedlist;

/**
 *
 * 分隔节点
 *
 *给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class PartitionNode {



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

    /**
     * 找到第一个大于等于x的节点，然后把比x节点后的小于x的节点插入到第一个大于等于x节点之前
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null; //断开之前的连接。防止循环
        small.next = bigHead.next;
        return smallHead.next;
    }

}
