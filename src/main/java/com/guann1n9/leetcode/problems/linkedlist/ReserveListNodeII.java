package com.guann1n9.leetcode.problems.linkedlist;

/**
 * 反转链表2
 *
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class ReserveListNodeII {

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


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        //从头开始反转
        ListNode dummy = new ListNode(0,head);

        //找到左边界
        ListNode pre = dummy;
        for(int i=1;i<left;i++){
            pre = pre.next;
        }
        ListNode rightNode = pre;
        //反转尾
        for(int i=0;i<= right-left;i++){
            rightNode = rightNode.next;
        }

        //反转节点
        ListNode leftNode =  pre.next;
        ListNode end = rightNode.next;
        pre.next = null; rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = end;
        return dummy.next;
    }



    public void reverse(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        reverse(head.next);
        head.next.next = head;
        head.next = null;
    }


    /**
     * 头插法
     *
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode curr;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        curr =pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            //头插法 注意指针操作顺序
            curr.next =temp.next;
            temp.next = pre.next; // curr指针在变化
            pre.next = temp;
        }
        return dummy.next;


    }
}
