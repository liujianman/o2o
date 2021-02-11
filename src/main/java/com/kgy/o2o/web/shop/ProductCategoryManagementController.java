package com.kgy.o2o.web.shop;

import com.kgy.o2o.dto.ProductCategoryExecution;
import com.kgy.o2o.entity.ProductCategory;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.enums.ProductCategoryStateEnum;
import com.kgy.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: o2o
 * @description:
 * @author: ljm
 * @create: 2018-03-13 22:40
 **/
@Controller
@RequestMapping("/shop")
public class ProductCategoryManagementController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProductCategorys(
            HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Shop currentShop = (Shop) request.getSession().getAttribute(
                "currentShop");
        List<ProductCategory> list = null;
        if (currentShop != null && currentShop.getShopId() > 0) {
            list = productCategoryService.getProductCategoryList(currentShop.getShopId());
            modelMap.put("success", true);
            modelMap.put("productcategorylist", list);
            return modelMap;
        } else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            modelMap.put("success", false);
            modelMap.put("State", ps.getState());
            return modelMap;
        }
    }
        @RequestMapping(value = "/addproductcategorys", method = RequestMethod.POST)
        @ResponseBody
        private Map<String, Object> addProductCategorys(
                @RequestBody List<ProductCategory> productCategoryList,
                HttpServletRequest request) {
            Map<String, Object> modelMap = new HashMap<String, Object>();
            Shop currentShop = (Shop) request.getSession().getAttribute(
                    "currentShop");
            for (ProductCategory pc : productCategoryList) {
                pc.setShopId(currentShop.getShopId());
            }
            if (productCategoryList != null && productCategoryList.size() > 0) {
                try {
                    ProductCategoryExecution pe = productCategoryService
                            .batchAddProductCategory(productCategoryList);
                    if (pe.getState() == ProductCategoryStateEnum.SUCCESS
                            .getState()) {
                        modelMap.put("success", true);
                    } else {
                        modelMap.put("success", false);
                        modelMap.put("errMsg", pe.getStateInfo());
                    }
                } catch (RuntimeException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.toString());
                    return modelMap;
                }

            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "请至少输入一个商品类别");
            }
            return modelMap;
        }

        @RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
        @ResponseBody
        private Map<String, Object> removeProductCategory(Long productCategoryId,
                HttpServletRequest request) {
            Map<String, Object> modelMap = new HashMap<String, Object>();
            if (productCategoryId != null && productCategoryId > 0) {
                try {
                    Shop currentShop = (Shop) request.getSession().getAttribute(
                            "currentShop");
                    ProductCategoryExecution pe = productCategoryService
                            .deleteProductCategory(productCategoryId,
                                    currentShop.getShopId());
                    if (pe.getState() == ProductCategoryStateEnum.SUCCESS
                            .getState()) {
                        modelMap.put("success", true);
                    } else {
                        modelMap.put("success", false);
                        modelMap.put("errMsg", pe.getStateInfo());
                    }
                } catch (RuntimeException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.toString());
                    return modelMap;
                }

            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "请至少选择一个商品类别");
            }
            return modelMap;
        }

    }

