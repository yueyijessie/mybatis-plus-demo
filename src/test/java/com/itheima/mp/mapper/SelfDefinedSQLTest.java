package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SelfDefinedSQLTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testUpdateQuery(){
        // 前端传递的更新条件
        List<Long> ids = List.of(1L, 2L, 4L);
        int amount = 200;
        // 定义条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>().in("id", ids);
        // 调用自定义SQL方法
        userMapper.updateBalanceByIds(wrapper, amount);
    }
}
