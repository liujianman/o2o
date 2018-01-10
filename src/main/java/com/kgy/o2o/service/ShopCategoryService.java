package com.kgy.o2o.service;

import com.kgy.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 14:58 2018/1/10
 */
public interface ShopCategoryService {
    List<ShopCategory>getShopCategoryList(ShopCategory shopCategoryCondition);
}
