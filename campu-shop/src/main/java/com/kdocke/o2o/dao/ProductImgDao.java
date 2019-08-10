package com.kdocke.o2o.dao;

import java.util.List;

import com.kdocke.o2o.entity.ProductImg;

/**
 * 商品图片相关的数据库操作接口，由 mybatis 实现 
 * queryProductImgList:查询商品的详情图
 * batchInsertProductImg:插入商品详情图
 * deleteProductImgByProductId:删除商品详情图
 * 
 * @author Kdocke
 *
 */
public interface ProductImgDao {

	/**
	 * 根据 productId 查询出所有商品详情图
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);

	/**
	 * 批量添加商品详情图片
	 * 
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);

	/**
	 * 删除指定商品下的所有详情图
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);

}
