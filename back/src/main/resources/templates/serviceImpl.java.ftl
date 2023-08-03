package ${package.ServiceImpl};

import cn.hutool.core.bean.BeanUtil;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ${package.Other}.${entity}Request;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public  IPage<${entity}> findPage(${entity}Request ${entity?uncap_first}Request){
        IPage<${entity}> wherePage = new Page<>(${entity?uncap_first}Request.getPage(), ${entity?uncap_first}Request.getPageCount());
        ${entity} where = new ${entity}();
        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(${entity}Request ${entity?uncap_first}Request){
        ${entity} ${entity?uncap_first} = new ${entity}();
        BeanUtil.copyProperties(${entity?uncap_first}Request, ${entity?uncap_first});
        return baseMapper.insert(${entity?uncap_first});
    }

    @Override
    public int delete(${entity}Request ${entity?uncap_first}Request){
        return baseMapper.deleteById(${entity?uncap_first}Request.getId());
    }

    @Override
    public int updateData(${entity}Request ${entity?uncap_first}Request){
        ${entity} ${entity?uncap_first} = new ${entity}();
        BeanUtil.copyProperties(${entity?uncap_first}Request, ${entity?uncap_first});
        return baseMapper.updateById(${entity?uncap_first});
    }

    @Override
    public ${entity} findById(${entity}Request ${entity?uncap_first}Request){
        return  baseMapper.selectById(${entity?uncap_first}Request.getId());
    }
}
</#if>
