package com.zhangwei.proxy.cglib;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:46 PM
 * @since 1.0.0
 **/
public class CglibTest {
    public static void main(String[] args) {
        CglibPersion persion = (CglibPersion) new CglibMeipo().getInstance(CglibPersion.class);
        persion.findLove();
    }
}
