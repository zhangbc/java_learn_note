package com.instance;

/**
 * Java异常处理
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:46
 */
public class ExceptionHanding {
    public static void main(String[] args) {
        System.out.println("Java异常处理！");
    }
}


/**
 * 异常处理方法：
 * 使用System类的System.err.println()来展示异常的处理方法.
 */
class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("Exception Demo!");
        } catch (Exception e) {
            System.err.println("Caught Exception.");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.err.println("toString(): " + e);
            System.err.println("printStackTrace(): ");
            e.printStackTrace();
        }
    }
}


/**
 * Throws关键字使用方法
 */
class ThrowsKey {
    /**
     * 除法运算：
     * 在功能上通过throws的关键字声明该功能可能出现问题
     * @param dividend
     * @param divisor
     * @return
     * @throws ArithmeticException
     * @throws ArrayIndexOutOfBoundsException
     */
    int division(int dividend, int divisor) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int[] array = new int[dividend];
        System.out.println(array[4]);
        return dividend / divisor;
    }
}


/**
 * 多个异常处理（多个catch）：
 * 对异常的处理：
 * 1）声明异常时，建议声明更为具体的异常，这样可以处理的更具体；
 * 2）对方声明几个异常，就对应几个catch块，如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面.
 */
class CatchKey {
    public static void main(String[] args) {
        ThrowsKey div = new ThrowsKey();
        try {
            int number1 = div.division(4, 0);
            int number2 = div.division(5, 1);
            System.out.println("number1=" + number1);
            System.out.println("number2=" + number2);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}


/**
 * Finally的用法：
 * Finally关键字一般与try一起使用，在程序进入try块之后，
 * 无论程序是因为异常而中止或其它方式返回终止的，finally块的内容一定会被执行.
 */
class FinallyKey {
    public static void main(String[] args) {
        new FinallyKey().work();
    }

    public void work() {
        Object obj = null;
        int length = 5;
        for (int i = 0; i < length; i++) {
            try {
                obj = makeObj(i);
            } catch (IllegalArgumentException e) {
                System.err.printf("Error: (%s).\n", e.getMessage());
                return;
            } finally {
                System.err.println("已执行完毕.");
                if (obj == null) {
                    System.exit(0);
                }
            }
            System.out.println(obj);
        }
    }

    public Object makeObj(int type) throws IllegalArgumentException {
        if (type == 1) {
            throw new IllegalArgumentException("不是指定的类型：" + type);
        }

        return new Object();
    }
}


/**
 * 使用catch处理异常
 */
class CatchProcess {
    public static void main(String[] args) {
        int[] array = {20, 20, 40};
        int num1 = 15, num2 = 20, result, size = 5;
        try {
            result = num1 / num2;
            System.out.printf("%d/%d=%d\n", num1, num2, result);
            for (int i = size; i >= 0; i--) {
                System.out.println("数组元素值为：" + array[i]);
            }
        } catch (Exception e) {
            System.out.println("触发异常：" + e);
        }
    }
}


/**
 * 多线程异常处理
 */
class ThreadProcess {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        td.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Caught it: " + e.toString());
        }
        System.out.println("exit.");
    }
}


/**
 * 线程实例
 */
class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Throwing in ThreadDemo.");
        throw new RuntimeException();
    }
}


/**
 * 获取异常的堆栈信息：
 * 使用异常类的printStack()方法来获取堆栈信息.
 */
class ExceptionStack {
    public static void main(String[] args) {
        int[] array = {20, 20, 40};
        int num1 = 15, num2 = 10, result, size = 5;
        try {
            result = num1 / num2;
            System.out.printf("%d/%d=%d\n", num1, num2, result);
            for (int i = size; i >= 0; i--) {
                System.out.println("The value of array is ：" + array[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * 重载方法异常处理
 */
class ExceptionOverride {
    public static void main(String[] args) {
        ExceptionOverride eo = new ExceptionOverride();
        try {
            System.out.println(method(10, 20.0));
            System.out.println(method(10.0, 20));
            System.out.println(method(10.0, 20.0));
            System.out.println(eo.method(10));
            System.out.println(eo.method(true));
        } catch (Exception e) {
            System.out.println("Exception occure: " + e);
        }
    }

    double method(int number) throws Exception {
        return number / 0;
    }

    boolean method(boolean bool) {
        return !bool;
    }

    static double method(int numberX, double numberY) throws Exception {
        return numberX + numberY;
    }

    static double method(double numberX, double numberY) {
        return numberX + numberY - 3;
    }
}


/**
 * 链式异常
 */
class ExceptionChain {
    public static void main(String[] args) throws Exception {
        int number = 20, result = 0;
        try {
            result = number / 0;
            System.out.printf("%d/0=%s.\n", number, result);
        } catch (ArithmeticException ea) {
            System.out.println("发算术异常：" + ea);

            try {
                throw new NumberFormatException();
            } catch (NumberFormatException en) {
                System.out.println("手动抛出链式异常：" + en);
            }
        }
    }
}


/**
 * 自定义异常：
 * 通过继承Exception来实现自定义异常.
 */
class WrongInputException extends Exception {
    WrongInputException(String str) {
        super(str);
    }
}


/**
 * Input类
 */
class Input {
    void method() throws WrongInputException {
        throw new WrongInputException("Wrong input.");
    }
}


/**
 * 测试自定义异常类的用例
 */
class TestInput {
    public static void main(String[] args) {
        try {
            new Input().method();
        } catch (WrongInputException wie) {
            System.out.println(wie.getMessage());
        }
    }
}