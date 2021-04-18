package com.exam;

import java.util.HashSet;

/**
 * HashSet 应用实例
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/18 12:58
 */
public class HashSetDemo {

    public static void main(String[] args) {
        // 需求：姓名和年龄相同认为是同一个用户，不能重复添加
        HashSet<User> users = new HashSet<>(16);
        User user1 = new User("lisi", 24);
        User user2 = new User("zhangsan", 26);
        User user3 = new User("wangwu", 20);
        User user4 = new User("zhaoliu", 22);
        User user5 = new User("xiaoming", 29);
        User user6 = new User("wangwu", 20);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        System.out.println(users.size());
    }
}
