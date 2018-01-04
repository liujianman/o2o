package com.kgy.o2o.entity;

import java.util.Date;

/**
 * Created by ljm on 2018/1/3.
 */
public class ProductCategory {
    //商品类别ID
    private Long productCategoryId;
    //商店ID
    private Long shopId;
    //商品类别名称
    private String productCategoryName;
    //商品类别权重
    private Integer priority;
    //商品类别创建时间
    private Date createTime;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}