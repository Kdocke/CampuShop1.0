package com.kdocke.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdocke.o2o.BaseTest;
import com.kdocke.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
//		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
//		assertEquals(2, shopCategoryList.size());
//		ShopCategory testCategory = new ShopCategory();
//		ShopCategory parentCategory = new ShopCategory();
//		parentCategory.setShopCategoryId(1L);
//		testCategory.setParent(parentCategory);
//		shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
//		assertEquals(1, shopCategoryList.size());
//		System.out.println(shopCategoryList.get(0).getShopCategoryName());
		
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.size());
	}
	
}
