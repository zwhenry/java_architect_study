package com.zhangwei.proxy.custom;

import com.zhangwei.proxy.jdk.ZhangWei;
import com.zhangwei.proxy.staticed.Person;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:51 PM
 * @since 1.0.0
 **/
public class CustomPorxyTest {

    public static void main(String[] args) {
        try {
            Person obj = (Person)new CustomMeipo().getInstance(new ZhangWei());
//            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
