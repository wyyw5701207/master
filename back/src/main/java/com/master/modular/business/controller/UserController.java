package com.master.modular.business.controller;

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.master.modular.business.base.response.*;
import com.master.modular.business.service.IUserService;
import com.master.modular.business.pojo.request.UserRequest;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping()
    public ResponseResult add(@RequestBody UserRequest userRequest){
        userService.add(userRequest);
        return new ResponseResult();
    }

    @DeleteMapping()
    public ResponseResult delete(@RequestBody UserRequest userRequest){
        userService.delete(userRequest);
        return new ResponseResult();
    }

    @PutMapping()
    public ResponseResult update(@RequestBody UserRequest userRequest){
        userService.updateData(userRequest);
        return new ResponseResult();
    }

    @GetMapping()
    public ResponseResult findPage(@RequestBody UserRequest userRequest){
        return new ResponseResult(userService.findPage(userRequest));
    }

    @GetMapping()
    public ResponseResult findById(@RequestBody UserRequest userRequest){
        return new ResponseResult(userService.findById(userRequest));
    }

}
