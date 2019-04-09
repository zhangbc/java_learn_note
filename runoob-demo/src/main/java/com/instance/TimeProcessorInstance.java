package com.instance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Java时间处理
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:14
 */
public class TimeProcessorInstance {
    public static void main(String[] args) {
        System.out.println("Java时间处理实例！");
    }
}


/**
 * 格式化时间（SimpleDateFormat）：
 * 通过SimpleDateFormat类的format(date)方法来格式化时间。
 */
class DateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));
    }
}


/**
 * 获取当前时间：
 * 通过Date类及SimpleDateFormat类的format(date)方法来输出当前时间。
 */
class CurrentDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        // 获取当前时间
        Date date = new Date();
        // 输出已格式化的现在时间（24小时制）
        System.out.println("现在时间：" + sdf.format(date));
    }
}


/**
 * 获取年份，月份等：
 * 通过使用Calendar类来输出年份、月份等。
 */
class DateYearMonth {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int dow = calendar.get(Calendar.DAY_OF_WEEK);
        int dom = calendar.get(Calendar.DAY_OF_MONTH);
        int doy = calendar.get(Calendar.DAY_OF_YEAR);

        System.out.println("当前时间：" + calendar.getTime());
        System.out.println("日期：" + day);
        System.out.println("月份：" + month);
        System.out.println("年份：" + year);

        // 星期日为一周的第一天输出为1，星期一输出为2，依此类推。
        System.out.println("一周的第几天：" + dow);
        System.out.println("一月中的第几天：" + dom);
        System.out.println("一年的第几天：" + doy);
    }
}


/**
 * 时间戳转换成时间：
 * 通过SimpleDateFormat类的format()方法将时间戳转换成时间。
 * 日期和时间模式(注意大小写，代表的含义是不同的)：
 *     yyyy：年
 *     MM：月
 *     dd：日
 *     hh：1~12小时制(1-12)
 *     HH：24小时制(0-23)
 *     mm：分
 *     ss：秒
 *     S：毫秒
 *     E：星期几
 *     D：一年中的第几天
 *     F：一月中的第几个星期(会把这个月总共过的天数除以7)
 *     w：一年中的第几个星期
 *     W：一月中的第几星期(会根据实际情况来算)
 *     a：上下午标识
 *     k：和HH差不多，表示一天24小时制(1-24)
 *     K：和hh差不多，表示一天12小时制(0-11)
 *     z：表示时区
 */
class TimeStampConversion {
    public static void main(String[] args) {
        // 获取当前时间戳
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 时间戳转换成时间
        String currentDate = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("当前时间格式化1：" + currentDate);

        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        currentDate = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("当前时间格式化2：" + currentDate);
    }
}