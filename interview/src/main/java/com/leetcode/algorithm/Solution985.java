package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 985. 查询后的偶数和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 21:03
 */
public class Solution985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (A == null || A.length < 1 || queries == null || queries.length < 1) {
            return new int[0];
        }

        // 查询之前的偶数和
        long sum = 0;
        for (int a: A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];
            if (index < A.length) {
                // 偶数 + 偶数 ==> 偶数变偶数做加法
                if (value % 2 == 0 && A[index] % 2 == 0) {
                    sum += value;
                }

                // 奇数 + 奇数 ==> 奇数变奇数做加法
                if (value % 2 != 0 && A[index] % 2 != 0) {
                    sum += A[index] + value;
                }

                // 奇数 + 偶数 ==> 偶数变奇数做减法
                if (value % 2 != 0 && A[index] % 2 == 0) {
                    sum -= A[index];
                }

                A[index] += value;
            }

            answer[i] = (int) sum;
        }

        return answer;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        if (A == null || A.length < 1 || queries == null || queries.length < 1) {
            return new int[0];
        }

        // 查询之前的偶数和
        long sum = 0;
        for (int a: A) {
            if (a % 2 == 0) {
                sum += a;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }

            A[index] += value;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }

            answer[i] = (int) sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] answer = new Solution985().sumEvenAfterQueries(A, queries);
        System.out.println(Arrays.toString(answer));
    }
}
