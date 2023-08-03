package com.master.modular.business.controller;

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.master.modular.business.base.response.*;
import com.master.modular.business.service.IRoleService;
import com.master.modular.business.pojo.request.RoleRequest;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
@Slf4j
@RestController
public class RoleController {

    @Resource
    private IRoleService roleService;

    @PostMapping()
    public ResponseResult add(@RequestBody RoleRequest roleRequest){
        roleService.add(roleRequest);
        return new ResponseResult();
    }

    @DeleteMapping()
    public ResponseResult delete(@RequestBody RoleRequest roleRequest){
        roleService.delete(roleRequest);
        return new ResponseResult();
    }

    @PutMapping()
    public ResponseResult update(@RequestBody RoleRequest roleRequest){
        roleService.updateData(roleRequest);
        return new ResponseResult();
    }

    @GetMapping()
    public ResponseResult findPage(@RequestBody RoleRequest roleRequest){
        return new ResponseResult(roleService.findPage(roleRequest));
    }

    @GetMapping()
    public ResponseResult findById(@RequestBody RoleRequest roleRequest){
        return new ResponseResult(roleService.findById(roleRequest));
    }

}
