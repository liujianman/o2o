package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Shop;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 12:15 2018/1/4
 */
public interface ShopDao {
    /**
     * 通过shopid查询店铺
     * @param shopId
     * @return shop
     */
    Shop queryByShopId(long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
