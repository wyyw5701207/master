package com.master.modular.business.service;

import com.master.modular.business.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.master.modular.business.pojo.request.MenuRequest;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询菜单分页数据
     */
    IPage<Menu> findPage(MenuRequest menuRequest);

    /**
     * 添加菜单
     */
    int add(MenuRequest menuRequest);

    /**
     * 删除菜单
     */
    int delete(MenuRequest menuRequest);

    /**
     * 修改菜单
     */
    int updateData(MenuRequest menuRequest);

    /**
     * id查询数据
     */
    Menu findById(MenuRequest menuRequest);
}
