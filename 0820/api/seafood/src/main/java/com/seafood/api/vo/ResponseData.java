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

	private T content;

	private int code;

	private String msg;

	public ResponseData() {
	}

	public ResponseData(T content, int code, String msg) {
		this.content = content;
		this.code = code;
		this.msg = msg;
	}

}
