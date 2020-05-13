package com.patterns;

/**
 * 模板模式-使用Game的模板方法play来演示游戏(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:04
 */
public class PatternDemoTemplate {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();

        game = new Football();
        game.play();
    }
}
