package com.instance;

/**
 * 打印图形
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:31
 */
public class GraphPrint {
    public static void main(String[] args) {
        System.out.println("Java打印图形实例！");
    }
}


/**
 * 打印菱形：输出指定行数的菱形.
 */
class DiamondPrinting {
    public static void main(String[] args) {
        printGraph(8);
    }

    public static void printGraph(int size) {
        int length = 2;
        if (size % length == 0) {
            size ++;
        }

        for (int i = 0; i < size / length + 1; i++) {
            // 输出左上角位置的空白
            for (int j = size / length + 1; j > i + 1; j--) {
                System.out.print(" ");
            }
            // 输出菱形上半部边缘
            for (int j = 0; j < length * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = size / length + 1; i < size; i++) {
            // 输出左下角位置的空白
            for (int j = 0; j < i - size / length; j++) {
                System.out.print(" ");
            }
            // 输出菱形下半部边缘
            for (int j = 0; j < size * length - length * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


/**
 * 九九乘法表
 */
class MultiplicationTablePrinting {
    public static void main(String[] args) {
        int row = 9;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%dx%d=%d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}


/**
 * 打印三角形：输出指定行数的三角形.
 */
class TrianglePrinting {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = row; i <= j ; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


/**
 * 打印倒立三角形：输出指定行数的倒立三角形.
 */
class HandstandTrianglePrinting {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = row; j >= i; j--) {
                System.out.print("*");
            }
            for (int j = row; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


/**
 * 打印平行四边形
 */
class ParallelogramPrinting {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i < row; i++) {
            // 填充空格
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            // 内层循环，每次打印一个*
            for (int k = 1; k <= row; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


/**
 * 打印矩形
 */
class RectanglePrinting {
    public static void main(String[] args) {
        int row = 5;
        // 外层循环，每次输出一行*
        for (int i = 1; i <= row; i++) {
            System.out.print("*");
            // 内层循环，每次输出一个*
            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}