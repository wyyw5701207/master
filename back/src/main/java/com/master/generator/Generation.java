//package com.master.generator;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.sql.Types;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author wangyue
// * @date 2023/8/2
// */
//
///**
// * 1.配置数据源-直接连接数据库，通过解析表自动创建 entity mapper controller service等类
// * 2.配置全局参数-指定文件位置
// * 3.配置包参数-指定包路径
// * 4.配置模板参数-指定模板路径
// * 5.配置策略参数-指定哪些表进行代码生成 其他配置
// * 6.配置注入参数-配置与模板交互的自定义参数,作为拓展
// */
//public class Generation {
//    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir"); //获取项目路径
//        String filePath = projectPath + "/src/main/java";  //java下的文件路径
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/wy_master", "root", "123456")
//                //全局配置
//                .globalConfig(builder -> {
//                    builder.author("wangyue") // 设置作者
////                            .enableSwagger() // 开启 swagger 模式
//                            .outputDir(filePath); // 指定输出目录
//                })
//                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.SMALLINT) {
//                        // 自定义类型转换
//                        return DbColumnType.INTEGER;
//                    }
//                    return typeRegistry.getColumnType(metaInfo);
//
//                }))
//                //包配置
//                .packageConfig(builder -> {
//                    builder.parent("com.master")//父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
//                            .moduleName("base") // 设置父包模块名
//                            .entity("entity")//实体类包名
//                            .controller("controller")//控制层包名
//                            .mapper("mapper")//mapper层包名
//                            .xml("mapper.xml")//数据访问层xml包名
//                            .service("service")//service层包名
//                            .serviceImpl("service.impl");//service实现类包名
//                })
//                .templateConfig(builder -> {
//                    builder
//                            .entity("/templates/entity.java")
//                            .service("/templates/service.java")
//                            .serviceImpl("/templates/serviceImpl.java")
//                            .mapper("/templates/mapper.java")
//                            .xml("/templates/mapper.xml")
//                            .controller("/templates/controller.java").build();
//                })
//                //策略配置
//                .strategyConfig(builder -> {
//                    //基类有的字段,忽略掉
//                    builder.entityBuilder().addIgnoreColumns("create_time","create_user","update_time","update_user")
//                            //使用Lombok表达式
//                            .enableLombok()
//                            .enableTableFieldAnnotation()
//                            //继承基类
//                            .superClass(BaseEntity.class).build();
//                })
//                .injectionConfig(consumer -> {
//                    Map<String, String> customFile = new HashMap<>();
//                    // DTO 下面的key会作为类名后缀，进而生成新类
//                    customFile.put("Request.java", "templates/request/request.java.ftl");
//                    consumer.customFile(customFile);
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//    }
//}
