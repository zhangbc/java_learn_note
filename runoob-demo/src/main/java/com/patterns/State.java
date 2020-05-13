package com.patterns;

/**
 * 状态模式-State接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:50
 */
public interface State {
    /**
     * 动作方法
     * @param context Context对象
     */
    void doAction(Context context);
}
