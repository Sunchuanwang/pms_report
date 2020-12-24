package com.amhs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sun.chuanwang
 * @version 1.0.0
 * @date 2020/12/23 4:45
 */
public class DateFormat {

    /**
     * 时间串转字符
     */
    public static String parseDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    /**
     * 字符串转时间
     */
    public static Date dateToString(String dateStr)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("解析失败");
        }
    }
}
