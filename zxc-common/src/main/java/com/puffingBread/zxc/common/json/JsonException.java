package com.puffingBread.zxc.common.json;

/**
 * JSON错误.
 * 
 */
public class JsonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JsonException(String message) {
		super(message);
	}

	public JsonException(Throwable cause) {
		super(cause);
	}

}
