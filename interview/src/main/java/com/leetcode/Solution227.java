package com.leetcode;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/21 21:56
 */
public class Solution227 {

    private int i = 0;

    public int calculate(String s) {
        // 操作数
        Stack<Integer> ops = new Stack<>();
        // 操作符
        Stack<Character> opts = new Stack<>();
        char opt;
        int op, op1, op2;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                opt = s.charAt(i);
                op1 = ops.pop();
                i++;
                op2 = getNext(s);
                if (opt == '*') {
                    ops.push(op1 * op2);
                } else {
                    ops.push(op1 / op2);
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                opts.push(s.charAt(i));
                i++;
            } else {
                op = getNext(s);
                if (!opts.isEmpty()) {
                    opt = opts.peek();
                    if (opt == '-') {
                        op = (-1) * op;
                        opts.pop();
                        opts.push('+');
                    }
                }
                ops.push(op);
            }
        }

        while (!opts.isEmpty()) {
            opts.pop();
            op2 = ops.pop();
            op1 = ops.pop();
            ops.push(op1 + op2);
        }

        return ops.pop();
    }

    private int getNext(String s) {
        int op = 0;
        char blank = ' ';
        while (i < s.length() && (s.charAt(i) == blank || Character.isDigit(s.charAt(i)))) {
            if (s.charAt(i) == blank) {
                i++;
                continue;
            }

            op = op * 10 + Character.getNumericValue(s.charAt(i));
            i++;
        }

        return op;
    }

    public static void main(String[] args) {
        String str = "0-2147483647";
        System.out.println(new Solution227().calculate(str));
    }
}
