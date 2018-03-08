package com.kgy.o2o.service.impl;

import com.kgy.o2o.dao.ProductCategoryDao;
import com.kgy.o2o.dto.ProductCategoryExecution;
import com.kgy.o2o.entity.ProductCategory;
import com.kgy.o2o.enums.ProductCategoryStateEnum;
import com.kgy.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: o2o
 * @description: ProductCategoryService实现类
 * @author: ljm
 * @create: 2018-03-06 23:20
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws RuntimeException {
        if (productCategoryList!=null&& productCategoryList.size()>0){
            try {
            int effectNum =productCategoryDao.batchInsertProductCategory(productCategoryList);
            if (effectNum <=0){
                throw new RuntimeException("店铺类别创建失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }catch (Exception e){
                throw  new RuntimeException("错误："+ e.getMessage());
            }
        }else {
         return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws RuntimeException {
        try {
           int eddectedNum =productCategoryDao.deleteProductCategory(productCategoryId,shopId);
           if (eddectedNum<=0){
               throw new RuntimeException("商品类别删除失败");
           }else {
               return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
           }
        }catch (Exception e){
            throw new RuntimeException("deleteProductCategory errMsg"+e.getMessage());
        }
    }
}
