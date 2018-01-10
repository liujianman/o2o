package com.kgy.o2o.dao;

import com.kgy.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 11:17 2018/1/10
 */
public interface ShopCategoryDao{
    /**
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}