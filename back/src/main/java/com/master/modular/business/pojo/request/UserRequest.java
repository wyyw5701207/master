package com.master.modular.business.pojo.request;
import com.master.modular.business.base.request.BaseRequest;
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
public class UserRequest extends BaseRequest{
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号有效期
     */
    private LocalDateTime validDate;

    /**
     * 头像，存的为文件id
     */
    private Long avatar;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 性别：M-男，F-女
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 电话
     */
    private String tel;

    /**
     * 是否是超级管理员：Y-是，N-否
     */
    private String superAdminFlag;

    /**
     * 状态：1-正常，2-冻结
     */
    private Integer statusFlag;

    /**
     * 最后登陆IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 删除标记：Y-已删除，N-未删除
     */
    private String delFlag;


}
