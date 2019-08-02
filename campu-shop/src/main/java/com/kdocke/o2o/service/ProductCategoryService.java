package com.kdocke.o2o.service;

import java.util.List;

import com.kdocke.o2o.dto.ProductCategoryExecution;
import com.kdocke.o2o.entity.ProductCategory;
import com.kdocke.o2o.exception.ProductCategoryOperationException;

public interface ProductCategoryService {

	/**
	 * 查询指定店铺下的所有商品类别信息
	 * 
	 * @param Long
	 *            shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(Long shopId);

	/**
	 * 批量添加商品类别
	 * 
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;
	
	/**
	 * 将此类别下的商品里的类别 id 置为空,再删除掉该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;

}
