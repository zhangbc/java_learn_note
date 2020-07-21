package com.patterns;

/**
 * 组合实体模式--创建组合实体(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:01
 */
public class CompositeEntity {

    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public String[] getData() {
        return cgo.getData();
    }

    public void setData(String dataOne, String dataTwo) {
        cgo.setData(dataOne, dataTwo);
    }
}
