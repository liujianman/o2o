package com.kgy.o2o.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgy.o2o.dto.ShopExecution;
import com.kgy.o2o.entity.Area;
import com.kgy.o2o.entity.PersonInfo;
import com.kgy.o2o.entity.Shop;
import com.kgy.o2o.entity.ShopCategory;
import com.kgy.o2o.enums.ShopStateEnum;
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
import java.io.IOException;
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

    @RequestMapping(value = "getshopmanagementinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>getShopManagementInfo(HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String, Object>();
        long shopId =HttpServletRequestUtil.getLong(request,"shopId");
        if (shopId <=0){
            Object currentShopObj =request.getSession().getAttribute("currentShop");
            if (currentShopObj==null){
                modelMap.put("redirect",true);
                modelMap.put("url","shop/shoplist");
            }else {
                Shop currentShop= (Shop) currentShopObj;
                modelMap.put("redirect",false);
                modelMap.put("shopId",currentShop.getShopId());
            }
        }else {
            Shop currentShop =new Shop();
            currentShop.setShopId(shopId);
            request.getSession().setAttribute("currentShop",currentShop);
            modelMap.put("redirect",false);
        }
        return modelMap;
    }

     /**
      * @author ljm
      * 获取店铺集
      * @param
      * @return   modelmap
      */
    @RequestMapping(value = "/getshoplist",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        PersonInfo user = new PersonInfo();
        user.setUserId(1L);
        user.setName("test");
        request.getSession().setAttribute("user",user);
        user= (PersonInfo) request.getSession().getAttribute("user");
        try {
            Shop shopCondition =new Shop();
            shopCondition.setOwner(user);
            ShopExecution se =shopService.getShopList(shopCondition,0,100);
            modelMap.put("shopList",se.getShopList());
            modelMap.put("user",user);
            modelMap.put("success",true);
        }catch (Exception e){
          modelMap.put("success",false);
          modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }


    /**
     * 通过ID查询店铺信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getshopbyid",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>getShopById(HttpServletRequest request){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        Long shopId =HttpServletRequestUtil.getLong(request,"shopId");
        if (shopId >-1) {
            try {
                Shop shop = shopService.getByShopId(shopId);
                List<Area> areaList = areaService.getAreaList();
                modelMap.put("shop", shop);
                modelMap.put("areaList", areaList);
                modelMap.put("success", true);
            }catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("errorMsg",e.toString());
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errorMsg","empty shopId");
        }
        return modelMap;
    }


    /**
     * 修改shop信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifyshop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errorMsg", "输入了错误验证码");
            return modelMap;
        }
        //接受参数
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
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }

        //修改店铺信息
        if (shop != null && shop.getShopId() != null) {
            ShopExecution se;
            try {
                if (shopImg == null) {
                    se = shopService.modifyShop(shop, null);
                } else {
                    se = shopService.modifyShop(shop, shopImg);
                }
                if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errorMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errorMsg", e.getMessage());
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errorMsg", "请输入店铺ID");
            return modelMap;
        }
    }


    /**
     * 获取店铺信息
     * @return
     */
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

    /**
     * 店铺信息注册
     * @param request
     * @return
     */
    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

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
                PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
                shop.setOwner(owner);
                ShopExecution se;
                try{
                    se=shopService.addShop(shop,shopImg);
                    if (se.getState()==ShopStateEnum.CHECK.getState()){
                        modelMap.put("success",true);
                        //用户可以操作的店铺
                        @SuppressWarnings("unchecked")
                        List<Shop>shopList = (List<Shop>) request.getSession().getAttribute("shopList");
                        if (shopList==null ||shopList.size()==0){
                            shopList =new ArrayList<Shop>();
                        }
                        shopList.add(se.getShop());
                        request.getSession().setAttribute("shopList",shopList);
                    }else{
                        modelMap.put("success", false);
                        modelMap.put("errMsg", se.getStateInfo());
                    }
                }catch (RuntimeException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.toString());
                    return modelMap;
                }

        }else {
            modelMap.put("success",false);
            modelMap.put("errorMsg","请输入信息");
            return modelMap;
        }
        //返回数据
        return modelMap;
    }

}
