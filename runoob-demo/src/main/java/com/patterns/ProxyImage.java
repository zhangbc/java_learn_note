package com.patterns;

/**
 * 代理模式-创建实现接口的ProxyImage实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 10:56
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
