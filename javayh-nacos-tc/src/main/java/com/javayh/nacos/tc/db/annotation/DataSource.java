package com.javayh.nacos.tc.db.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName javayh-cloud-nacos → com.javayh.nacos.tc.db.annotation → DataSource
 * @Description 数据源注解
 * @Author Dylan
 * @Date 2019/12/29 14:19
 * @Version
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    //数据库名称
    String name();
}