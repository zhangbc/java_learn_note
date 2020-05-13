package com.patterns;

/**
 * 模板模式-抽象final类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:54
 */
public abstract class Game {
    /**
     * 初始化游戏
     */
    abstract void initialize();

    /**
     * 开始游戏
     */
    abstract void startPlay();

    /**
     * 结束游戏
     */
    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
