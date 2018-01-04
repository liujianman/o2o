package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Shop;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 12:15 2018/1/4
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);
}
