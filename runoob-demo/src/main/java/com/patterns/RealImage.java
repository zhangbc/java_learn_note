package com.patterns;

/**
 * 代理模式-创建实现接口的RealImage实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 10:51
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
