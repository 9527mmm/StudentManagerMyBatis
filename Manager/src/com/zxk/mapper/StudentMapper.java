package com.zxk.mapper;

import com.zxk.Sql.ReturnSql;
import com.zxk.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();


    @Delete("delete from student where id=#{id}")
    Integer delete(Integer id);

    @Select("select * from student where id=#{id}")
    Student selectByID(Integer id);

    @Select("update student set name=#{name},age=#{age},gender=#{gender},score=#{score},bir=#{bir} where id=#{id}")
    Integer update(Student student);

    @Insert("insert into student values (#{id},#{name},#{age},#{gender},#{score},#{bir})")
    Integer insert(Student student);

    @SelectProvider(type = ReturnSql.class,method = "getSelectConditions")
    List<Student> selectConditions(@Param("name") String name, @Param("score") String score);
}
