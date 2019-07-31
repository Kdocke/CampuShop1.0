package com.kdocke.o2o.service;

import java.io.InputStream;

import com.kdocke.o2o.dto.ShopExecution;
import com.kdocke.o2o.entity.Shop;
import com.kdocke.o2o.exception.ShopOperationException;

public interface ShopService {

	/**
	 * 根据 shopCondition 分页返回相应店铺列表数据
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	/**
	 * 通过店铺 Id 获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息,包括图片处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
	/**
	 * 注册店铺信息,包括图片处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
}
