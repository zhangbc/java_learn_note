package com.patterns;

/**
 * 建造者模式-包装接口实现类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:03
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
