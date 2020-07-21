package com.patterns;

/**
 * 组合实体模式--创建使用组合实体的客户端类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:05
 */
public class CompositeClient {

    private CompositeEntity entity = new CompositeEntity();


    public void printData() {
        for (int i = 0; i < entity.getData().length; i++) {
            System.out.println("Data: " + entity.getData()[i]);
        }
    }

    public void setData(String dataOne, String dataTwo) {
        entity.setData(dataOne, dataTwo);
    }
}
