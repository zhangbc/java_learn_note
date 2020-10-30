package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 112. 路径总和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 20:06
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<Map<TreeNode,Integer>> stack = new Stack<>();
        Map<TreeNode,Integer> map = new HashMap<>(16);
        map.put(root, root.val);
        stack.push(map);
        while (!stack.isEmpty()) {
            map = stack.pop();
            TreeNode node = (TreeNode) map.keySet().toArray()[0];
            int temp = map.get(node);
            if (node.left == null && node.right == null && temp == sum) {
                return true;
            }

            if (node.right != null) {
                Map<TreeNode,Integer> rMap = new HashMap<>(16);
                rMap.put(node.right, temp + node.right.val);
                stack.push(rMap);
            }

            if (node.left != null) {
                Map<TreeNode,Integer> lMap = new HashMap<>(16);
                lMap.put(node.left, temp + node.left.val);
                stack.push(lMap);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution112().hasPathSum(root, 22));
    }
}
