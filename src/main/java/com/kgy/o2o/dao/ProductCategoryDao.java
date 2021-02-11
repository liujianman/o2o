package com.kgy.o2o.dao;

import com.kgy.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    /**
      * 通过shopId 查询店铺
      * @date 2018/3/6 21:48
      * @param   shopId
      * @return List<ProductCategory>
      */
    List<ProductCategory>queryProductCategoryList(long shopId);

     /**
      * 新增商品类别
      * @date 2018/3/8 17:38
      * @param   productCategoryList
      * @return
      */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);


     /**
      * 删除店铺类别
      * @date 2018/3/9 0:05
      * @param   productCategoryId shopId
      * @return   ProductCategory
      */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId,@Param("shopId")long shopId);

}
