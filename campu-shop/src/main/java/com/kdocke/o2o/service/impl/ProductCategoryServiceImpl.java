package com.kdocke.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdocke.o2o.dao.ProductCategoryDao;
import com.kdocke.o2o.dao.ProductDao;
import com.kdocke.o2o.dto.ProductCategoryExecution;
import com.kdocke.o2o.entity.ProductCategory;
import com.kdocke.o2o.enums.ProductCategoryStateEnum;
import com.kdocke.o2o.exception.ProductCategoryOperationException;
import com.kdocke.o2o.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Autowired
	private ProductDao ProductDao;

	@Override
	public List<ProductCategory> getProductCategoryList(Long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("店铺类别创建失败");
				}else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error: " + e.getMessage());
			}
		}else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		// 解除 tb_product 里的商品与该 productCategoryId 的关联
		try {
			int effectedNum = ProductDao.updateProductCategoryToNull(productCategoryId);
			if (effectedNum < 0) {
				throw new RuntimeException("商品类别更新失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException("deleteProductCategory error: " + e.getMessage());
		}
		// 删除该 productCategory
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException("商品类别删除失败");
			}else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error: " + e.getMessage());
		}
	}

}
