package com.seafood.api.vo;

import java.io.Serializable;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
public class ResponseData<T> implements Serializable {

	private static final long serialVersionUID = 12345678998745632L;

	private T data;

	private int code;

	private String msg;

	public ResponseData(T data, int code, String msg) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	int getCode() {
		return code;
	}

	void setCode(int code) {
		this.code = code;
	}

	String getMsg() {
		return msg;
	}

	void setMsg(String msg) {
		this.msg = msg;
	}

}
