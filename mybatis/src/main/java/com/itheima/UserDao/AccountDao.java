package com.itheima.UserDao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    List<Account>findAll();


    List<AccountUser>findAllAccount();
}
