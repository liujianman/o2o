package com.kgy.o2o.service.impl;

import com.kgy.o2o.dao.ShopDao;
import com.kgy.o2o.dto.ShopExecution;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.enums.ShopStateEnum;
import com.kgy.o2o.service.ShopService;
import com.kgy.o2o.util.FileUtil;
import com.kgy.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 14:48 2018/1/5
 */
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException{
        if (shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            //初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <=0){
                throw  new RuntimeException("店铺创建失败");
            }else {
                if (shopImg != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImg);
                    } catch (Exception e) {
                        throw new RuntimeException("addShopImg errro:" + e.getMessage());
                    }
                    //更新店铺图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new RuntimeException("更新图片失败");
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

//根据Id查询店铺信息
    @Override
    public Shop getByShopId(long shopId) throws RuntimeException {
        return shopDao.queryByShopId(shopId);
    }

    //更改店铺信息
    @Override
    public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException {

        if (shop==null || shop.getShopId()==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }else{
            //判断是否处理照片
            try{
            if (shopImg!=null){
              Shop tempShop=shopDao.queryByShopId(shop.getShopId());
              if (tempShop.getShopImg()!=null){
                  ImageUtil.deleteFileOrPath(tempShop.getShopImg());
              }
              addShopImg(shop,shopImg);
            }
            //更新店铺信息
            shop.setLastEditTime(new Date());
            int effectedNum =shopDao.updateShop(shop);
            if (effectedNum <=0){
                return new ShopExecution(ShopStateEnum.INNER_ERROR);
            }else {
                shop = shopDao.queryByShopId(shop.getShopId());
                return new ShopExecution(ShopStateEnum.SUCCESS, shop);
            }
            }catch (Exception e){
                throw new RuntimeException("modifyShop error :"+e.getMessage());
            }
        }
    }


    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }

}
