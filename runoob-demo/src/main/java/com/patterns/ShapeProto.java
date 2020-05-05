package com.patterns;

/**
 * 原型模式-创建一个实现Cloneable的抽象类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 13:39
 */
public abstract class ShapeProto implements Cloneable {

    private String id;
    protected String type;

    /**
     * 抽象方法定义
     */
    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
