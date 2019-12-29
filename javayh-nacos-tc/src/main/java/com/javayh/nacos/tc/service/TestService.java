package com.javayh.nacos.tc.service;

import com.javayh.nacos.common.entity.SysMenu;
import com.javayh.nacos.common.entity.SysUser;
import com.javayh.nacos.tc.dao.MenuMapper;
import com.javayh.nacos.tc.dao.UserMapper;
import com.javayh.nacos.tc.db.constant.DataSourceKey;
import com.javayh.nacos.tc.db.util.DataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName javayh-cloud-nacos → com.javayh.nacos.tc.service → TestService
 * @Description  多数据源测试
 * @Author Dylan
 * @Date 2019/12/29 14:38
 * @Version
 */
@Slf4j
@Service
public class TestService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    public void get(){
        DataSourceHolder.setDataSourceKey(DataSourceKey.core);
        SysMenu sysMenu = menuMapper.findMenu("用户管理界面");
        DataSourceHolder.setDataSourceKey(DataSourceKey.core);
        SysUser sysUser = userMapper.selectUserByName("admin");
        log.info("sysMenu ={}",sysMenu);
        log.info("sysUser ={}",sysUser);
    }
}
