package com.kdocke.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kdocke.o2o.entity.ShopCategory;

/**
 * 商铺分类相关的数据库操作接口，由 mybatis 实现
 * queryShopCategory:查询所有商铺分类
 * 
 * @author Kdocke
 *
 */
public interface ShopCategoryDao {
	
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
	
}
