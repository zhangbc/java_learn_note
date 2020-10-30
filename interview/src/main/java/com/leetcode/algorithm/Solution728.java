package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 17:15
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>(16);
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isSelfDividingNumber(int number) {
        if (String.valueOf(number).indexOf('0') >= 0) {
            return false;
        }

        int count = number;
        while (count != 0) {
            if (number % (count % 10) != 0) {
                return false;
            }

            count /= 10;
        }

        return true;
    }

    private boolean isSelfDividingNumber2(int number) {
        String numbers = String.valueOf(number);
        if (numbers.indexOf('0') >= 0) {
            return false;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (number % (numbers.charAt(i) - '0') != 0) {
                return false;
            }
        }
        return true;
    }
}
