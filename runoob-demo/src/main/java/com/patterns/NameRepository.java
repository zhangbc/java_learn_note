package com.patterns;

/**
 * 迭代器模式-创建实现接口的Container实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 13:02
 */
public class NameRepository implements Container {

    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return this.hasNext() ? names[index++] : null;
        }
    }
}
