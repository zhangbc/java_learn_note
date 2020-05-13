package com.patterns;

import java.util.Date;

/**
 * 中介者模式-中介类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:35
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.printf("%s [ %s ] : %s\n",
                new Date().toString(), user.getName(), message);
    }
}
