package com.seafood.api.vo;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@Data
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

}
