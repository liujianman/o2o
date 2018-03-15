package com.kgy.o2o.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kgy.o2o.dto.ProductExecution;
import com.kgy.o2o.entity.Product;

public interface ProductService {
	 /**
	  * 分页获得商品列表信息，
	  * @date 2018/3/11 2:07
	  * @param   productCondition pageIndex pageSize
	  * @return
	  */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	 /**
	  * 用过商品Id查询商品信息
	  * @date 2018/3/11 2:09
	  * @param   productId
	  * @return
	  */
	Product getProductById(long productId);

	/**
	 * 增加商品
	 * @date 2018/3/10 10:04
	 * @param
	 * @return
	 */
	ProductExecution addProduct(Product product, CommonsMultipartFile thumbnail, List<CommonsMultipartFile> productImgs)
			throws RuntimeException;

	 /**
	  * 修改商品信息
	  * @date 2018/3/11 2:06
	  * @param   product thumbnail productImgs
	  * @return
	  */
	ProductExecution modifyProduct(Product product, CommonsMultipartFile thumbnail,
                                   List<CommonsMultipartFile> productImgs) throws RuntimeException;
}
