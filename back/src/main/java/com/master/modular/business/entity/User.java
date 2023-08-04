package com.master.modular.business.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.master.modular.business.base.entity.BaseEntity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
@Getter
@Setter
@TableName("user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 帐号有效期
     */
    @TableField("valid_date")
    private LocalDateTime validDate;

    /**
     * 头像，存的为文件id
     */
    @TableField("avatar")
    private Long avatar;

    /**
     * 生日
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 性别：M-男，F-女
     */
    @TableField("sex")
    private String sex;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 是否是超级管理员：Y-是，N-否
     */
    @TableField("super_admin_flag")
    private String superAdminFlag;

    /**
     * 状态：1-正常，2-冻结
     */
    @TableField("status_flag")
    private Integer statusFlag;

    /**
     * 最后登陆IP
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 删除标记：Y-已删除，N-未删除
     */
    @TableField("del_flag")
    private String delFlag;


}
