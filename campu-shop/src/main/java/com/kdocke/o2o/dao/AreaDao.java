package com.kdocke.o2o.dao;

import java.util.List;

import com.kdocke.o2o.entity.Area;

/**
 * 区域相关的数据库操作接口，由 mybatis 实现 
 * queryArea:查询所有 Area
 * 
 * @author Kdocke
 *
 */
public interface AreaDao {

	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();

}
