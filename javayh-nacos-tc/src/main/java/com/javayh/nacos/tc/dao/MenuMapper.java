package com.javayh.nacos.tc.dao;

import com.javayh.nacos.common.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.conf.mapper → MenuMapper
 * @Description 菜单
 * @Author Dylan
 * @Date 2019/10/30 13:48
 * @Version
 */
@Mapper
public interface MenuMapper {

    SysMenu findMenu(String menuName);
}
