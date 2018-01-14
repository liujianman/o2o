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
    /**
     * 注册店铺，包括图片处理
     *
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;

    /**
     * 通过ID获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId)throws RuntimeException;

    /**
     * 更新店铺信息
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;

}
