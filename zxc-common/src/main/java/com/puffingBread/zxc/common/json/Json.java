package com.puffingBread.zxc.common.json;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;

public class Json {
	private static ObjectMapper mapper = new ObjectMapper(); // can reuse, share
	static{
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);  
		mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 允许'/'字符
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
	}
	private static final Log logger = LogFactory.getLog(Json.class);

	// globally

	public Json() {

	}

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			String str = mapper.writeValueAsString(obj);
			return str;
		}
		catch (JsonGenerationException e) {
			// LOGGER.info(e.getMessage(), e);
			logger.error(e.getMessage(), e);
			//throw new JsonException(e);
		}
		catch (JsonMappingException e) {
			// LOGGER.info(e.getMessage(), e);
			logger.error(e.getMessage(), e);
			//throw new JsonException(e);
		}
		catch (IOException e) {
			// LOGGER.info(e.getMessage(), e);
			logger.error(e.getMessage(), e);
			//throw new JsonException(e);
		}
		return null;
	}

	/**
	 * json转List
	 * 
	 * @param content
	 *            json数据
	 * @param valueType
	 *            泛型数据类型
	 * @return
	 */
	public static List<?> toListObject(String content, Class<?> valueType) {
		try {
			return mapper.readValue(content, TypeFactory.defaultInstance().constructCollectionType(List.class, valueType));
		}
		catch (JsonParseException e) {
			logger.error(content);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (JsonMappingException e) {
			logger.error(content);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (IOException e) {
			logger.error(content);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
	}

	public static <T> T toBean(String content, Class<T> valueType) {
		if (content == null || content.length() == 0) {
			return null;
		}
		try {
			return mapper.readValue(content, valueType);
		}
		catch (JsonParseException e) {
			logger.error(content);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (JsonMappingException e) {
			logger.error(content);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
	}
	
	public static HashMap<String,Object> toHashMap(String jsonContent){
		try {
			return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class));
		}
		catch (JsonParseException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (JsonMappingException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (IOException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
	}
	
	public static HashSet<Object> toHasSet(String jsonContent){
		try {
			return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructCollectionType(HashSet.class, Object.class));
		}
		catch (JsonParseException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (JsonMappingException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
		catch (IOException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			throw new JsonException(e);
		}
	}
	
	public static String[] toStringArray(String jsonContent){
			try {
				return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructArrayType(String.class));
			} catch (JsonParseException e) {
				logger.error(jsonContent);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.error(jsonContent);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(jsonContent);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			return null;
	}
	
	public static Integer[] toIntegerArray(String jsonContent){
		try {
			return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructArrayType(Integer.class));
		} catch (JsonParseException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static Long[] toLongArray(String jsonContent){
		try {
			return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructArrayType(Long.class));
		} catch (JsonParseException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(jsonContent);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	public static String toJsonString(Object o){
		if(o == null){
			return null;
		}
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return jsonString;
	}

	public static <T> T toObject(String jsonString, Class<T> clazz) {
		if(StringUtils.isBlank(jsonString)){
			return null;
		}
		T bean = null;
		try {
			bean = mapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(String jsonString, Class<T> clazz){
		if(StringUtils.isBlank(jsonString)){
			return (T[]) Array.newInstance(clazz, 0);
		}
		try {
			return mapper.readValue(jsonString, TypeFactory.defaultInstance().constructArrayType(clazz));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T[]) Array.newInstance(clazz, 0);
	}

	public static <T> List<T> toList(String jsonString, Class<T> clazz){
		T[] array = Json.toArray(jsonString, clazz);
		List<T> list = new ArrayList<T>(array.length);

		for(T e : array){
			list.add(e);
		}
		return list;
	}

	public static HashMap<String,Object> toHashedMap(String jsonContent){
		try {
			return mapper.readValue(jsonContent, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HashMap<String, Object>();
	}
}
