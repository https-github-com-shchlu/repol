package com.scl.dao;

import com.scl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: chenglu
 * Date: 2019/11/18
 * Description:
 */

public class UserDaoTest {
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private UserDao mapper = null;
    SqlSession sqlSession = null;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        inputStream.close();
    }

    // 查询所有
    @Test
    public void findAll() throws IOException {
        List<User> users = mapper.findAll();
        System.out.println(users);
    }

    // 插入一条数据
    @Test
    public void insert() {
        User user = new User();
        user.setName("詹姆斯");
        user.setAge(30);
        user.setEmail("zhanmusi@163.com");
        int rest = mapper.insert(user);
        System.out.println(rest);
        sqlSession.commit();
    }

    @Test
    public void findOne() {
        User one = mapper.findOne(9);
        System.out.println(one);
    }

    @Test
    public void delete() {
        int rest = mapper.delete(10);
        System.out.println(rest);
        sqlSession.commit();
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1L);
        user.setName("公孙离");
        user.setAge(18);
        user.setEmail("gongsunli@163.com");
        int rest = mapper.update(user);
        sqlSession.commit();
        Assert.assertEquals(rest,1);
    }

    @Test
    public void insertList() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("公孙离"+i);
            user.setAge(15+i);
            user.setEmail("gongsunli"+i+"@163.com");
            list.add(user);
        }
        int rest = mapper.insertList(list);
        System.out.println(rest);
        sqlSession.commit();
    }
}