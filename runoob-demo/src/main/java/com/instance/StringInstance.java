package com.instance;

import java.util.Locale;
import java.util.StringTokenizer;


/**
 * 字符串实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/13 23:43
 */
public class StringInstance {
    public static void main(String[] args) {
        System.out.println("Java字符串实例!");
    }
}


/**
 * 字符串比较：
 * 通过字符串函数 compareTo (string) ，compareToIgnoreCase(String) 及 compareTo(object string)
 * 来比较两个字符串，并返回字符串中第一个字母ASCII的差值。
 */
class StringCompareEmp {
    public static void main(String[] args) {
        String str = "Hello World.";
        String aStr = "hello world.";
        Object objStr = str;
        System.out.println(str.compareTo(aStr));
        // 忽略大小写
        System.out.println(str.compareToIgnoreCase(aStr));
        System.out.println(str.compareTo(objStr.toString()));
    }
}


/**
 * 查找字符串最后一次出现的位置：
 * 通过字符串函数strOrig.lastIndexOf(StringName)来查找子字符串StringName在strOrig出现的位置。
 */
class SearchLastString {
    public static void main(String[] args) {
        String strOrig = "Runoob, Hello World, Hello Runoob.";
        int lastIndex = strOrig.lastIndexOf("Runoob");
        if (lastIndex == -1) {
            System.out.println("没有找到字符串Runoob");
        } else {
            System.out.println("Runoob字符串最后出现的位置：" + lastIndex);
        }
    }
}


/**
 * 删除字符串的一个字符：
 * 通过字符串函数 substring() 函数来删除字符串中的一个字符。
 */
class DeleteCharOfString {
    public static void main(String[] args) {
        String str = "This is Javac.";
        System.out.println(removeCharAt(str, 12));
    }

    public static String removeCharAt(String str, int pos) {
        return str.substring(0, pos) + str.substring(pos + 1);
    }
}


/**
 * 字符串替换：
 * 通过Java String类的replace方法来替换字符串中的字符。
 */
class StringReplaceEmp {
    public static void main(String[] args) {
        String str = "Hello World, Javac.";
        System.out.println(str.replace("c", ""));
        System.out.println(str.replaceFirst("H", "h"));
        System.out.println(str.replaceAll("l", "L"));
    }
}


/**
 * 字符串反转：
 * 通过Java的反转函数reverse()将字符串反转。
 */
class StringReverseEmp {
    public static void main(String[] args) {
        String str = "runoob";
        String strReverse = new StringBuffer(str).reverse().toString();
        System.out.println("字符串反转前：" + str);
        System.out.println("字符串反转后：" + strReverse);
    }
}


/**
 * 字符串搜索：
 * 通过String类的indexOf()方法在字符串中查找子字符串出现的位置，
 * 如果存在返回字符串出现的位置（第一位为0），如果不存在返回 -1。
 */
class SearchStringEmp {
    public static void main(String[] args) {
        String strOrig = "Google Runoob Taobao.";
        int strIndex = strOrig.indexOf("Runoob");
        if (strIndex == -1) {
            System.out.println("没有找到字符串Runoob.");
        } else {
            System.out.println("Runoob字符串位置：" + strIndex);
        }
    }
}


/**
 * 字符串分割：
 * 通过String类的split(string) 方法通过指定分隔符将字符串分割为数组。
 */
class StringSplitEmp {
    public static void main(String[] args) {
        String str = "www-runoob-com";
        String[] temp;
        String deli = "-";
        temp = str.split(deli);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        System.out.println("--------Java for each循环输出的方法-----------");
        str = "www.runoob.com";
        // 指定分割字符，"."号需要转义
        deli = "\\.";
        temp = str.split(deli);
        for (String s: temp) {
            System.out.println(s);
        }
    }
}


/**
 * 字符串分隔(StringTokenizer)：
 * 通过StringTokenizer设置不同分隔符来分隔字符串，
 * 默认的分隔符是：空格、制表符（\t）、换行符(\n）、回车符（\r）。
 */
class StringTokenizerSplitEmp {
    public static void main(String[] args) {
        String str = "This is String, split by StringTokenizer, created by runoob.";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("---------通过空格分割-----------");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }

        System.out.println("----------通过逗号分割-----------");
        st = new StringTokenizer(str, ",");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}


/**
 * 字符串大小写互转：
 * 通过String类的toUpperCase()方法将字符串从小写转为大写；
 * toLowerCase()方法将字符串从大写转为小写。
 */
class StringToLowUpperCaseEmp {
    public static void main(String[] args) {
        String str1 = "string runoob";
        String str2 = "I LOVE YOU.";
        String strUpper = str1.toUpperCase();
        String strLower = str2.toLowerCase();
        System.out.println("原始字符串：" + str1);
        System.out.println("转换为大写：" + strUpper);
        System.out.println("原始字符串：" + str2);
        System.out.println("转换为小写：" + strLower);
    }
}


/**
 * 测试两个字符串区域是否相等：
 * 通过String类的regionMatches() 方法测试两个字符串区域是否相等。
 */
class StringRegionMatch {
    public static void main(String[] args) {
        String str1 = "Welcome to Microsoft.";
        String str2 = "I work with microsoft.";
        boolean match1 = str1.regionMatches(11, str2, 12, 9);
        // 第一个参数true表示忽略大小写区别
        boolean match2 = str1.regionMatches(true, 11, str2, 12, 9);
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);
    }
}


/**
 * 字符串性能比较测试
 */
class StringComparePerformance {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int times = 50000;
        for (int i = 0; i < times; i++) {
            String str1 = "hello";
            String str2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("通过String关键字创建字符串耗时(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            String str3 = new String("hello");
            String str4 = new String("hello");
        }
        endTime = System.currentTimeMillis();
        System.out.println("通过String对象创建字符串耗时(ms)：" + (endTime - startTime));
    }
}


/**
 * 字符串优化：通过 String.intern() 方法来优化字符串。
 */
class StringOptimization {
    public static void main(String[] args) {
        int size = 50000;
        String[] varializes = new String[size];
        for (int i = 0; i < size; i++) {
            varializes[i] = "s" + i;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            varializes[i] = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("直接使用字符串，耗时(ms): " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            varializes[i] = new String("hello");
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用new关键字，耗时(ms): " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            varializes[i] = new String("hello");
            varializes[i] = varializes[i].intern();
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用字符串对象的intern()方法，耗时(ms): " + (endTime - startTime));
    }
}


/**
 * 字符串格式化：通过format()方法来格式化字符串，还可以指定地区来格式化。
 */
class StringFormat {
    public static void main(String[] args) {
        double e = Math.E;
        System.out.format("%f%n", e);
        // 指定本地为中国
        System.out.format(Locale.CHINA, "%-10.4f%n%n", e);
    }
}


/**
 * 连接字符串：
 * 通过"+"操作符和StringBuffer.append()方法来连接字符串，并比较其性能。
 */
class StringConcatenate {
    public static void main(String[] args) {
        int times = 50000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            String result1 = "This is " + "testing the " + "difference " +
                    "between " +"String " +"and " +"StringBuffer.";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("字符串连接 - 使用'+'操作符，耗时(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            StringBuffer result = new StringBuffer();
            result.append("This is ");
            result.append("testing the ");
            result.append("difference ");
            result.append("between ");
            result.append("String ");
            result.append("and ");
            result.append("StringBuffer.");
        }
        endTime = System.currentTimeMillis();
        System.out.println("字符串连接 - 使用StringBuffer，耗时(ms)：" + (endTime - startTime));
    }
}