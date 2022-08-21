package com.seafood.api.vo;

import java.io.Serializable;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
public class ResponseData<T> implements Serializable {

	private static final long serialVersionUID = 12345678998745632L;

	private T object;

	private int code;

	private String msg;

	public ResponseData(T object, int code, String msg) {
		this.object = object;
		this.code = code;
		this.msg = msg;
	}

	T getObject() {
		return object;
	}

	void setObject(T object) {
		this.object = object;
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
