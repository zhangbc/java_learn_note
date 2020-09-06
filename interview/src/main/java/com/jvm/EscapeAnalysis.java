package com.jvm;

/**
 * 逃逸分析测试用例
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/1 16:13
 */
public class EscapeAnalysis {

    /**
     * 完全未优化
     */
    public int test(int x) {
        int xx = x + 2;
        Point p = new Point(xx, 42);
        return  p.getX();
    }

    /**
     * 优化1：将Point的构造函数和getX()方法进行内联优化
     */
//    public int test1(int x) {
//        int xx = x + 2;
//        // 在堆中分配P对象的示意方法
//         Point p = point_memory_alloc();
//         p.x = xx;
//         p.y = 42;
//         return  p.x;
//    }

    /**
     * 优化2：经过逃逸分析，发现在整个test()方法的范围内Point对象实例不会发生任何程度的逃逸，
     *       这样可以对它进行标量替换优化，把其内部的x和y直接置换出来，分解为test()方法内的局部变量，
     *       从而避免Point对象实例被实际创建
     */
    public int test2(int x) {
        int xx = x + 2;
         int px = xx;
         int py = 42;
         return  px;
    }

    /**
     * 优化3：通过数据流分析，发现py的值其实对方法不会造成任何影响，
     *       那就可以放心地去做无效 代码消除得到最终优化结果
     */
    public int test3(int x) {
        return  x + 2;
    }
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}