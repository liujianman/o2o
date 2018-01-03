package com.kgy.o2o.entity;

import java.util.Date;

/**
 * Created by ljm on 2018/1/3.
 */
public class ProductImg {
    //商品图片ID
    private Long productImgId;
    //商品图片地址
    private String imgAddr;
    //商品图片描述
    private String imgDesc;
    //商品图片权重
    private Integer priority;
    //商品图片创建时间
    private Date createTime;
    //商品图片所属商品ID
    private Long productId;

    public Long getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Long productImgId) {
        this.productImgId = productImgId;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
