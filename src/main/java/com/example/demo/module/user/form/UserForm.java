package com.example.demo.module.user.form;

import lombok.Data;

/**
 * @program: kaptcha
 * @description: 登录参数
 * @author: wangdong
 * @create: 2020-11-19 14:59
 **/
@Data
public class UserForm {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String captcha;

}
