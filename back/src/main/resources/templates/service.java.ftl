package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Other}.${entity}Request;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     */
    IPage<${entity}> findPage(${entity}Request ${entity?uncap_first}Request);

    /**
     * 添加${table.comment!}
     */
    int add(${entity}Request ${entity?uncap_first}Request);

    /**
     * 删除${table.comment!}
     */
    int delete(${entity}Request ${entity?uncap_first}Request);

    /**
     * 修改${table.comment!}
     */
    int updateData(${entity}Request ${entity?uncap_first}Request);

    /**
     * id查询数据
     */
    ${entity} findById(${entity}Request ${entity?uncap_first}Request);
}
</#if>
