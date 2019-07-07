package com.xyh.mybatis.mapper;

import com.xyh.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author xuyh
 * @date 2019/7/2
 */
public interface UserMapper {
    User getOne(Integer id);

    @Select("select  *  from user where id=#{id}")
    User selectOne(Integer id);

    int insert(User user);
}
