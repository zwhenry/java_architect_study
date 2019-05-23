package com.zhangwei.factory.simple;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:11 PM
 * @since 1.0.0
 **/
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();
        factory.getMilk("伊利");
    }
}
