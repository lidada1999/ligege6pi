package com.itheima.UserDao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
   void saveUser(User user);

   void updateUser(User user);
}
