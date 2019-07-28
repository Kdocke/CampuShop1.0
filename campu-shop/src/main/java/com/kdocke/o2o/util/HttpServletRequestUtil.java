package com.kdocke.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {

	/**
	 * 从 request 中获取 int 类型的数据
	 * @param request
	 * @param key
	 * @return
	 */
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 从 request 中获取 long 类型的数据
	 * @param request
	 * @param key
	 * @return
	 */
	public static long getLong(HttpServletRequest request, String key) {
		try {
			return Long.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1l;
		}
	}
	
	/**
	 * 从 request 中获取 double 类型的数据
	 * @param request
	 * @param key
	 * @return
	 */
	public static double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}
	
	/**
	 * 从 request 中获取 boolean 类型的数据
	 * @param request
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 从 request 中获取 string 类型的数据
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getString(HttpServletRequest request, String key) {
		try {
			String result = request.getParameter(key);
			if (request != null) {
				result = result.trim();
			}
			if ("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
}
