package com.zxk.Sql;

import org.apache.ibatis.annotations.Param;

/**
 * @program: StudentManagerMyBatis
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-14 16:48
 **/
public class ReturnSql {

    public static String getSelectConditions(@Param("name") String name, @Param("score") String score) {
        StringBuilder s = new StringBuilder("select * from student where 1=1");
        if (name != null && name.length() != 0) {
            s.append(" and name like #{name}");
            //cast(id as char)
        }
        if (name != null && name.length() != 0) {
            s.append(" and score like #{score}");
            //s.append(" and cast(score as char like #{score}");
        }
        return s.toString();
    }
}
