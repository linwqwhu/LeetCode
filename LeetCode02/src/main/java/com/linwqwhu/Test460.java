package com.linwqwhu;

import java.lang.reflect.ParameterizedType;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 460.LRU缓存
 */
public class Test460 {
    class DLinkedNode {
        private int key;
        private int value;
        private int count;

        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    private PriorityQueue<DLinkedNode> queue;
    private Map<Integer, DLinkedNode> cache;
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    public Test460(int capacity) {
//    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        this.queue = new PriorityQueue<>(new Comparator<DLinkedNode>() {
            @Override
            public int compare(DLinkedNode o1, DLinkedNode o2) {
                return o1.count - o2.count;
            }
        });

        this.cache = new HashMap<>(capacity + 1);

        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;
        queue.remove(node);
        node.count++;
        queue.add(node);

        deleteNode(node);
        addToHead(node);

        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);

            //个数已满
            if (this.size >= this.capacity) {
                DLinkedNode lessUse = queue.poll();
                //存在多个相同最少使用次数的
                if (!queue.isEmpty() && lessUse.count == queue.peek().count) {
                    queue.add(lessUse);
                    lessUse = tail.prev;
                    queue.remove(lessUse);
                }
                deleteNode(lessUse);
            }
            queue.add(node);
            addToHead(node);
        } else {

            queue.remove(node);
            node.value = value;
            node.count++;
            queue.add(node);

            deleteNode(node);
            addToHead(node);
        }
    }

    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        cache.put(node.key, node);
        this.size++;
    }

    public void deleteNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(node.key);
        this.size--;
    }
}
