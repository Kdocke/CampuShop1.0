package com.kdocke.o2o.service;

import java.util.List;

import com.kdocke.o2o.entity.ProductCategory;

public interface ProductCategoryService {

	/**
	 * 查询指定店铺下的所有商品类别信息
	 * 
	 * @param Long
	 *            shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(Long shopId);

}
