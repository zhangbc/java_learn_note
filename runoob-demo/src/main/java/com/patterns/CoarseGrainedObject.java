package com.patterns;

/**
 * 组合实体模式--创建粗粒度对象(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 00:56
 */
public class CoarseGrainedObject {

    DependentObjectOne one = new DependentObjectOne();
    DependentObjectTwo two = new DependentObjectTwo();

    public String[] getData() {
        return new String[] {one.getData(), two.getData()};
    }

    public void setData(String dataOne, String dataTwo) {
        one.setData(dataOne);
        two.setData(dataTwo);
    }
}
