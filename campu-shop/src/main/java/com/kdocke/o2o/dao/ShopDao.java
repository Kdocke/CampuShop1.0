package com.kdocke.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kdocke.o2o.entity.Shop;

/**
 * 商铺相关的数据库操作接口，由 mybatis 实现 queryByShopId:查询店铺信息 insertShop:向数据库中插入一条店铺信息
 * updateShop:更新数据库中的一条店铺信息
 * 
 * @author Kdocke
 *
 */
public interface ShopDao {

	/**
	 * 分页查询店铺,可输入的条件有:店铺名(模糊),店铺状态,店铺类别,区域Id,owner
	 * 
	 * @param shopCondition
	 *            条件
	 * @param rowIndex
	 *            从第几行开始取数据
	 * @param pageSize
	 *            返回的条数
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 返回 queryShopList 总数,用于分页
	 * 
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);

	/**
	 * 通过 shop id 查询店铺
	 * 
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);

	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
