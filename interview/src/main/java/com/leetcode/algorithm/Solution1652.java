package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/23 15:42
 */
public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        if (code == null || code.length < 1) {
            return code;
        }

        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        }

        int i = 1, j = 0;
        boolean asc = k > 0;
        int kSum = 0;
        while (k != 0) {
            if (asc) {
                kSum += code[++j];
                k--;
            } else {
                --j;
                if (j < 0) {
                    j = code.length - 1;
                }
                k++;
                kSum += code[j];
            }
        }

        ans[0] = kSum;
        while (i < code.length) {
            if (!asc) {
                kSum -= code[j];
                kSum += code[i - 1 >= 0 ? i - 1 : code.length - 1];
            }

            j++;
            if (j == code.length) {
                j = 0;
            }

            if (asc) {
                kSum -= code[i];
                kSum += code[j];
            }

            ans[i] = kSum;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] ans = new Solution1652().decrypt(code, k);
        System.out.println(Arrays.toString(ans));
    }
}
