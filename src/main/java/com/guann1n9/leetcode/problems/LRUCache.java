package com.guann1n9.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 )//缓存容量
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
*/
public class LRUCache {

    //LinkedHashMap


    /**
     * 双向链表  最近被访问的元素放在头部
     */
    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
    }

    /**
     * key 与Node的映射
     */
    private Map<Integer,Node> cache = new HashMap<>();
    //最大容量
    private int capacity;
    //当前计数
    private int size;
    //头尾节点
    private Node head,tail;



    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        //伪头部 伪尾部 方便使用
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        //将该节点移动至头部
        moveToHead(node);
        return node.value;
    }


    /**
     * 添加节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //判断当前key是否已存在
        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
            return;
        }
        //不存在
        Node newNode = new Node(key, value);
        cache.put(key,newNode);
        addToHead(newNode);
        //容量未到上限
        if(size < capacity){
            size++;
            return;
        }
        //达到上限 移除尾部节点
        Node last = tail.pre;
        removeNode(last);
        cache.remove(last.key);
    }

    /**
     * 将节点移动至头部
     * @param node
     */
    private void moveToHead(Node node) {
        //移除该节点
        removeNode(node);
        //添加到头部
        addToHead(node);
    }


    private void removeNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }


    private void addToHead(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
}
