package com.zxk.service;

import com.zxk.domain.User;

public interface UserService {
    /**
     * 登陆
     * @param loginname
     * @param password
     * @return
     */
    Boolean login(String loginname, String password);

    Integer insert(User user);
}
