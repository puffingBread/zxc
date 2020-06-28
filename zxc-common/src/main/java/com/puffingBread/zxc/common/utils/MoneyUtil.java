package com.puffingBread.zxc.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;

/**
 * 有关钱的分--元转换操作相关
 */
public class MoneyUtil {
	/**
	 * 获得字符长度
	 * @param str
	 * @param charset
	 * @return
	 */
	public static int getEncodingLength(String str, String charset){
		int length = 0;
		if(str != null){
			try {
				length = str.getBytes(charset).length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return length;
	}
	
	public static String getViewMoney(int money, boolean flag) {
		return flag == true ? MoneyUtil.getViewMoney2(money) : 
			MoneyUtil.getViewMoney(money);
	}
	
	public static String getViewMoney(int money){
		return String.valueOf(money / 100);
	}
	
	public static String getViewMoney(long money, boolean flag) {
		return flag == true ? MoneyUtil.getViewMoney2(money) : 
			MoneyUtil.getViewMoney(money);
	}
	
	public static String getViewMoney(long money){
		return String.valueOf(money / 100);
	}
	
	/**
	 * 
	 * @param view
	 * @return
	 */
	public static Integer getMoney(String view){
		int money = 0;
		if(StringUtil.isEmpty(view)){
			return null;
		}
		
		boolean plus = false;
		if(!view.startsWith("-")){
			plus = true;
		}else {
			view = view.substring(1);
		}
		
		String[] v = view.split("\\.");
		if(v.length > 2){
			throw new RuntimeException("输入格式错误！");
		}
		money = Integer.parseInt(v[0]) * 100;
		if(v.length == 2){
			if(v[1].length() > 2){
				throw new RuntimeException("输入格式错误！");
			}
			if(v[1].length() > 1){
				money += Integer.parseInt(v[1]);
			}else {
				money += Integer.parseInt(v[1]) * 10;
			}
		}

		return plus == true ? money : BitUtil.inversion(money);
	}
	
	/**
	 * 
	 * @param view
	 * @return
	 */
	public static Long getMoneyLong(String view){
		Long money = 0L;
		if(StringUtil.isEmpty(view)){
			return null;
		}
		
		boolean plus = false;
		if(!view.startsWith("-")){
			plus = true;
		}else {
			view = view.substring(1);
		}
		
		String[] v = view.split("\\.");
		if(v.length > 2){
			throw new RuntimeException("输入格式错误！");
		}
		money = Long.parseLong(v[0]) * 100L;
		if(v.length == 2){
			if(v[1].length() > 2){
				throw new RuntimeException("输入格式错误！");
			}
			if(v[1].length() > 1){
				money += Integer.parseInt(v[1]);
			}else {
				money += Integer.parseInt(v[1]) * 10;
			}
		}

		return plus == true ? money : BitUtil.inversion(money);
	}
	
	/**
	 * 单位分 - 格式化输出 "0.00"
	 * @param money
	 * @return
	 */
	private static String getViewMoney2(int money){
		String view  = "";
		boolean plus = false;
		
        if((money >> 31) == 0){ // 正数
        	plus = true;
        }else {
			money = Math.abs(money);
		}
    	int coin = money % 10;
    	money -= coin;
    	money /= 10;
    	int chief = money % 10;
    	money -= chief;
    	money /= 10;
    	
    	if(money > 0){
    		view += money;
    		view += ".";
    	}else {
    		view = "0.";
		}
    	view += chief;
    	view += coin;
        
		return plus == true ? view : "-" + view;
	}
	
	private static String getViewMoney2(long money){
		String view  = "";
		boolean plus = false;
		
        if((money >> 63) == 0){ // 正数
        	plus = true;
        }else {
			money = Math.abs(money);
		}
    	long coin = money % 10L;
    	money -= coin;
    	money /= 10L;
    	long chief = money % 10L;
    	money -= chief;
    	money /= 10;
    	
    	if(money > 0){
    		view += money;
    		view += ".";
    	}else {
    		view = "0.";
		}
    	view += chief;
    	view += coin;
        
		return plus == true ? view : "-" + view;
	}
	
	/**
	 * 把单位为“分”的金额,转成单位为“元”,支持两位小数
	 * @param money  分
	 * @return 带两位小数的“元”
	 */
	public static String getFloatMoneyView(long money){
		double m = (double)money / 100;
		NumberFormat ddf1 = NumberFormat.getNumberInstance() ;
		ddf1.setMaximumFractionDigits(2); 
		ddf1.setMinimumFractionDigits(2);
		return ddf1.format(m) ; 
	}
	
	
	/**
	 * 保留指定位数的小数
	 * @param value 待处理的浮点数
	 * @return 带指定位数的小数的字符串
	 */
	public static String getFloatValueWithDecimals(double value, int decimailsNum){
		if(decimailsNum < 0){
			decimailsNum = 2;
		}
		//double m = (double)value;
		NumberFormat ddf1 = NumberFormat.getNumberInstance() ;
		ddf1.setMaximumFractionDigits(decimailsNum); 
		ddf1.setMinimumFractionDigits(decimailsNum);
		return ddf1.format(value) ; 
	}
	
	/**
	 * 保留一位小数
	 * @param value 待处理的浮点数
	 * @return 带一位小数的字符串
	 */
	public static String getFloatValueWithOneDecimals(double value){
		return MoneyUtil.getFloatValueWithDecimals(value, 1);
	}
	
    /**
	 * 保留两位小数
	 * @param value 待处理的浮点数
	 * @return 带两位小数的字符串
	 */
	public static String getFloatValueWithTwoDecimals(double value){
		return MoneyUtil.getFloatValueWithDecimals(value, 2);
	}
	
	public static void main(String[] args){
		System.out.println(MoneyUtil.getFloatMoneyView(0));
	}
}
