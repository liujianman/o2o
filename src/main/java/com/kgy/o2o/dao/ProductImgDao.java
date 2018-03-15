package com.kgy.o2o.dao;

import java.util.List;

import com.kgy.o2o.entity.ProductImg;

public interface ProductImgDao {
	 /**
	  * 根据Id获取商品列表
	  * @date 2018/3/12 22:45
	  * @param   productId
	  * @return
	  */
	List<ProductImg> queryProductImgList(long productId);

	 /**
	  * 批量添加商品图片
	  * @date 2018/3/9 17:53
	  * @param   productImgList
	  * @return   productImgList
	  */
	int batchInsertProductImg(List<ProductImg> productImgList);


 /**
  * 根据ID删除商品
  * @date 2018/3/12 22:42
  * @param   productId
  * @return
  */
	int deleteProductImgByProductId(long productId);
}
