package com.zxk.mapper;

import com.zxk.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where loginname=#{loginname} and password=#{password}")
    User login(@Param("loginname") String loginname, @Param("password") String password);

    @Insert("insert into user values (#{uid},#{ucode},#{loginname},#{password},#{username},#{gender},#{birthday},#{dutydate})")
    Integer insert(User user);
}
