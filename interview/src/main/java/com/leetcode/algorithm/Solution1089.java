package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1089. 复写零
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 19:36
 */
public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        int[] ans = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length && index < arr.length; i++) {
            ans[index++] = arr[i];
            if (arr[i] == 0 && index < arr.length) {
                ans[index++] = 0;
            }
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    public void duplicateZeros2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        // 记录数组最后一个元素的位置
        int last = arr.length - 1;
        int zeroCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                last--;
                zeroCount++;
            }

            // 注意判断最后一个 0
            if (i == last || i + 1 == last) {
                zeroCount += (i + 1 == last && arr[last] == 0 ? 1 : 0);
                break;
            }
        }

        int index = arr.length - 1;
        // 判断最后一个0是否应该复写
        if (arr[last] == 0 && zeroCount > 0 && zeroCount == arr.length - 1 - last) {
            arr[index--] = 0;
        }

        while (index >= 0) {
            arr[index--] = arr[last--];
            if (last >= 0 && index >= 0 && arr[last] == 0) {
                arr[index--] = 0;
            }
        }
    }

    public static void main(String[] args) {

        /* 测试用例：
            [1,0,2,3,0,4,5,0]
            [1,2,3]
            [0,1]
            [1,0]
            [1,1,0]
            [8,4,5,0,0,0,0,7]
            [1,5,2,0,6,8,0,6,0]
        */
        int[] array = {8,4,5,0,0,0,0,7};
        Solution1089 so = new Solution1089();
        so.duplicateZeros2(array);
        System.out.println(Arrays.toString(array));
    }
}
