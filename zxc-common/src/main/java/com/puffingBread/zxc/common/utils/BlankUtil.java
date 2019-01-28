package com.puffingBread.zxc.common.utils;

import java.io.Serializable;
import java.util.*;

/**
 * 判断对象是否为空
 *
 * @since 2015年3月13日 上午10:14:34
 */
public class BlankUtil {

    /**
     * 判断字符串是否为空
     *
     * @return 为空, 返回true; 否则,返回false;
     */
    public static boolean isBlank(final String str) {
        return (str == null) || (str.trim().length() <= 0);
    }

    /**
     * 判断字符是否为空
     *
     * @param cha
     * @return 为空, 返回true; 否则,返回false;
     */
    public static boolean isBlank(final Character cha) {
        return (cha == null) || cha.equals(' ');
    }

//    /**
//     * 判断对象是否为空
//     *
//     * @return 为空, 返回true; 否则,返回false;
//     */
//    public static boolean isBlank(final Object obj) {
//        return (obj == null);
//    }

    /**
     * 判断数组是否为空
     *
     * @param objs
     * @return 为空, 返回true; 否则,返回false;
     */
    public static boolean isBlank(final Object[] objs) {
        return (objs == null) || (objs.length <= 0);
    }

    /**
     * 判断Collectionj是否为空
     *
     * @param obj
     * @return 为空, 返回true; 否则,返回false;
     */
    public static <T> boolean isBlank(final Collection<T> obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 判断Set是否为空
     *
     * @param obj
     * @return 为空, 返回true; 否则,返回false;
     */
    public static <T> boolean isBlank(final Set<T> obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 判断List<T>是否为空
     *
     * @param obj
     * @return 为空, 返回true; 否则,返回false;
     */
    public static <T> boolean isBlank(final List<T> obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 判断Serializable是否为空
     *
     * @param obj
     * @return 为空, 返回true; 否则,返回false;
     */
    public static boolean isBlank(final Serializable obj) {
        return obj == null;
    }

    /**
     * 判断Map是否为空
     *
     * @param obj
     * @return 为空, 返回true; 否则,返回false;
     */
    public static <K, V> boolean isBlank(final Map<K, V> obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 过滤特殊字符设置到SQL语句中的字符串(过滤的字符类似 ',")
     *
     * @param str 待处理字符串
     * @return
     * @author laq
     * @since 2011-07-31
     */
    public final static String toDBFilter(String str) {
        return BlankUtil.trimString(str).replaceAll("\\\'", "''");
    }

    /**
     * 去掉字符串左右两边的空格,返回一个对象的字符串
     *
     * @param obj
     * @return
     * @author laq
     * @since 2011-07-31
     */
    public static String trimString(Object obj) {
        return (obj == null) ? "" : String.valueOf(obj).trim();
    }

    /**
     * 是否有为空的String
     *
     * @param args
     * @return
     */
    public static boolean isAnyBlank(String... args) {
        for (String p : args) {
            if (isBlank(p)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        boolean ret = BlankUtil.isBlank(sList);
        System.out.println("ret:" + ret);
    }
}
