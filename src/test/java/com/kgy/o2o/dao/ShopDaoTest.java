package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Area;
import com.kgy.o2o.entity.PersonInfo;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 15:15 2018/1/4
 */
public class ShopDaoTest extends BaseTest{

    @Autowired
    private ShopDao shopDao;
    @Test
    public void queryByShopId() throws Exception {
        long shopId =2;
        Shop shop =shopDao.queryByShopId(shopId);
        System.out.println("ID:"+shop.getArea().getAreaId());
        System.out.println("name:"+shop.getArea().getAreaName());
    }

    @Test
    public void insertShop() throws Exception {
        Shop shop=new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("ImageUtil");
        shop.setShopAddr("ImageUtil");
        shop.setPhone("ImageUtil");
        shop.setShopImg("ImageUtil");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum =shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }
    @Test
    public void updateShop() throws Exception {
        Shop shop=new Shop();
        shop.setShopId(2L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum =shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }

}