package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 15:38
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<>(16);
        if (root == null) {
            return array;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            array.add(node.val);
            if (node.right != null) {
                nodes.push(node.right);
            }

            if (node.left != null) {
                nodes.push(node.left);
            }
        }

        return array;
    }
}
