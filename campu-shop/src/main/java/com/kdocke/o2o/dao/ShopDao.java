package com.kdocke.o2o.dao;

import com.kdocke.o2o.entity.Shop;

/**
 * 商铺相关的数据库操作接口，由 mybatis 实现
 * queryByShopId:查询店铺信息
 * insertShop:向数据库中插入一条店铺信息
 * updateShop:更新数据库中的一条店铺信息
 * 
 * @author Kdocke
 *
 */
public interface ShopDao {

	/**
	 * 通过 shop id 查询店铺
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);
	
	/**
	 * 新增店铺
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺信息
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
