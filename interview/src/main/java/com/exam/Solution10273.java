package com.exam;

/**
 * 人民币转大写
 * 原题：https://www.nowcoder.com/questionTerminal/00ffd656b9604d1998e966d555005a4b
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 20:09
 */
public class Solution10273 {

    private static final char[] DATA = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final char[] UNITS = {'分', '角', '整', '圆', '拾', '佰', '仟', '萬', '拾', '佰', '仟', '亿'};

    public String number2Money(int money) {

        StringBuilder sb = new StringBuilder();
        int unit = 3;
        while (money > 0) {
            int number = money % 10;
            if (number != 0) {
                sb.insert(0, UNITS[unit]);
            } else if (UNITS[unit] == '萬' || UNITS[unit] == '亿') {
                sb.insert(0, UNITS[unit]);
            }

            boolean flag = ((sb.charAt(0) == DATA[number] || sb.charAt(0) == '萬' || sb.charAt(0) == '亿') && number == 0);
            if (!flag) {
                sb.insert(0, DATA[number]);
            }

            money /= 10;
            unit++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution10273().number2Money(4000055));
    }
}
