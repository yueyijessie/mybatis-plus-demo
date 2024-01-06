package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 继承需要指定实体类
public interface UserMapper extends BaseMapper<User> {


    // 添加 @Param(Constants.WRAPPER), 固定的, 不会更改
    // 添加 @Param("amount"), 按照业务逻辑写
    void updateBalanceByIds(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, @Param("amount") int amount);
}
