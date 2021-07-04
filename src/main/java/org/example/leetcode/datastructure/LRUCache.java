package org.example.leetcode.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存，不适用jdk自带的数据结构
 *
 * @author lichuan
 */
public class LRUCache {
    /**
     * 定义双向链表
     */
    static class Node {
        int key, val;
        Node pre, next;

        public Node(){}

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }



    private Map<Integer, Node> cache;
    private int size;
    private int capacity;
    /**
     * 使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在
     */
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 对应牛客网上
     */
    public int[] LRU (int[][] operators, int k) {

        this.size = 0;
        this.capacity = k;
        this.cache = new HashMap<>(k);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;

        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for(int i = 0, j = 0; i < operators.length; i++) {
            if(operators[i][0] == 1) {
                put(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (null == node) {
            return -1;
        }

        //如果key存在，则先移动到头部
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        //节点不存在
        if (null == node) {
            //创建一个新节点
            node = new Node(key, val);
            //添加进hash表
            cache.put(key, node);
            //移动到链表头部
            addToHead(node);
            //将节点个数加1
            ++size;

            //超出容量
            if (size > capacity) {
                //移除尾节点
                Node temp = removeTail();
                //删除hash表中对应的项
                cache.remove(temp.key);
                //将节点个数减一
                --size;
            }
        } else {
            //修改值
            node.val = val;
            //将节点移动到链表头部
            moveToHead(node);
        }
    }


    /**
     * 将节点移动到头部
     *
     */
    private void moveToHead(Node node) {
        //第一步，断开当前节点的链接
        removeNode(node);
        //第二部，将当前节点移动到头部
        addToHead(node);
    }

    /**
     * 移除当前节点
     */
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 将新节点添加到链表头部
     */
    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 移除尾节点
     */
    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

}
