package com.leetcode.algorithm;

/**
 * 79. 单词搜索
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/13 20:59
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        int length = board.length, height = board[0].length;
        // 防止重复访问
        boolean[][] visited = new boolean[length][height];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        // 向左，向右，向下，向上
        int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        boolean result = false;
        for (int[] direction: directions) {
            int nextI = i + direction[0], nextJ = j + direction[1];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {
                if (!visited[nextI][nextJ]) {
                    boolean flag = backtrack(board, word, visited, nextI, nextJ, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
