package com.bread.enlighten.zxc.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpUtil {
	/**
	 * 获取输入流
	 * @param request
	 * @return
	 */
	public static String getBufferStream(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		
		try {
			InputStream in = request.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
			BufferedReader buffer = new BufferedReader(reader);
			String str = null;
			
			while ((str = buffer.readLine()) != null) {
				sb.append(str);
			}
			
			buffer.close();
			reader.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
