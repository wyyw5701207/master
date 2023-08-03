package com.master.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.master.modular.business.entity.Menu;
import com.master.modular.business.mapper.MenuMapper;
import com.master.modular.business.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.master.modular.business.pojo.request.MenuRequest;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public  IPage<Menu> findPage(MenuRequest menuRequest){
        IPage<Menu> wherePage = new Page<>(menuRequest.getPage(), menuRequest.getPageCount());
        Menu where = new Menu();
        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MenuRequest menuRequest){
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuRequest, menu);
        return baseMapper.insert(menu);
    }

    @Override
    public int delete(MenuRequest menuRequest){
        return baseMapper.deleteById(menuRequest.getId());
    }

    @Override
    public int updateData(MenuRequest menuRequest){
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuRequest, menu);
        return baseMapper.updateById(menu);
    }

    @Override
    public Menu findById(MenuRequest menuRequest){
        return  baseMapper.selectById(menuRequest.getId());
    }
}
