package com.kgy.o2o.service.impl;

import com.kgy.o2o.dao.ShopCategoryDao;
import com.kgy.o2o.entity.ShopCategory;
import com.kgy.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 15:04 2018/1/10
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);

           }
}
