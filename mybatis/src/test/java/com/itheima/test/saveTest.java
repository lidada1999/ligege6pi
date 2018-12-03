package com.itheima.test;

import com.itheima.UserDao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class saveTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao dao;
@Before//程序开始时执行
    public void init()throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sql SessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(in);
        //3.使用工厂生产SqlSession对象
         session = factory.openSession();
        //4.使用SqlSession创建Dao接口代理对象
         dao=session.getMapper(IUserDao.class);
    }
    @After//程序结束后执行
    public void destroy()throws Exception{
    session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {


        List<User> list=dao.findAll();
        for (User user : list) {
            System.out.println(user);
        }


    }
    @Test
public void testSave(){
        User user =new User();
        user.setUsername("余树龙");
        user.setBirthday(new Date());
        user.setAddress("北京市不孕不育医院");
        user.setSex("男");
        dao.saveUser(user);
}
@Test
public void updateTest(){
    User user=new User();
   user.setId(43);
   user.setUsername("update user");
   user.setBirthday(new Date());
   user.setSex("女");
   user.setAddress("大北京");
   dao.updateUser(user);
}
}
