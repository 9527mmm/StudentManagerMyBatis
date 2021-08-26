package com.zxk.service;

import com.zxk.domain.User;
import com.zxk.mapper.UserMapper;
import com.zxk.utils.MapperUtils;

/**
 * @program: StudentManagerMyBatis
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-13 12:09
 **/
public class UserServiceImpl implements UserService {
    @Override
    public Boolean login(String loginname, String password) {
        try {
            UserMapper mapper = MapperUtils.getMapper(UserMapper.class);
            User login = mapper.login(loginname, password);
            if (login != null) {
                return true;
            }
            MapperUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return false;
    }

    @Override
    public Integer insert(User user) {
        try {
            UserMapper mapper = MapperUtils.getMapper(UserMapper.class);
            Integer i=mapper.insert(user);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }

        return -1;
    }
}
