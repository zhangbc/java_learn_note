package com.instance;

import java.util.*;

/**
 * Java数组实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/13 23:53
 */
public class ArrayListInstance {
    public static void main(String[] args) {
        System.out.println("Java数组实例！");
    }
}


/**
 * 数组排序及元素查找：
 * 通过sort()方法对Java数组进行排序，binarySearch()方法来查找数组中的元素。
 */
class ArraySortSearch {
    public static void main(String[] args) {
        int[] array = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        printArray("数组排除结果为", array);

        int index = Arrays.binarySearch(array, 2);
        System.out.println("数组array中，元素2在第 " + (index+1) + "个位置.");
    }

    public static void printArray(String message, int[] array) {
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}


/**
 * 数组添加元素：
 * 通过sort()方法对Java数组进行排序，insertElement()方法向数组插入元素。
 */
class ArraySortInsert {
    public static void main(String[] args) {
        int[] array = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        printArray("数组排除结果为", array);

        int index = Arrays.binarySearch(array, 1);
        System.out.println("数组array中，元素1所在位置(负数为不存在)：" + index);

        int newIndex = -index-1;
        array = insertElement(array, 1, newIndex);
        printArray("数组添加元素1", array);
    }

    public static void printArray(String message, int[] array) {
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static int[] insertElement(int[] original, int element, int index) {
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);

        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
}


/**
 * 获取数组长度：
 * 通过数组的属性length来获取数组的长度。
 */
class ArrayLength {
    public static void main(String[] args) {
        String[][] data = new String[2][5];
        System.out.println("第一维数组长度为：" + data.length);
        System.out.println("第二维数组长度为：" + data[0].length);
    }
}


/**
 * 数组反转：
 * 通过Collections.reverse(ArrayList)将数组进行反转。
 */
class ArrayReverse {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序：" + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后排序：" + arrayList);
    }
}


/**
 * 数组输出
 */
class ArrayOutput {
    public static void main(String[] args) {
        String[] runoobs = new String[3];
        runoobs[0] = "菜鸟教程";
        runoobs[1] = "菜鸟工具";
        runoobs[2] = "菜鸟笔记";
        for (int i = 0; i < runoobs.length; i++) {
            System.out.println(runoobs[i]);
        }
    }
}


/**
 * 数组获取最大值和最小值：
 * 通过Collections类的Collections.max()和 Collections.min()方法来查找数组中的最大和最小值。
 */
class ArrayMaxMin {
    public static void main(String[] args) {
        Integer[] numbers = {8, 2, 7, 1, 4, 9, 5};
        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));
        System.out.println("数组中元素的最大值为：" + max + "，最小值为：" + min);
    }
}


/**
 * 数组合并：
 * 通过List类的Arrays.toString()方法
 * 和List类的list.addAll(array1.asList(array2)方法将两个数组合并为一个数组。
 */
class ArrayMerge {
    public static void main(String[] args) {
        String[] arrA = {"A", "E", "I"};
        String[] arrB = {"O", "U"};
        List list = new ArrayList(Arrays.asList(arrA));
        list.addAll(Arrays.asList(arrB));
        Object[] obj = list.toArray();
        System.out.println("合并后，新数组为：" + Arrays.toString(obj));
    }
}


/**
 * 数组填充：
 * 通过Java Util类的Arrays.fill(array name,value)方法
 * 和Arrays.fill(array name ,starting index ,ending index ,value)方法向数组中填充元素。
 */
class ArrayFill {
    public static void main(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array, 100);
        for (int i = 0, n = array.length; i < n; i++) {
            if (i == n - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println();

        Arrays.fill(array, 3, 6, 50);
        for (int i = 0, n=array.length; i < n; i++) {
            if (i == n - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}


/**
 * 数组扩容
 */
class ArrayDilatation {
    public static void main(String[] args) {
        String[] names = new String[] {"A", "B", "C"};
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str: extended) {
            System.out.print(str + " ");
        }
    }
}


/**
 * 查找数组中的重复元素
 */
class ArrayFindDuplication {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 5, 6, 6, 7, 2, 9, 2};
        findDuplicateInArray(array);
    }

    public static void findDuplicateInArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("重复元素：" + array[i]);
            }
            count = 0;
        }
    }
}


/**
 * 删除数组元素：
 * 通过ArrayList类的remove()方法来删除数组元素。
 */
class ArrayDeleteItem {
    public static void main(String[] args) {
        ArrayList<String> objArray = new ArrayList<String>();
        objArray.clear();
        objArray.add(0, "第1个元素");
        objArray.add(1, "第2个元素");
        objArray.add(2, "第3个元素");
        System.out.println("数组删除元素前：" + objArray);
        objArray.remove(1);
        objArray.remove("第1个元素");
        System.out.println("数组删除元素后：" + objArray);
    }
}


/**
 * 数组差集：
 * 通过ArrayList类的removeAll()方法来计算两个数组的差集。
 */
class ArrayDifferenceSet {
    public static void main(String[] args) {
        ArrayList objArray1 = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "not common1");
        objArray2.add(3, "not common2");
        objArray1.add(0, "common1");
        objArray1.add(1, "common2");
        objArray1.add(2, "not common3");
        System.out.println("objArray1的元素是：" + objArray1);
        System.out.println("objArray2的元素是：" + objArray2);
        objArray1.removeAll(objArray2);
        System.out.println("objArray1与objArray2数组的差集是：" + objArray1);
    }
}


/**
 * 数组交集：
 * 通过ArrayList类的retainAll()方法来计算两个数组的差集。
 */
class ArrayIntersectionSet {
    public static void main(String[] args) {
        ArrayList objArray1 = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "not common1");
        objArray2.add(3, "not common2");
        objArray1.add(0, "common1");
        objArray1.add(1, "common2");
        objArray1.add(2, "not common3");
        System.out.println("objArray1的元素是：" + objArray1);
        System.out.println("objArray2的元素是：" + objArray2);
        objArray1.retainAll(objArray2);
        System.out.println("objArray1与objArray2数组的交集是：" + objArray1);
    }
}


/**
 * 在数组中查找指定元素：
 * 通过ArrayList类的contains()方法来查找数组中的指定元素。
 */
class ArrayContainsItem {
    public static void main(String[] args) {
        ArrayList objArray1 = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "not common1");
        objArray2.add(3, "not common2");
        objArray1.add(0, "common1");
        objArray1.add(1, "common2");
        System.out.println("objArray1的元素是：" + objArray1);
        System.out.println("objArray2的元素是：" + objArray2);
        System.out.println("objArray1是否包含类字符串common2？：" + objArray1.contains("common2"));
        System.out.println("objArray2是否包含数组objArray1？：" + objArray2.contains(objArray1));
    }
}


/**
 * 判断数组是否相等：
 * 通过equals ()方法来判断数组是否相等。
 */
class ArrayEquals {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {1, 2, 3, 4};
        System.out.println("数组array1是否与数组array2相等？：" + Arrays.equals(array1, array2));
        System.out.println("数组array1是否与数组array3相等？：" + Arrays.equals(array1, array3));
    }
}


/**
 * 数组并集：
 * 通过union()方法来计算两个数组的并集。
 */
class ArrayUnionSet {
    public static void main(String[] args) {
        String[] arr1 = {"1", "2", "3", "4"};
        String[] arr2 = {"4", "5", "6"};
        String[] resultUnion = union(arr1, arr2);

        System.out.println("数组arr1和arr2的并集结果如下：");
        for (String str: resultUnion) {
            System.out.print(str + " ");
        }
    }

    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<String>();
        for (String str: arr1) {
            set.add(str);
        }

        for (String str: arr2) {
            set.add(str);
        }

        String[] result = {};
        return set.toArray(result);
    }
}