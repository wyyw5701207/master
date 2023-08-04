package com.master.modular.business.pojo.request;
import com.master.modular.business.base.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
@Getter
@Setter
public class MenuRequest extends BaseRequest{
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 父id，顶级节点的父id是-1
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 应用编码
     */
    private String appCode;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：1-启用，2-禁用
     */
    private Integer statusFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 菜单的路径
     */
    private String layuiPath;

    /**
     * 菜单的图标，适用于layui-beetl版本
     */
    private String layuiIcon;

    /**
     * 是否可见Y-是，N-否
     */
    private String visible;

    /**
     * 前端name
     */
    private String frontName;

    /**
     * 前端path
     */
    private String frontPath;

    /**
     * 前端component
     */
    private String frontComponent;

    /**
     * 外链地址
     */
    private String frontLinkUrl;

    /**
     * 外部链接打开方式：1-内置打开外链，2-新页面外链，适用于antdvue版本
     */
    private Integer openType;

    /**
     * 是否删除：Y-被删除，N-未删除
     */
    private String delFlag;


}
