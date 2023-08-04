package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.master.modular.business.base.response.*;
import ${package.Service}.${table.serviceName};
import ${package.Other}.${entity}Request;
import javax.annotation.Resource;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    @PostMapping()
    public ResponseResult add(@RequestBody ${entity}Request ${entity?uncap_first}Request){
        ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first}Request);
        return new SuccessResult();
    }

    @DeleteMapping()
    public ResponseResult delete(@RequestBody ${entity}Request ${entity?uncap_first}Request){
        ${(table.serviceName?substring(1))?uncap_first}.delete(${entity?uncap_first}Request);
        return new SuccessResult();
    }

    @PutMapping()
    public ResponseResult update(@RequestBody ${entity}Request ${entity?uncap_first}Request){
        ${(table.serviceName?substring(1))?uncap_first}.updateData(${entity?uncap_first}Request);
        return new SuccessResult();
    }

    @GetMapping()
    public ResponseResult findPage(@RequestBody ${entity}Request ${entity?uncap_first}Request){
        return new SuccessResult(${(table.serviceName?substring(1))?uncap_first}.findPage(${entity?uncap_first}Request));
    }

    @GetMapping()
    public ResponseResult findById(@RequestBody ${entity}Request ${entity?uncap_first}Request){
        return new SuccessResult(${(table.serviceName?substring(1))?uncap_first}.findById(${entity?uncap_first}Request));
    }

}
</#if>