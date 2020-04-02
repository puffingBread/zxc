package com.bread.enlighten.zxc.common.util.utils;


/**
 * 
 * @date 2015年5月15日 下午6:00:28
 */
public class BitUtil {
	/**
	 * 检验某位是否为 二进制 1
	 * @param src
	 * @param bit 从1开始计数
	 * @return
	 */
	public static boolean verifyBitOne(int src, int bit){
		return ((1 << (bit - 1)) & src) != 0;
	}
	
	public static boolean verifyBitOne(long src, int bit){
		return ((1 << (bit - 1)) & src) != 0;
	}
	
	/**
	 * 将 某一位变为二进制 1
	 * @param src
	 * @param bit 从1开始计数
	 * @return
	 */
	public static int exBitOne(int src, int bit){		
		return src | (1 << (bit - 1));
	}
	
	public static long exBitOne(long src, int bit){		
		return src | (1 << (bit - 1));
	}
	
	/**
	 * 将 某一位变为二进制 0
	 * @param src
	 * @param bit 从1开始计数
	 * @return
	 */
	public static int exBitZero(int src, int bit){		
		return ~(1 << (bit - 1)) & src;
	}
	
	public static long exBitZero(long src, int bit){		
		return ~(1 << (bit - 1)) & src;
	}
	
    /**
     * 
     * 将某位取反
     * @param src
     * @param bit 从1开始计数
     * @return
     */
	public static int reverse(int src, int bit){
		return src ^ (1 << (bit - 1));
	}
	
	public static long reverse(long src, int bit){
		return src ^ (1 << (bit - 1));
	}
	
	///////////////////////////////////////////
	/**
	 * 将 某一位 变为 1
	 * @param num
	 * @param bit
	 * @return
	 */
	public static int bit(int num, int bit){		
		return num | (1 << (bit - 1));
	}
	
	public static long bit(long num, int bit){		
		return num | (1 << (bit - 1));
	}
	
	/**
	 * 将 某一位 变为 0
	 * @param num
	 * @param bit
	 * @return
	 */
	public static int exbit(int num, int bit){		
		return ~(1 << (bit - 1)) & num;
	}
	
	public static long exbit(long num, int bit){		
		return ~(1 << (bit - 1)) & num;
	}
	
	/**
	 * 检验某一位是否为 1
	 * @param num
	 * @param bit
	 * @return
	 */
	public static boolean verfiyBit(int num, int bit) {
		return ((1 << (bit - 1)) & num) != 0;
	}
	
	public static boolean verfiyBit(long num, int bit) {
		return ((1 << (bit - 1)) & num) != 0;
	}
	
	/**
	 * 符号取反
	 * @param num
	 * @return
	 */
	public static int inversion(int num){
		return ~num + 1;
	}
	
	public static long inversion(long num){
		return ~num + 1;
	}
}
