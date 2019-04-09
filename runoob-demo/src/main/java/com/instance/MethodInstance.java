package com.instance;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Java方法实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:21
 */
public class MethodInstance {
    public static void main(String[] args) {
        System.out.println("Java方法实例!");
    }
}


/**
 * OverLoading类，供方法重载实例调用
 * 方法重载定义：如果有两个方法的方法名相同，但参数不一致，哪么可以说一个方法是另一个方法的重载。 具体说明如下：
 *      >> 方法名相同
 *      >> 方法的参数类型，参数个不一样
 *      >> 方法的返回类型可以不相同
 *      >> 方法的修饰符可以不相同
 *      >> main方法也可以被重载
 */
class OverLoading {
    int height;
    OverLoading() {
        System.out.println("无参数构造函数！");
        height = 4;
    }

    OverLoading(int number) {
        System.out.println("房子高度为：" + number + "米.");
        height = number;
    }

    void info() {
        System.out.println("房子高度为：" + height + "米.");
    }

    void info(String str) {
        System.out.println(str + ": 房子高度为：" + height + "米.");
    }
}


/**
 * 方法重载实例
 */
class MethodOverLoading {
    public static void main(String[] args) {
        OverLoading overLoading = new OverLoading(3);
        overLoading.info();
        overLoading.info("重载方法");
        new OverLoading();
    }
}


/**
 * 输出数组元素
 */
class ArrayItemOutput {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.00};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("输出整型数组：");
        printArray(integerArray);
        printArrays(integerArray);

        System.out.println("输出双精度型数组：");
        printArray(doubleArray);
        printArrays(doubleArray);

        System.out.println("输出字符型数组：");
        printArray(characterArray);
        printArrays(characterArray);
    }

    public static void printArray(Integer[] inputArray) {
        for (Integer element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void printArray(Double[] inputArray) {
        for (Double element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void printArray(Character[] inputArray) {
        for (Character element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <E> void printArrays(E[] inputArray) {
        for (E element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}


/**
 * 汉诺塔算法（又称河内塔），算法描述如下：
 *      1）有三根杆子A,B,C。A杆上有若干碟子
 *      2）每次移动一块碟子,小的只能叠在大的上面
 *      3）把所有碟子从A杆全部移到C杆上
 */
class HanoiAlgorithm {
    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔算法
     * @param topN
     * @param from
     * @param inter
     * @param to
     */
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN +" from " + from + " to " + to);
            doTowers(topN -1, inter, from, to);
        }
    }
}


/**
 * 斐波那契数列, 算法描述如下：
 *      第0项是0，第1项是第一个1，这个数列从第三项开始，每一项都等于前两项之和。
 */
class FibonacciAlgorithm {
    public static void main(String[] args) {
        int counter = 10;
        for (int i = 0; i <= counter; i++) {
            System.out.printf("Fibonacci term of %d is: %d\n",
                    i, fibonacci(i));
        }
    }

    /**
     * 斐波那契数列算法
     * @param number
     * @return
     */
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}


/**
 * 阶乘, 算法描述如下：
 *      一个正整数的阶乘（英语：factorial）是所有小于及等于该数的正整数的积，并且有0的阶乘为1。自然数n的阶乘写作n!。
 *      亦即n!=1×2×3×...×n。阶乘亦可以递归方式定义：0!=1，n!=(n-1)!×n。
 */
class  FactorialAlgorithm {
    public static void main(String[] args) {
        int counter = 10;
        for (int i = 0; i <= counter; i++) {
            System.out.printf("%d != %d\n", i, factorial(i));
        }
    }

    /**
     * 阶乘算法
     * @param number
     * @return
     */
    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}


/**
 * Figure类
 */
class Figure {
    double dim1;
    double dim2;
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    Double area() {
        System.out.println("Inside area for figure.");
        return (dim1 * dim2);
    }
}


/**
 * Rectangle类，继承Figure类
 */
class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    Double area() {
        System.out.println("Inside area for rectangle.");
        return (dim1 * dim2);
    }
}


/**
 * 方法覆盖实例
 */
class MethodOverriding {
    public static void main(String[] args) {
        Figure figure = new Figure(10, 20);
        Rectangle rectangle = new Rectangle(9, 5);
        Figure figure1;
        figure1 = figure;
        System.out.println("Figure area is: " + figure1.area());

        figure1 = rectangle;
        System.out.println("Rectangle area is: " + figure1.area());
    }
}


/**
 * instanceof关键字用法：
 * 测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。
 */
class InstanceOfKey {
    public static void main(String[] args) {
        Object obj = new ArrayList();
        displayObjectClass(obj);

        obj = new StringBuilder();
        displayObjectClass(obj);

        obj = new MethodOverLoading();
        displayObjectClass(obj);
    }

    public static void displayObjectClass(Object obj) {
        if (obj instanceof Vector) {
            System.out.println("对象是java.util.Vector类的实例.");
        } else if (obj instanceof ArrayList) {
            System.out.println("对象是java.util.ArrayList类的实例.");
        } else {
            System.out.println("对象是" + obj.getClass() + "类的实例.");
        }
    }
}


/**
 * break关键字用法：
 * 直接强行退出当前的循环，忽略循环体中任何其他语句和循环条件测试。
 */
class BreakKey {
    public static void main(String[] args) {
        int[] intArray = {99, 12, 22, 34, 45,  67, 5678, 8990};
        int number = 5678;
        int i = 0;
        boolean found = false;
        for (; i < intArray.length; i++) {
            if (intArray[i] == number) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(number + "元素的索引位置在：" + i);
        } else {
            System.out.println(number + "元素不在数组中.");
        }
    }
}


/**
 * Continue关键字的用法：
 * 结束当前循环，并进入下一次循环，即仅仅这一次循环结束，不是所有循环结束，后边的循环依旧进行。
 */
class ContinueKey {
    public static void main(String[] args) {
        StringBuilder searchStr = new StringBuilder("Hello! How are you?");
        int length = searchStr.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (searchStr.charAt(i) != 'H') {
                continue;
            }
            count++;
        }


        System.out.println(searchStr);
        System.out.println("发现" + count + "个H字符.");
    }
}


/**
 * Label标签：
 * Java中的标签是为循环设计的，是为了在多重循环中方便的使用break和continue。
 */
class Label {
    public static void main(String[] args) {
        String searchStr = "This is the substring in which you have to search for a substring.";
        String substring = "substring";
        boolean found = false;
        int max = searchStr.length() - substring.length();

        label:
        for (int i = 0; i < max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if (searchStr.charAt(j++) != substring.charAt(k++)) {
                    continue label;
                }
            }
            found = true;
            break label;
        }

        if (found) {
            System.out.println("发现子字符串。");
        } else {
            System.out.println("字符串中没有发现子字符串。");
        }
    }
}


/**
 * enum: Car枚举类型
 */
enum Car {
    // LAMBORGHINI
    LAMBORGHINI,
    // TATA
    TATA,
    // AUDI
    AUDI,
    // FIAT
    FIAT,
    // HONDA
    HONDA
}


/**
 * enum和switch语句使用
 */
class SwitchKey {
    public static void main(String[] args) {
        Car car;
        car = Car.HONDA;
        switch (car) {
            case LAMBORGHINI:
                System.out.println("您选择了LAMBORGHINI!");
                break;
            case TATA:
                System.out.println("您选择了TATA!");
                break;
            case AUDI:
                System.out.println("您选择了AUDI!");
                break;
            case FIAT:
                System.out.println("您选择了FIAT!");
                break;
            case HONDA:
                System.out.println("您选择了HONDA!");
                break;
            default:
                System.out.println("我不知道您的车型!");
                break;
        }
    }
}


/**
 * Enum（枚举）构造函数及方法
 */
enum EnumCar {
    // LAMBORGHINI
    LAMBORGHINI(9000),
    // TATA
    TATA(200),
    // AUDI
    AUDI(500),
    // FIAT
    FIAT(150),
    // HONDA
    HONDA(1200);

    private int price;
    EnumCar(int p) {
        price = p;
    }

    int getPrice() {
        return price;
    }
}


/**
 * Enum（枚举）构造函数及方法的使用
 */
class MethodEnum {
    public static void main(String[] args) {
        System.out.println("所有汽车的价格(单位：千美元)：");
        for (EnumCar ec: EnumCar.values()) {
            System.out.println(ec + " 需要 " + ec.getPrice() + " 千美元.");
        }
    }
}


/**
 * for与foreach循环使用：
 * for 语句比较简单，用于循环数据；for循环执行的次数是在执行前就确定的；
 * foreach语句是java5的新特征之一。
 */
class MethodForForeach {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4};
        forDisplay(intArray);
        foreachDisplay(intArray);
    }

    public static void forDisplay(int[] array) {
        System.out.println("使用for循环数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void foreachDisplay(int[] array) {
        System.out.println("使用foreach循环数组：");
        for (int item: array) {
            System.out.print(item + " ");
        }
    }
}


/**
 * Varargs可变参数使用：
 * Java1.5提供了一个叫varargs的新功能，就是可变长度的参数。
 * 定义实参个数可变的方法：只要在一个形参的"类型"与"参数名"之间加上三个连续的"."（即"..."，英文里的句中省略号），
 * 就可以让它和不确定个实参相匹配。
 */
class VarargsKey {
    public static void main(String[] args) {
        int sum;
        int[] varArgs = new int[]{10, 12, 33, 45};
        sum = sumVarargs(varArgs);
        System.out.println("数字相加之和为：" + sum);
    }

    private static int sumVarargs(int... intArrays) {
        int sum = 0;
        for (int i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return sum;
    }
}


/**
 * 重载(overloading)方法中使用Varargs
 */
class OverLoadingVarargs {
    public static void main(String[] args) {
        varArgs(1, 2, 3);
        varArgs("测试：", 10, 20);
        varArgs(true, false, true);
    }

    private static void varArgs(int... numbers) {
        System.out.print("varArgs(int... numbers)参数个数：" + numbers.length + ", 内容为：");
        for (int item: numbers) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void varArgs(boolean... booleans) {
        System.out.print("varArgs(boolean... numbers)参数个数：" + booleans.length + ", 内容为：");
        for (boolean item: booleans) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void varArgs(String msg, int... numbers) {
        System.out.print("varArgs(String msg, int... numbers)" + msg + "参数个数："
                + numbers.length + ", 内容为：");
        for (int item: numbers) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}