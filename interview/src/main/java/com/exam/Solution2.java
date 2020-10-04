package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/11 21:06
 */
public class Solution2 {
    public int lineup (String peoples) {
        // write code here
        int total = peoples.length();
        int ng = 0;
        for (int i = 0; i < total; i++) {
            if (peoples.charAt(i) == 'G') {
                ng++;
            }
            else {
                break;
            }
        }
        int nb = 0;
        for (int i = 0; i < total; i++) {
            if (peoples.charAt(i) == 'B') {
                nb++;
            }
            else {
                break;
            }
        }
        return total - (nb + ng);
    }
}
