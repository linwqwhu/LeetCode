package com.linwqwhu;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.LRU缓存
 */
public class Test146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public Test146(int capacity) {
//        public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, DLinkedNode>();
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            deleteNode(node);
        } else {
            node = new DLinkedNode(key, value);
        }
        addToHead(node);

        if (this.size > this.capacity) {
            deleteNode(tail.prev);
        }
    }

    public void deleteNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(node.key);
        this.size--;
    }

    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        cache.put(node.key, node);
        this.size++;
    }


    public static void main(String[] args) {
        Test146 lru = new Test146(2);
        lru.put(1, 1);
        lru.put(2, 2);
        int i = lru.get(1);
        System.out.println(i);
        lru.put(3, 3);
        int i1 = lru.get(2);
        System.out.println(i1);
    }
}
