package com.kdocke.o2o.service;

import java.io.File;

import com.kdocke.o2o.dto.ShopExecution;
import com.kdocke.o2o.entity.Shop;

public interface ShopService {

	ShopExecution addShop(Shop shop, File shopImg);
	
}
