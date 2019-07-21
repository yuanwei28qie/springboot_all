package com.study.cn.springbootall.study;

import org.junit.jupiter.api.Test;

/**
 * @author huWei
 * @date 2019/7/21 23:24
 * <p> description: 进制学习
 */
class SystemOperationTest {
    /**
     * java中的进制转换的方法
     */
    @Test
    void  tenToOther(){
        //十进制转十六进制
        System.out.println(Integer.toHexString(57));
        //十进制转二进制
        System.out.println(Integer.toBinaryString(57));
        //十进制转八进制
        System.out.println(Integer.toOctalString(57));


        //二进制转换成十进制
        System.out.println(Integer.parseInt("111001",2));
        //八进制转换成十进制
        System.out.println(Integer.parseInt("27",8));
        //十六进制转换成十进制
        System.out.println(Integer.parseInt("A8",16));
    }
}