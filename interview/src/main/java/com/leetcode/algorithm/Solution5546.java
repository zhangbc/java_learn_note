package com.leetcode.algorithm;

/**
 * 5546. 按键持续时间最长的键
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 10:39
 */
public class Solution5546 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char temp = ' ';
        if (releaseTimes == null || keysPressed == null
                || releaseTimes.length < 1 || keysPressed.length() < 1
                || releaseTimes.length != keysPressed.length()) {
            return temp;
        }

        int duration = releaseTimes[0];
        temp = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > duration) {
                duration = releaseTimes[i] - releaseTimes[i - 1];
                temp = keysPressed.charAt(i);
            }

            if (releaseTimes[i] - releaseTimes[i - 1] == duration) {
                if (keysPressed.charAt(i) > temp) {
                    temp = keysPressed.charAt(i);
                }
            }
        }

        return temp;
    }
}
