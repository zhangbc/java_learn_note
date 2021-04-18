package com.leetcode.algorithm;

/**
 * LinkNode 基本结构
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/15 22:07
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
