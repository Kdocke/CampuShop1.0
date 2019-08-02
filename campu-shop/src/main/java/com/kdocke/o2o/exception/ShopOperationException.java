package com.kdocke.o2o.exception;

/**
 * Shop 操作异常类
 * 
 * @author Kdocke
 *
 */
public class ShopOperationException extends RuntimeException {

	private static final long serialVersionUID = 7815471144593063626L;

	public ShopOperationException(String msg) {
		super(msg);
	}

}
