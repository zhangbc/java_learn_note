package com.leetcode.algorithm;

/**
 * 1185. 一周中的第几天
 *
 * 蔡勒公式：{\displaystyle w=\left(y+\left[{\frac {y}{4}}\right]+\left[{\frac {c}{4}}\right]-2c+\left[{\frac {26(m+1)}{10}}\right]+d-1\right){\bmod {7}}}
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/11 17:01
 */
public class Solution1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        if (year < 1971 || year > 2100 || day < 1 || day > 31 || month < 1 || month > 12) {
            return null;
        }

        if (month < 3) {
            year--;
            month = month + 12;
        }

        int w = (year % 100 + (year % 100) / 4 + year / 100 / 4 - 2 * (year / 100) + 26 * (month + 1) / 10 + day - 1) % 7;
        w = w < 0 ? w + 7 : w;
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[w];
    }

    public static void main(String[] args) {
        Solution1185 cls = new Solution1185();
        System.out.println(cls.dayOfTheWeek(20, 11, 2020));
        System.out.println(cls.dayOfTheWeek(31, 8, 2019));
        System.out.println(cls.dayOfTheWeek(4, 4, 2006));
    }
}
