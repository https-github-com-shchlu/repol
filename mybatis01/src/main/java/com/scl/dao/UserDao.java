package com.scl.dao;

import com.scl.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chenglu
 * Date: 2019/11/18
 * Description:
 */

public interface UserDao{
    // 查询所有用户
    List<User> findAll();

    // 根据用户id查询
    User findOne(Integer id);

    // 插入一条用户数据
    int insert(User user);
    int insertList(List<User> users);

    // 删除用户
    int delete(Integer id);

    // 更新用户
    int update(User user);



}
