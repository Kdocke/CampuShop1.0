package com.kdocke.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kdocke.o2o.entity.ProductCategory;

/**
 * 商品分类相关的数据库操作接口，由 mybatis 实现
 * queryProductCategoryList:按商铺Id查询所有商品分类
 * batchInsertProductCategory:批量插入商品分类
 * deleteProductCategory:删除指定商品分类
 * 
 * @author Kdocke
 *
 */
public interface ProductCategoryDao {

	/**
	 * 通过 shopId 查询店铺商品类别
	 * 
	 * @param shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);

	/**
	 * 批量新增商品类别
	 * @param productCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);

	/**
	 * 删除指定商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 */
	int deleteProductCategory(@Param("productCategoryId")long productCategoryId, @Param("shopId")long shopId);
	
}
