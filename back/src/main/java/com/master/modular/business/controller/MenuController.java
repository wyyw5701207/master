package com.master.modular.business.controller;

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.master.modular.business.base.response.*;
import com.master.modular.business.service.IMenuService;
import com.master.modular.business.pojo.request.MenuRequest;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author wangyue
 * @since 2023-08-03
 */
@Slf4j
@RestController
public class MenuController {

    @Resource
    private IMenuService menuService;

    @PostMapping()
    public ResponseResult add(@RequestBody MenuRequest menuRequest){
        menuService.add(menuRequest);
        return new ResponseResult();
    }

    @DeleteMapping()
    public ResponseResult delete(@RequestBody MenuRequest menuRequest){
        menuService.delete(menuRequest);
        return new ResponseResult();
    }

    @PutMapping()
    public ResponseResult update(@RequestBody MenuRequest menuRequest){
        menuService.updateData(menuRequest);
        return new ResponseResult();
    }

    @GetMapping()
    public ResponseResult findPage(@RequestBody MenuRequest menuRequest){
        return new ResponseResult(menuService.findPage(menuRequest));
    }

    @GetMapping()
    public ResponseResult findById(@RequestBody MenuRequest menuRequest){
        return new ResponseResult(menuService.findById(menuRequest));
    }

}
