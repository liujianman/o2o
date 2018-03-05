package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Area;
import com.kgy.o2o.entity.PersonInfo;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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
    @Ignore
    public void queryByShopId() throws Exception {
        long shopId =5;
        Shop shop =shopDao.queryByShopId(shopId);
        System.out.println("ID:"+shop.getArea().getAreaId());
        System.out.println("name:"+shop.getArea().getAreaName());
    }

    @Test
    @Ignore
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
    @Ignore
    public void updateShop() throws Exception {
        Shop shop=new Shop();
        shop.setShopId(2L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum =shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }

    @Test
    public void queryShopList() {
        Shop shopCondition =new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1l);
        shopCondition.setOwner(owner);
        List<Shop> shopList=shopDao.queryShopList(shopCondition,0,5);
        int count =shopDao.queryShopCount(shopCondition);
        System.out.println("大小："+shopList.size());
        System.out.println("总数："+count);
    }
}