package com.patterns;

/**
 * 前端控制器模式--创建调度器(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 08:44
 */
public class Dispatcher {

    private HomeView homeView;
    private PersonView personView;

    public Dispatcher() {
        homeView = new HomeView();
        personView = new PersonView();
    }

    public void dispatch(String request) {
        String person = "person";
        if (request.equalsIgnoreCase(person)) {
            personView.show();
        } else {
            homeView.show();
        }
    }
}
