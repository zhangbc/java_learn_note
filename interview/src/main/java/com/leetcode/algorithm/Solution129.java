package com.leetcode.algorithm;

/**
 * 129. 求根到叶子节点数字之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/29 11:12
 */
public class Solution129 {

    int res = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int value) {
        if (root == null) {
            return;
        }

        int temp = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += temp;
        } else {
            if (root.left != null) {
                dfs(root.left, temp);
            }

            if (root.right != null) {
                dfs(root.right, temp);
            }
        }
    }
}
