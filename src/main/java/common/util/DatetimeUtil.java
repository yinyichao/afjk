package common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author 
 */
public class DatetimeUtil {
    /**
     * 返回当前时间增加秒数的timestamp
     *
     * @return
     */
    public static Timestamp getTimestampAddSecond(Integer second) {
        Calendar calendar = Calendar.getInstance();
        if (second != null && second > 0)
            calendar.add(Calendar.SECOND, second);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 返回当前时间的Timestamp
     *
     * @return
     */
    public static Timestamp getNowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 时差，与当前时间比较
     *
     * @param timestamp
     * @return
     */
    public static int dateSubNow(Timestamp timestamp) {
        if (null == timestamp)
            return 0;
        long now = System.currentTimeMillis();
        long time = ((Date) timestamp).getTime();
        long diff = now - time;
        return ((Long) (diff / 1000)).intValue();
    }

    /**
     * 时差，时间减去现在时间
     *
     * @param timestamp
     * @return
     */
    public static int nowSubDate(Timestamp timestamp) {
        if (null == timestamp)
            return 0;
        long now = System.currentTimeMillis();
        long time = ((Date) timestamp).getTime();
        long diff = time - now;
        return ((Long) (diff / 1000)).intValue();
    }

    /**
     * 返回当前时间　格式：yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String fromDateH() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 返回当前时间　格式：yyyy-MM-dd
     *
     * @return String
     */
    public static String fromDateY() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 返回当前时间　格式：yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String getCurTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * stringToTimestamp
     *
     * @param time
     * @return
     */
    public static Timestamp stringToTimestamp(String time) {
        return Timestamp.valueOf(time);
    }

    /**
     * timestampToString
     *
     * @param time
     * @return
     */
    public static String timestampToString(Timestamp time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }

    public static String timestampToStringYMD(Timestamp time) {
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    public static String dateToStringYMD(Date time) {
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * toString
     *
     * @param time
     * @return
     */
    public static String toString(Object time) {
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (time instanceof String) {
                java.text.SimpleDateFormat vdf = new java.text.SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                Date date = vdf.parse(time + "");
                return vdf.format(date);
            }
            tsStr = sdf.format(time);
            return tsStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fromDateH();
    }

    /**
     * 两个时间比大小
     *
     * @param dateStr1
     * @param dateStr2
     * @return
     */
    public static int compareTo(String dateStr1, String dateStr2) {
        int result = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(format.parse(dateStr1));
            c2.setTime(format.parse(dateStr2));
            result = c1.compareTo(c2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 和当前时间比大小
     *
     * @param dateStr
     * @return
     */
    public static int compareToNow(String dateStr) {
        int result = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(format.parse(dateStr));
            result = c1.compareTo(c2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 和当前时间比大小,如果小 返回当前时间,如果大 返回该时间
     *
     * @param dateStr
     * @return
     */
    public static String compareToNowReturn(String dateStr) {
        int result = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(format.parse(dateStr));
            result = c1.compareTo(c2);
            if (result <= 0) {
                return "已过期";
            } else {
                return dateStr;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return dateStr;
        }
    }

    public static Timestamp longToTimeStamp(Long l) {
        return new Timestamp(l);
    }

    public static String timeYYMMDDHH() {
        return new SimpleDateFormat("yyMMddHH").format(new Date());
    }

    public static int getWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
}
