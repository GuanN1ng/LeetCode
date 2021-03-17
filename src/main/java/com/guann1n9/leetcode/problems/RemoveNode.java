package com.guann1n9.leetcode.problems;

import java.util.HashMap;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNode {


    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    //删除倒数第 n 个结点，并且返回链表的头结点
    public Node removeNthFromEnd(Node head, int n) {
        if (head.next == null) {
            return null;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        int count = 1;
        map.put(count, head);
        while (head.next != null) {
            count++;
            head = head.next;
            map.put(count, head);
        }
        if (n == 1) {
            map.get(count - 1).next = null;
            return map.get(1);
        }
        //删除倒一
        if (n == count) {
            return map.get(2);
        }
        Node node = map.get(count - n + 1);
        Node pre = map.get(count - n);
        pre.next = node.next;
        return map.get(1);
    }


    /**
     * 快慢双指针
     *
     * @param head
     * @param n
     * @return
     */
    public Node removeNthFromEnd2(Node head, int n) {
        //构造虚拟节点 1 保存头节点的引用 2处理只有一个元素的情况
        Node dummy = new Node(0, head);
        Node fast = head, slow = dummy;
        //fast前进n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //同时前进，直至fast至队尾
        while (fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        //slow指向下一个节点的位置即为倒数第n
        slow.next = slow.next.next;
        return dummy.next;
    }


}
