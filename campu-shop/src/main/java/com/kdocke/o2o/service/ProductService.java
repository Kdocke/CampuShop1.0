package com.kdocke.o2o.service;

import java.util.List;

import com.kdocke.o2o.dto.ImageHolder;
import com.kdocke.o2o.dto.ProductExecution;
import com.kdocke.o2o.entity.Product;
import com.kdocke.o2o.exception.ProductOperationException;

public interface ProductService {

	/**
	 * 通过商品 Id 查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺Id,商品类别
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	/**
	 * 添加商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param thumbnailName
	 * @param productImgList
	 * @param productImgNameList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 修改商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param thumbnailName
	 * @param productImgList
	 * @param productImgNameList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;

}
