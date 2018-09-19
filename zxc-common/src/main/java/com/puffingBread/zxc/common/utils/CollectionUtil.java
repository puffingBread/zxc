package com.puffingBread.zxc.common.utils;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author cliang
 *
 */
public class CollectionUtil {

	public static <K, V> boolean isEmpty(Map<K, V> map){
		return map == null || map.isEmpty();
	}
	
	public static <K, V> boolean isNotEmpty(Map<K, V> map){
		return !CollectionUtil.isEmpty(map);
	}

	public static <T> boolean isEmpty(List<T> list){
		return list == null || list.isEmpty();
	}

	public static <T> boolean isNotEmpty(List<T> list){
		return  !CollectionUtil.isEmpty(list);
	}
}
