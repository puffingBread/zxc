package com.puffingBread.zxc.common.utils;

/**
 * @author cliang
 * @class MathUtil
 * @date 2015年10月1日 下午5:19:57
 */
public class MathUtil {
	/**
	 * 无符号长整型
	 * @param val
	 * @return
	 */
	public static long unsigned(long val){
		if(val >> 63 == 0){
			return val;
		}
		val &=0x7FFFFFFFFFFFFFFFL;
		val |= 0x80000000L;
		return val;
	}
	
	/**
	 * 判断是否为奇数
	 * @param num
	 * @return
	 */
	public static boolean isOdd(int num) {
		return (num & 1) != 0;
	}
	
	public static boolean isOdd(long num) {
		return (num & 1) != 0;
	}
}
