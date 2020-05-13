package com.patterns;

/**
 * 模板模式-实现抽象final类的Cricket实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:59
 */
public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started, enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
