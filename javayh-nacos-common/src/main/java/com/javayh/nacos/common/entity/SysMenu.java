package com.javayh.nacos.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName javayh-distribution → com.javayh.conf.entity → SysMenu
 * @Description 菜单
 * @Author Dylan
 * @Date 2019/10/30 13:20
 * @Version
 */
@Data
public class SysMenu implements Serializable {

    private long id;
    private Integer pid;
    private String menuName;
    private String description;
    private String url;

}
