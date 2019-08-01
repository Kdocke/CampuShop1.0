package com.kdocke.o2o.dao;

import java.util.List;

import com.kdocke.o2o.entity.ProductCategory;

public interface ProductCategoryDao {

	/**
	 * 通过 shopId 查询店铺商品类别
	 * 
	 * @param shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);

}
