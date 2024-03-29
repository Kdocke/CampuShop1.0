package com.kdocke.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdocke.o2o.dao.AreaDao;
import com.kdocke.o2o.entity.Area;
import com.kdocke.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	/**
	 * 返回所有区域列表
	 */
	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

}
