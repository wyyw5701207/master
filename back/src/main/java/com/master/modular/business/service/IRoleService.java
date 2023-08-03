package com.master.modular.business.service;

import com.master.modular.business.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.master.modular.business.pojo.request.RoleRequest;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询角色分页数据
     */
    IPage<Role> findPage(RoleRequest roleRequest);

    /**
     * 添加角色
     */
    int add(RoleRequest roleRequest);

    /**
     * 删除角色
     */
    int delete(RoleRequest roleRequest);

    /**
     * 修改角色
     */
    int updateData(RoleRequest roleRequest);

    /**
     * id查询数据
     */
    Role findById(RoleRequest roleRequest);
}
