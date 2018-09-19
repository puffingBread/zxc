package com.puffingBread.zxc.common.exception;

public class ReadMessageException extends Exception implements IReadMessageExcetpion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9209981419092628468L;
	/**
	 * 
	 */
	private int code = 0;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ReadMessageException(String msg){
		super(msg);
	}
	public ReadMessageException(String msg,int code){		
		super(msg);
		this.code = code;
	}
	
	public ReadMessageException(Throwable cause) {
		super(cause);
	}
	
	public ReadMessageException(String message, Throwable cause) {
		super(message, cause);
	}
}
