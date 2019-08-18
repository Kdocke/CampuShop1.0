package com.kdocke.o2o.entity;

import java.util.Date;

/**
 * 商铺类别 实体类
 * 
 * @author Kdocke
 *
 */
public class ShopCategory {

	// 商铺类别ID
	private Long shopCategoryId;
	// 商铺类别名
	private String shopCategoryName;
	// 商铺类别描述
	private String shopCategoryDesc;
	// 商铺类别图片
	private String shopCategoryImg;
	// 权重
	private Integer priority;
	// 创建时间
	private Date createTime;
	// 上次修改时间
	private Date lastEditTime;
	// 上级商品类别
	private ShopCategory parent;
	
	public Long getShopCategoryId() {
		return shopCategoryId;
	}
	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}
	public String getShopCategoryName() {
		return shopCategoryName;
	}
	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}
	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}
	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}
	public String getShopCategoryImg() {
		return shopCategoryImg;
	}
	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public ShopCategory getParent() {
		return parent;
	}
	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}
	
}
