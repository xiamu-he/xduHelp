package com.qinghuo.xduHelp.mapper;

import com.qinghuo.xduHelp.model.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
@author qzx
@create 2022-02-17 17:53
@function
*/
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}