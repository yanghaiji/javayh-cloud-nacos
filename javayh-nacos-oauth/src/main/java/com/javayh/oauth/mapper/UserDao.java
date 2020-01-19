package com.javayh.oauth.mapper;

import com.javayh.oauth.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yang HaiJi, 2019-05-17
 * @version Araf v1.0
 */
@Mapper
public interface UserDao {
    /**
     * 根据名字查询
     * @param username
     * @return
     */
    SysUserVO findByUserName(String username);

}
