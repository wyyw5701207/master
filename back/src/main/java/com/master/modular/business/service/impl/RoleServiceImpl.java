package com.master.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.master.modular.business.entity.Role;
import com.master.modular.business.mapper.RoleMapper;
import com.master.modular.business.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.master.modular.business.pojo.request.RoleRequest;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public  IPage<Role> findPage(RoleRequest roleRequest){
        IPage<Role> wherePage = new Page<>(roleRequest.getPage(), roleRequest.getPageCount());
        Role where = new Role();
        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RoleRequest roleRequest){
        Role role = new Role();
        BeanUtil.copyProperties(roleRequest, role);
        return baseMapper.insert(role);
    }

    @Override
    public int delete(RoleRequest roleRequest){
        return baseMapper.deleteById(roleRequest.getId());
    }

    @Override
    public int updateData(RoleRequest roleRequest){
        Role role = new Role();
        BeanUtil.copyProperties(roleRequest, role);
        return baseMapper.updateById(role);
    }

    @Override
    public Role findById(RoleRequest roleRequest){
        return  baseMapper.selectById(roleRequest.getId());
    }
}
