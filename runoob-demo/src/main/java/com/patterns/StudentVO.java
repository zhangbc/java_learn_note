package com.patterns;

/**
 * 传输对象模式--创建传输对象(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:59
 */
public class StudentVO {

    private String name;
    private Integer sno;

    StudentVO(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }
}
