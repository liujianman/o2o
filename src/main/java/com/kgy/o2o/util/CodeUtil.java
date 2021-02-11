package com.kgy.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 刘健明
 * @Description:CodeUtil
 * @Date: Created in 10:56 2018/1/11
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,
                "verifyCodeActual");

        if (verifyCodeActual == null
                || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}

