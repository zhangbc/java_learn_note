package com.leetcode.algorithm;

/**
 * 1108. IP 地址无效化
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/14 17:43
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        if (address == null || address.length() < 1) {
            return address;
        }

        char dot = '.';
        int length = address.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            if (address.charAt(i) == dot) {
                sb.insert(0, "[.]");
            } else {
                sb.insert(0, address.charAt(i));
            }
        }

        return sb.toString();
    }
}
