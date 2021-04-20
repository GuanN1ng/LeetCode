package com.guann1n9.leetcode.problems.linkedlist;

public class MyLinkedList {


    class LinkedNode{
        LinkedNode pre;
        LinkedNode next;
        int val;

        public LinkedNode(int val){
            this.val = val;
        }

        public LinkedNode(int val,LinkedNode pre,LinkedNode next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    private LinkedNode head;

    private LinkedNode tail;

    private int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index <0 || index >= count){
            return -1;
        }
        LinkedNode temp = node(index);
        return temp.val;
    }


    public LinkedNode node(int index){
        LinkedNode temp;
        if(index < (count >> 1)){
            temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i=count-1;i>index;i--){
                temp = temp.pre;
            }
        }
        return temp;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedNode curr =  new LinkedNode(val);
        if(head == null){
            head = tail = curr;
        }else{
            curr.next = head;
            head.pre = curr;
            head = curr;
        }
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkedNode curr =  new LinkedNode(val);
        if(tail == null){
            head = tail = curr;
        }else{
            curr.pre = tail;
            tail.next = curr;
            tail = curr;
        }
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <0 || index > count){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == count){
            addAtTail(val);
            return;
        }
        LinkedNode temp =  node(index);
        LinkedNode add =  new LinkedNode(val,temp.pre,temp);
        temp.pre.next = add;
        temp.pre = add;
        count++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index <0 || index >= count){
            return;
        }

        LinkedNode temp = node(index);
        LinkedNode pre = temp.pre;
        LinkedNode next = temp.next;

        if(pre == null){
            head = next;
        }else{
            pre.next = next;
            temp.pre = null;
        }
        if(next == null){
            tail = pre;
        }else{
            next.pre = pre;
            temp.next = null;
        }
        count--;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }

}

