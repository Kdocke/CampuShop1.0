package com.kdocke.o2o.exception;

/**
 * 商品 操作异常类
 * 
 * @author Kdocke
 *
 */
public class ProductCategoryOperationException extends RuntimeException {

	private static final long serialVersionUID = -1127759562131160312L;

	public ProductCategoryOperationException(String msg) {
		super(msg);
	}

}
