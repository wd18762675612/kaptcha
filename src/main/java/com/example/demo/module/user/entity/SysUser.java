package com.example.demo.module.user.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangdong
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id 作为表主键 用于关联
     */
    private String userId;

    /**
     * 用户登录帐号
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 备注，预留字段
     */
    private String userRemarks;


}
