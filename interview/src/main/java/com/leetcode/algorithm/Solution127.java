package com.leetcode.algorithm;

import java.util.*;

/**
 * 127. 单词接龙
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 18:56
 */
public class Solution127 {

    Map<String, Integer> wordsId = new HashMap<>(16);
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNumber = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || " ".equals(beginWord) || endWord == null || " ".equals(endWord)
                || beginWord.equals(endWord) || wordList == null || wordList.size() < 1) {
            return 0;
        }

        for (String word: wordList) {
            addEdge(word);
        }

        addEdge(beginWord);
        if (!wordsId.containsKey(endWord)) {
            return 0;
        }

        int[] dis = new int[nodeNumber];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordsId.get(beginWord), endId = wordsId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }

            for (int item: edge.get(x)) {
                if (dis[item] == Integer.MAX_VALUE) {
                    dis[item] = dis[x] + 1;
                    queue.offer(item);
                }
            }
        }

        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = wordsId.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);

            int id2 = wordsId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    private void addWord(String word) {
        if (!wordsId.containsKey(word)) {
            wordsId.put(word, nodeNumber++);
            edge.add(new ArrayList<>());
        }
    }
}
