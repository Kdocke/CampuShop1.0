package com.kdocke.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kdocke.o2o.entity.Product;

/**
 * 商品相关的数据库操作接口，由 mybatis 实现 
 * insertProduct:插入商品
 * queryProductById:通过商品 Id 查询商品
 * queryProductList:列表分页查询商品
 * queryProductCount:按条件查询商品总数
 * updateProduct:更新商品
 * 
 * @author Kdocke
 *
 */
public interface ProductDao {

	/**
	 * 插入商品
	 * 
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);

	/**
	 * 通过 productId 查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product queryProductById(long productId);

	/**
	 * 查询商品列表并分页，可输入的条件有：商品名(模糊),商品状态,店铺Id,商品类别
	 * 
	 * @param productCondition
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 查询对应的商品总数
	 * 
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);

	/**
	 * 更新商品信息
	 * 
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

}
