package com.runoob;

import java.util.*;

/**
 * 遍历演示
 * @author 张伯成
 * @date 2019/3/4
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Maven");
        list.add("Demo");

        // 遍历1：使用foreach遍历List
        System.out.println("使用foreach遍历List:");
        for (String str: list) {
            System.out.print(str + " ");
        }

        // 遍历2：把链表变为数组相关的内容进行遍历List
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        System.out.println("\n把链表变为数组相关的内容进行遍历List:");
        for (int i = 0; i < strArray.length; i++) {
            System.out.print(strArray[i] + " ");
        }

        // 遍历3：使用迭代器进行相关遍历List
        Iterator<String> iterator = list.iterator();
        System.out.println("\n使用迭代器进行相关遍历List:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}


/**
 * Map遍历实例
 */
class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // 遍历1：通过Map.KeySet遍历
        System.out.println("通过Map.KeySet遍历key与value：");
        for (String key: map.keySet()) {
            System.out.println("key=" + key + ", value=" + map.get(key));
        }

        // 遍历2：通过Map.entrySet使用iterator遍历
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        // 遍历3：推荐，通过Map.entrySet遍历
        System.out.println("通过Map.entrySet遍历key和value:");
        for (Map.Entry<String, String> entry:
             map.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        // 遍历4：通过Map.values()遍历
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key：");
        for (String val: map.values()) {
            System.out.println("value=" + val);
        }
    }
}


/**
 * 泛型方法实例
 */
class GenericMethod {
    public static void main(String[] args) {
        // 创建不同类型的数组：Integer，Double和Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', '0'};

        System.out.println("整型数组元素为：");
        printArray(intArray);
        System.out.println("双精度小数数组元素为：");
        printArray(doubleArray);
        System.out.println("字符型数组元素为：");
        printArray(charArray);
    }

    /**
     * 泛型方法printArray
     * @param inputArray
     * @param <E>
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}


/**
 * 泛型的有界类型参数实例
 */
class MaxGenericMethod {
    public static void main(String[] args) {
        System.out.printf("%d,%d和%d中最大的数为%d.\n\n",
                3, 4, 5, maximum(3, 4, 5));

        System.out.printf("%.2f,%.2f和%.2f中最大的数为%.2f.\n\n",
                6.6, 7.7, 8.8, maximum(6.6, 7.7, 8.8));

        System.out.printf("%s,%s和%s中最大的数为%s.\n\n",
                "pear", "apple", "orange",
                maximum("pear", "apple", "orange"));
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}


/**
 * 泛型类实例
 * @param <T>
 */
class Box<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();
        integerBox.add(10);
        stringBox.add("菜鸟教程");

        System.out.printf("整型值为：%d\n", integerBox.get());
        System.out.printf("字符串为：%s\n", stringBox.get());
    }
}


/**
 * 类型通配符实例
 */
class Wildcard {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getUpperNumber(age);
        getUpperNumber(number);
    }

    public static void getData(List<?> data) {
        System.out.printf("data: %s\n", data.get(0));
    }

    public static void getUpperNumber(List<? extends Number> data) {
        System.out.println("data: " + data.get(0));
    }
}