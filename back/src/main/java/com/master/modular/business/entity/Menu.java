package com.master.modular.business.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.master.modular.business.base.entity.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
@Getter
@Setter
@TableName("menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 父id，顶级节点的父id是-1
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 应用编码
     */
    @TableField("app_code")
    private String appCode;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 状态：1-启用，2-禁用
     */
    @TableField("status_flag")
    private Integer statusFlag;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 菜单的路径
     */
    @TableField("layui_path")
    private String layuiPath;

    /**
     * 菜单的图标，适用于layui-beetl版本
     */
    @TableField("layui_icon")
    private String layuiIcon;

    /**
     * 是否可见Y-是，N-否
     */
    @TableField("visible")
    private String visible;

    /**
     * 前端name
     */
    @TableField("front_name")
    private String frontName;

    /**
     * 前端path
     */
    @TableField("front_path")
    private String frontPath;

    /**
     * 前端component
     */
    @TableField("front_component")
    private String frontComponent;

    /**
     * 外链地址
     */
    @TableField("front_link_url")
    private String frontLinkUrl;

    /**
     * 外部链接打开方式：1-内置打开外链，2-新页面外链，适用于antdvue版本
     */
    @TableField("open_type")
    private Integer openType;

    /**
     * 是否删除：Y-被删除，N-未删除
     */
    @TableField("del_flag")
    private String delFlag;


}
