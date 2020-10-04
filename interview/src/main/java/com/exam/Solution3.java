package com.exam;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/11 21:09
 */
public class Solution3 {
    public ArrayList<ArrayList<Integer>> binaryTreeScan (int[] input) {
        // write code here
        if (input == null || input.length < 1) {
            return new ArrayList<>();
        }
        TreeNode root = generate(input);
        return null;
    }

    private TreeNode generate(int[] input) {
        int i = 0;
        TreeNode root = new TreeNode(input[i++]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (i < input.length && !queue.isEmpty()) {
            queue.poll();
            TreeNode node = new TreeNode(input[i++]);
            queue.offer(node);
        }
        return root;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    TreeNode(int value) {
        this.value = value;
    }
}