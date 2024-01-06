package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

@Service
// 需指定两个泛型, 一个是将要调用的mapper, 一个是实体
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {

}
