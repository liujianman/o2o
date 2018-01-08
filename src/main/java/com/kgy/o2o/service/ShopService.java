package com.kgy.o2o.service;

import com.kgy.o2o.dto.ShopExecution;
import com.kgy.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 14:46 2018/1/5
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
