package com.master.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.master.modular.business.base.entity.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyue
 * @date 2023/8/2
 */

/**
 * 1.配置数据源-直接连接数据库，通过解析表自动创建 entity mapper controller service等类
 * 2.配置全局参数-指定文件位置
 * 3.配置包参数-指定包路径
 * 4.配置模板参数-指定模板路径
 * 5.配置策略参数-指定哪些表进行代码生成 其他配置
 * 6.配置注入参数-配置与模板交互的自定义参数,作为拓展
 */
public class CodeGeneration {
    public static void main(String[] args) {
        // 定位
        String finalProjectPath = System.getProperty("user.dir");
        System.out.println(finalProjectPath);

        // 执行
        FastAutoGenerator
                .create("jdbc:mysql://localhost:3306/wy_master?useUnicode=true&characterEncoding=UTF-8", "root", "123456")
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("wangyue")
                            // 开启 swagger 模式
//                            .fileOverride().enableSwagger()
                            //禁止打开输出目录
                            .disableOpenDir()
                            // 指定输出目录
                            .outputDir(finalProjectPath + "/src/main/java");
                })
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.master")
                            .other("modular.business.pojo.request")
                            .entity("modular.business.entity")
                            .controller("modular.business.controller")
                            .service("modular.business.service")
                            .serviceImpl("modular.business.service.impl")
                            .mapper("modular.business.mapper")//mapper层包名
                            .xml("modular.business.mapper.xml")//数据访问层xml包名
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, finalProjectPath + "/src/main/resources"));
                })
                .strategyConfig(builder -> {
                    //基类有的字段,忽略掉
                    builder.entityBuilder().addIgnoreColumns("create_time", "create_user", "update_time", "update_user")
                            //使用Lombok表达式
                            .enableLombok()
                            //开启注解
                            .enableTableFieldAnnotation()
                            //继承基类
                            .superClass(BaseEntity.class);
                    // 需要被解析的表名
//                  builder.addInclude("auth_permission");
                    builder.controllerBuilder().enableRestStyle();
                    // 要生成的表，不写为全部
//                  builder.addInclude("表名");
                })
                .injectionConfig(consumer -> {
                    Map<String, String> customFile = new HashMap<>();
                    // DTO 下面的key会作为类名后缀，进而生成新类
                    customFile.put("Request.java", "templates/request.java.ftl");
                    consumer.customFile(customFile);
                })
                // EnhanceFreemarkerTemplateEngine 里主要重写对自定义类的处理 如vo dto convert等
                .templateEngine(new EnhanceFreemarkerTemplateEngine()).execute();
    }
}
