package com.kdocke.o2o.util;

public class PageCalculator {

	/**
	 * 将前端数据页码转换为后端的行数
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static int calculateRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
	
}
