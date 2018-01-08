package com.kgy.o2o.service;

import com.kgy.o2o.dao.BaseTest;
import com.kgy.o2o.dto.ShopExecution;
import com.kgy.o2o.entity.Area;
import com.kgy.o2o.entity.PersonInfo;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.entity.ShopCategory;
import com.kgy.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 17:14 2018/1/5
 */
public class ShopServiceTest extends BaseTest{
    @Autowired
    private ShopService shopService;

    @Test
    public void addShop() throws Exception {
//        Shop shop=new Shop();
//        PersonInfo owner = new PersonInfo();
//        Area area = new Area();
//        ShopCategory shopCategory = new ShopCategory();
//        owner.setUserId(1L);
//        area.setAreaId(2);
//        shopCategory.setShopCategoryId(1L);
//        shop.setOwner(owner);
//        shop.setArea(area);
//        shop.setShopCategory(shopCategory);
//        shop.setShopName("测试店铺1");
//        shop.setShopDesc("test1");
//        shop.setShopAddr("test1");
//        shop.setPhone("test1");
//        shop.setCreateTime(new Date());
//        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
//        shop.setAdvice("审核中");
//        CommonsMultipartFile shopImg = new CommonsMultipartFile("C:\\Users\\Administrator\\Desktop\\image\\cc.jpg");
//        ShopExecution shopStateEnum =shopService.addShop(shop,shopImg);
//        assertEquals(ShopStateEnum.CHECK.getState(),shopStateEnum.getState());
    }

}