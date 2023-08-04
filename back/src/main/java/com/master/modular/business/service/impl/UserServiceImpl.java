package com.master.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.master.modular.business.entity.User;
import com.master.modular.business.mapper.UserMapper;
import com.master.modular.business.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.master.modular.business.pojo.request.UserRequest;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public  IPage<User> findPage(UserRequest userRequest){
        IPage<User> wherePage = new Page<>(userRequest.getPage(), userRequest.getPageCount());
        User where = new User();
        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserRequest userRequest){
        User user = new User();
        BeanUtil.copyProperties(userRequest, user);
        return baseMapper.insert(user);
    }

    @Override
    public int delete(UserRequest userRequest){
        return baseMapper.deleteById(userRequest.getId());
    }

    @Override
    public int updateData(UserRequest userRequest){
        User user = new User();
        BeanUtil.copyProperties(userRequest, user);
        return baseMapper.updateById(user);
    }

    @Override
    public User findById(UserRequest userRequest){
        return  baseMapper.selectById(userRequest.getId());
    }
}
