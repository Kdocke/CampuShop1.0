package com.kdocke.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdocke.o2o.BaseTest;
import com.kdocke.o2o.entity.HeadLine;

public class HeadLineDaoTest extends BaseTest {
	
	@Autowired
	private HeadLineDao headLineDao;
	
	@Test
	public void testQueryHeadLine() {
		List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
		assertEquals(4, headLineList.size());
	}

}
