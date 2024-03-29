package com.kdocke.o2o.service;

import java.util.List;

import com.kdocke.o2o.entity.ShopCategory;

public interface ShopCategoryService {

	/**
	 * 根据查询条件获取 shopCategory 列表
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);

}
