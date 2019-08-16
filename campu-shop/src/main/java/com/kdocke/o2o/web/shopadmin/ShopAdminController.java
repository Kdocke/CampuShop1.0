package com.kdocke.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主要用来解析路由并转发到相应的 html 中
 * 
 * @author Kdocke
 */
@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
public class ShopAdminController {

	@RequestMapping(value = "/shoplist")
	public String shopList() {
		// 转发到店铺列表页面
		return "shop/shoplist";
	}
	
	@RequestMapping(value = "/shopoperation")
	public String shopOperation() {
		// 转发到店铺注册/编辑页面
		return "shop/shopoperation";
	}

	@RequestMapping(value = "/shopmanagement")
	public String shopManagement() {
		// 转发到店铺管理页面
		return "shop/shopmanagement";
	}

	@RequestMapping(value = "/productcategorymanagement", method = RequestMethod.GET)
	public String procuctCategoryManagement() {
		// 转发到商品类别管理页面
		return "shop/productcategorymanagement";
	}
	
	@RequestMapping(value = "/productoperation")
	public String productOperation() {
		// 转发到商品添加/编辑页面
		return "shop/productoperation";
	}

}
