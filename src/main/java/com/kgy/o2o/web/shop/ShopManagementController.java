package com.kgy.o2o.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgy.o2o.dto.ShopExecution;
import com.kgy.o2o.entity.Area;
import com.kgy.o2o.entity.PersonInfo;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.entity.ShopCategory;
import com.kgy.o2o.service.AreaService;
import com.kgy.o2o.service.ShopCategoryService;
import com.kgy.o2o.service.ShopService;

import com.kgy.o2o.util.CodeUtil;
import com.kgy.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 10:02 2018/1/9
 */
@Controller
@RequestMapping("shop")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>getShopinitInfo(){
        Map<String,Object>modelMap = new HashMap<String, Object>();
        List<ShopCategory>shopCategoryList =new ArrayList<ShopCategory>();
        List<Area>areaList =new ArrayList<Area>();
        try {
            shopCategoryList=shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList=areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errorMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

     //System.out.println("验证码："+HttpServletRequestUtil.getString(request,"verifyCodeActual"));
        if (!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errorMsg","输入了错误验证码");
            return modelMap;
        }

        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errorMsg", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile shopImg =null;
        CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errorMsg","上传图片失败");
            return modelMap;
        }

        if (shop!=null&&shopImg!=null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution se=shopService.addShop(shop,shopImg);
        }else {
            modelMap.put("success",false);
            modelMap.put("errorMsg","请输入信息");
            return modelMap;
        }
        //返回数据
        return modelMap;
    }

}
