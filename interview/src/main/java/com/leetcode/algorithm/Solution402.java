package com.leetcode.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/15 12:01
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < 1 || k < 1) {
            return num;
        }

        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        char digit;
        for (int i = 0; i < length; i++) {
            digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }

            deque.offerLast(digit);
        }

        while (k > 0) {
            deque.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean firstZero = true;
        while (!deque.isEmpty()) {
            digit = deque.pollFirst();
            if (firstZero && digit == '0') {
                continue;
            }

            firstZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "9432219";
        int k = 3;
        Solution402 cls = new Solution402();
        System.out.println(cls.removeKdigits(num, k));
    }
}
