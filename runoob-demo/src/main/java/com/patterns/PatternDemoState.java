package com.patterns;

/**
 * 状态模式-使用Context来查看当状态State改变时的行为变化(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:58
 */
public class PatternDemoState {
    public static void main(String[] args) {

        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
