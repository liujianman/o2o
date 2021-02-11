package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 12:15 2018/1/4
 */
public interface ShopDao {

    /** 
    * @Description:  分页查询店铺,可输入的条件有：店铺名（模糊），店铺状态，店铺Id,店铺类别,区域ID
    * @Param: shopCondition rowIndex(第几行开始取) pageSize（返回的条数）
    * @return:  
    * @Author: ljm
    * @Date: 2018/2/27 
    */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

     /**
      * 返回queryShopList总数
      * @author ljm
      * @date 2018/3/1 23:48
      * @param   shopCondition
      * @return
      */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
    
  /**
   * @author ljm
   * @date 2018/3/1 23:53
   * @param  shopId
   * @return
   */
    Shop queryByShopId(long shopId);

     /**
      * @author ljm
      * @date 2018/3/1 23:53
      * @param  shop
      * @return
      */
    int insertShop(Shop shop);

  /**
   * @author ljm
   * @date 2018/3/1 23:53
   * @param   shop
   * @return
   */
    int updateShop(Shop shop);
}
