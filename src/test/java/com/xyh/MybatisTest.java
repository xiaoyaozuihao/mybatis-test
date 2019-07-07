package com.xyh;

import com.xyh.mybatis.entity.User;
import com.xyh.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: xuyh
 * @create: 2019/7/6
 **/
public class MybatisTest {

    public SqlSessionFactory getBuild(){
        SqlSessionFactory build=null;
        try(InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")){
            build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return build;
    }

    @Test
    public void testSelectOne(){
        SqlSession session = getBuild().openSession();
        User user = session.selectOne("com.xyh.mybatis.mapper.UserMapper.getOne", 1);
        System.out.println(user);
        //        session.close();
//        session= getBuild().openSession();
//        session.selectOne("com.xyh.mybatis.mapper.UserMapper.getOne", 1);
    }

    @Test
    public void testGetMapper(){
        SqlSessionFactory build = getBuild();
        SqlSession session = build.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println(mapper.getClass());
        System.out.println(mapper.getOne(1));
//        mapper.insert(new User(2,21,"haha"));
        SqlSession session1= build.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        System.out.println(mapper1.getOne(1));
        System.out.println(mapper1.selectOne(1));
        System.out.println(mapper1.selectOne(1));
    }

    @Test
    public void testGetClass(){
        MybatisTest mybatisTest=new MybatisTest();
        Method[] methods = mybatisTest.getClass().getMethods();
        Method method = methods[0];
        System.out.println(method);
        System.out.println(method.getClass());
        System.out.println(method.getDeclaringClass());
    }
}
