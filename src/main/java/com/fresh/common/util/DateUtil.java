package com.fresh.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 */
public class DateUtil {

    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取yyyyMMddHHmmss格式
     */
    public static String getSdfTimes() {
        return sdfTimes.format(new Date());
    }

    /**
     * 获取yyyy格式
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * 日期比较，如果s>=e 返回true 否则返回false
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatCurrentDate() {
        DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(new Date());
    }

    /**
     * 校验日期是否合法
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //long aa=0;
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * 时间相减得到天数
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        //System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 给定日期得到n天之后的日期
     */
    public static String getAfterDayDateFromGivenDay(String createDate, int day) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(createDate);
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        System.out.println(sdf.format(cl.getTime()));
        System.out.println(day);
        cl.add(Calendar.DATE, day);
        String temp = sdf.format(cl.getTime());
        return temp;
    }

    /**
     * 得到n天之后是周几
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        return dateStr;
    }

//    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//        int date = cal.get(Calendar.DAY_OF_MONTH);
//        int n = cal.get(Calendar.DAY_OF_WEEK);
//        if (n == 1) {
//            n = 7;
//        } else {
//            n = n - 1;
//        }
//        System.out.println("当天为本周第" + n + "天");
//        // 日期格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        for (int i = 1; i <= 7; i++) {
//            cal.set(Calendar.DAY_OF_MONTH, date + i - n);
//            System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
//        }
//    }
//    public static void main(String[] args) throws ParseException {
//        Calendar startDay = Calendar.getInstance();
//        Calendar endDay = Calendar.getInstance();
//
//        startDay.setTime(sdfDay.parse("2010-02-01"));
//        endDay.setTime(sdfDay.parse("2010-05-09"));
//        List<String> allDaysBetween = getAllDaysBetween(startDay, endDay);
//        System.out.print(allDaysBetween.toString());
//    }

    /**
     * 获取两日期之间的所有的日期
     */
    public static List<String> getAllDaysBetween(Calendar startDay, Calendar endDay) {
        // 给出的日期开始日比终了日大则不执行打印
        if (startDay.compareTo(endDay) >= 0) {
            return new ArrayList<String>(0);
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add(sdfDay.format(startDay.getTime()));
        // 现在打印中的日期
        Calendar currentPrintDay = startDay;
        while (true) {
            // 日期加一
            currentPrintDay.add(Calendar.DATE, 1);
            // 日期加一后判断是否达到终了日，达到则终止打印
            if (currentPrintDay.compareTo(endDay) == 0) {
                break;
            }
            // 打印日期
            list.add(sdfDay.format(currentPrintDay.getTime()));
        }
        list.add(sdfDay.format(endDay.getTime()));
        return list;
    }

    /**
     * 获取某年月的最后一天
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        //设置年份
        a.set(Calendar.YEAR, year);
        //设置月份
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(a.getTime());
        return lastDayOfMonth;
    }

    //   实现给定某日期，判断是星期几

    public static String getWeekday(String date){//必须yyyy-MM-dd
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
            dt = sd.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];

//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//
//        SimpleDateFormat sdw = new SimpleDateFormat("EEEE");
//
//        Date d = null;
//
//        try {
//
//            d = sd.parse(date);
//
//        } catch (ParseException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return sdw.format(d);

    }
    public static void main(String[] args) throws Exception{
        System.out.println(1/3);
    }
}
