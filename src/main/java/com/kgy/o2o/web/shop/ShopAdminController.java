package com.kgy.o2o.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 刘健明
 * @Description:
 * @Date: Created in 10:41 2018/1/9
 */
@Controller
@RequestMapping(value = "shop", method = { RequestMethod.GET,
        RequestMethod.POST })
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }
}