package com.master.modular.business.service;

import com.master.modular.business.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.master.modular.business.pojo.request.UserRequest;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author wangyue
 * @since 2023-08-04
 */
public interface IUserService extends IService<User> {

    /**
     * 查询用户分页数据
     */
    IPage<User> findPage(UserRequest userRequest);

    /**
     * 添加用户
     */
    int add(UserRequest userRequest);

    /**
     * 删除用户
     */
    int delete(UserRequest userRequest);

    /**
     * 修改用户
     */
    int updateData(UserRequest userRequest);

    /**
     * id查询数据
     */
    User findById(UserRequest userRequest);
}
