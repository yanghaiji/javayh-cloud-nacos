package com.javayh.nacos.tc.dao;


import com.javayh.nacos.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * @Description 获取角色id
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     * @param userName
     * @return java.util.List<java.lang.String>
     */
	SysUser selectUserByName(String userName);

}
