package com.kdocke.o2o.util;

public class PathUtil {

	private static String separator = System.getProperty("file.separator");

	/**
	 * 获取图片保存位置的基本路径
	 * @return
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "F:/TempDirectory/cs";
		} else {
			basePath = "/home/kd/cs";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}

	
	/**
	 * 获取商铺图片保存的位置
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(Long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", separator);
	}

}
