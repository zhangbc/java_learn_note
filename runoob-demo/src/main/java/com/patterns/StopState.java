package com.patterns;

/**
 * 状态模式-实现State接口的StopState实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:53
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state.");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
