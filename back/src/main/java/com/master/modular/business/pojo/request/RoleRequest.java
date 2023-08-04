package com.master.modular.business.pojo.request;
import com.master.modular.business.base.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
@Getter
@Setter
public class RoleRequest extends BaseRequest{
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;


}
