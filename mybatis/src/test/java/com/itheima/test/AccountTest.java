package com.itheima.test;

import com.itheima.UserDao.AccountDao;
import com.itheima.UserDao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession session;
    private AccountDao dao;
    @Before//程序开始时执行
    public void init()throws Exception{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sql SessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口代理对象
        dao=session.getMapper(AccountDao.class);
    }
    @After//程序结束后执行
    public void destroy()throws Exception{
        session.commit();
        session.close();
        in.close();
    }

/**
 * 查询所有
 */
@Test
public void findAllAccount(){
 List<AccountUser> list=dao.findAllAccount();
    for (AccountUser account : list) {
        System.out.println(account);
    }

    }
}

