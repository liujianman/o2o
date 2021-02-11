package com.kgy.o2o.dao;

import com.kgy.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 11:49 2018/1/10
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void queryShopCategory() throws Exception {
        List<ShopCategory>shopCategoryList = shopCategoryDao.queryShopCategory(null);
        System.out.println("大小：" +shopCategoryList.size());
    }

}