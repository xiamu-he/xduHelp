package com.qinghuo.xduHelp.service;

import com.qinghuo.xduHelp.exception.result.Result;
import com.qinghuo.xduHelp.exception.statusCode.GlobalCodeEnum;
import com.qinghuo.xduHelp.model.vo.PersonalInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qinghuo.xduHelp.mapper.UserMapper;
import com.qinghuo.xduHelp.model.domain.User;
/**
@author qzx
@create 2022-02-17 17:53
@function
*/
@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public Result getPersonalInfo(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            return Result.error(GlobalCodeEnum.USER_NOT_EXIST);
        }
        PersonalInfoVO personalInfoVO= new PersonalInfoVO();
        BeanUtils.copyProperties(user,personalInfoVO);
        return Result.success(personalInfoVO);
    }
}
