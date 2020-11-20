package com.example.demo.module.user.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.module.user.entity.SysUser;
import com.example.demo.module.user.form.UserForm;
import com.example.demo.module.user.service.ISysUserService;
import com.example.demo.utils.KaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangdong
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @PostMapping("/login")
    public String user(@RequestBody UserForm user, HttpServletRequest request) {
        if (StrUtil.isNotBlank(user.getUsername()) && StrUtil.isNotBlank(user.getPassword())) {
            SysUser userName = userService.getOne(new QueryWrapper<SysUser>().eq("user_name", user.getUsername()).eq("password", user.getPassword()));
            if (ObjectUtil.isNotNull(userName)) {
                if (!KaptchaUtil.checkVerifyCode(request, user.getCaptcha())) {
                    return "验证码有误！";
                } else {
                    return "用户存在,验证码正确";
                }
            } else {
                return "该用户不存在或密码不正确";
            }
        } else {
            return "用户名或密码不能为空";
        }
    }

}
