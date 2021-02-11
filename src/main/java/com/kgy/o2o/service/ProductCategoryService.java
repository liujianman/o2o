package com.kgy.o2o.service;

import com.kgy.o2o.dto.ProductCategoryExecution;
import com.kgy.o2o.entity.ProductCategory;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: ljm
 * @create: 2018-03-06 23:16
 **/
public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param long shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> getProductCategoryList(long shopId);

     /**
      * add ProductCategory
      * @date 2018/3/8 18:59
      * @param   ProductCategory
      * @return   ProductCategoryExecution
      */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)throws RuntimeException;

     /**
      *deleteProductCategory
      * @date 2018/3/9 0:32
      * @param  productCategoryId  shopId
      * @return   ProductCategoryExecution
      */
    ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)throws RuntimeException;
}
