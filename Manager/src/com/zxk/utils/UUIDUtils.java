package com.zxk.utils;

import java.util.UUID;

/**
 * @program: JDBC_ONE
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-09 08:57
 **/
public class UUIDUtils {
    private UUIDUtils(){}

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }
}
