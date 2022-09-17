package com.seafood.api.utils;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
public class Constants {

	public static final int OK = 200;
	public static final int ERROR_USER_STATE_WRONG = 10001;
	public static final int ERROR_CANCEL_ORDER_FAILED = 10002;
	public static final int ERROR_CREATE_ORDER_FAILED = 10003;

	public static final String MESSAGE = "success";
	public static final String ERROR_USER_STATE_WRONG_MESSAGE = "user state is wrong, pls contact admin";
	public static final String ERROR_CANCEL_ORDER_FAILED_MESSAGE = "failed to cancel order, pls contact admin";
	public static final String ERROR_CREATE_ORDER_FAILED_MESSAGE = "no items.";

	/**
	 * 禁用用户
	 */
	public static final int USER_DISABLED = 1;

}
