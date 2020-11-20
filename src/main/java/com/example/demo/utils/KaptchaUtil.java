package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: kaptcha
 * @description: 验证码工具
 * @author: wangdong
 * @create: 2020-11-18 14:10
 **/
public class KaptchaUtil {

    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request,String captcha) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
        if(captcha == null ||!captcha.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }

}
